package com.yeti.core.repository.campaign;

import java.util.List;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.campaign.Campaign;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Campaign", path = "Campaigns")
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {  //Entity, Id

	@Query
	public List<Campaign> findAll(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList);

	@Query
	public Campaign findOne(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("campaignId") Integer campaignId); 
	
	@Query
	public boolean exists(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("campaignId") Integer campaignId);
	
	@Query("SELECT c FROM Campaign c WHERE c.campaignId in (:campaignIds) "
			+ "AND ( (c.scopeType.scopeTypeId = 'PA') "
			+ "or "
			+ "(c.scopeType.scopeTypeId = 'PR' and c.ownerId = :userId) "
			+ "or "
			+ "(c.scopeType.scopeTypeId = 'SH' and c.teamId in :teamList) )")
	public List<Campaign> findAll(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("campaignIds") List<Integer> campaignIds);
	
	@Async
	@Query("SELECT c FROM Campaign c WHERE (LOWER(c.name) LIKE %:searchTerm% OR LOWER(c.description) LIKE %:searchTerm%) "
			+ "AND ( (c.scopeType.scopeTypeId = 'PA') "
			+ "or "
			+ "(c.scopeType.scopeTypeId = 'PR' and c.ownerId = :userId)"
			+ "or "
			+ "(c.scopeType.scopeTypeId = 'SH' and c.teamId in :teamList) )"
		)
	public Future<List<Campaign>> searchCampaignsByTerm(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("searchTerm") String searchTerm);

	@Query("SELECT c FROM Campaign c, IN(c.actions) a where a.actionId = :actionId "
			+ "AND ( (c.scopeType.scopeTypeId = 'PA') "
			+ "or "
			+ "(c.scopeType.scopeTypeId = 'PR' and c.ownerId = :userId) "
			+ "or "
			+ "(c.scopeType.scopeTypeId = 'SH' and c.teamId in :teamList) )")
	public List<Campaign> retrieveCampaignsForAction(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("actionId") Integer actionId);

	@Query("SELECT c FROM Campaign c, IN(c.companies) a where a.companyId = :companyId "
			+ "AND ( (c.scopeType.scopeTypeId = 'PA') "
			+ "or "
			+ "(c.scopeType.scopeTypeId = 'PR' and c.ownerId = :userId)"
			+ "or "
			+ "(c.scopeType.scopeTypeId = 'SH' and c.teamId in :teamList) )")
	public List<Campaign> retrieveCampaignsForCompany(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("companyId") Integer companyId);

	@Query("SELECT c FROM Campaign c, IN(c.contacts) a where a.contactId = :contactId "
			+ "AND ( (c.scopeType.scopeTypeId = 'PA') "
			+ "or "
			+ "(c.scopeType.scopeTypeId = 'PR' and c.ownerId = :userId)"
			+ "or "
			+ "(c.scopeType.scopeTypeId = 'SH' and c.teamId in :teamList) )")
	public List<Campaign> retrieveCampaignsForContact(
			@Param("userId") Integer userId, 
			@Param("teamList") List<Integer> teamList, 
			@Param("contactId") Integer contactId);
}
