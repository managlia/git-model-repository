package com.yeti.core.repository.action;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.Action;
import com.yeti.model.campaign.Campaign;
import com.yeti.model.company.Company;
import com.yeti.model.contact.Contact;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Action", path = "Actions")
public interface ActionRepository extends JpaRepository<Action, Integer> {  //Entity, Id

	@Query
	List<Action> findAll(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList);

	@Query
	public Action findOne(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("actionId") Integer actionId);
	
	@Query
	public boolean exists(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("actionId") Integer actionId);
	
	@Query("SELECT a FROM Action a WHERE a.actionId in (:actionIds) "
			+ "AND ( (a.scopeType.scopeTypeId = 'PA') "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'PR' and a.ownerId = :userId) "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'SH' and a.teamId in :teamList) )")
	public List<Action> findAll(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("actionIds") List<Integer> actionIds);
	
	@Async
	@Query("SELECT a FROM Action a WHERE (LOWER(a.name) LIKE %:searchTerm% OR LOWER(a.description) LIKE %:searchTerm%) "
			+ "AND ( (a.scopeType.scopeTypeId = 'PA') "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'PR' and a.ownerId = :userId) "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'SH' and a.teamId in :teamList) )"
		)
	public Future<List<Action>> searchActionsByTerm(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("searchTerm") String searchTerm);

	@Query("SELECT a FROM Action a, IN(a.companies) c where c.companyId = :companyId "
				+ "AND ( (a.scopeType.scopeTypeId = 'PA') "
				+ "or "
				+ "(a.scopeType.scopeTypeId = 'PR' and a.ownerId = :userId) "
				+ "or "
				+ "(a.scopeType.scopeTypeId = 'SH' and a.teamId in :teamList) )")
	public Iterable<Action> retrieveActionsForCompany(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("companyId") Integer companyId);

	@Query("SELECT a FROM Action a, IN(a.campaigns) c where c.campaignId = :campaignId "
			+ "AND ( (a.scopeType.scopeTypeId = 'PA') "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'PR' and a.ownerId = :userId) "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'SH' and a.teamId in :teamList) )")
	public List<Action> retrieveActionsForCampaign(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("campaignId") Integer campaignId);

	@Query("SELECT a FROM Action a, IN(a.contacts) c where c.contactId = :contactId "
			+ "AND ( (a.scopeType.scopeTypeId = 'PA') "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'PR' and a.ownerId = :userId) "
			+ "or "
			+ "(a.scopeType.scopeTypeId = 'SH' and a.teamId in :teamList) )")
	public List<Action> retrieveActionsForContact(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("contactId") Integer contactId);
}
