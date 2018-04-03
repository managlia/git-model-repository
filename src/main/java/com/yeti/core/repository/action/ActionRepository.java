package com.yeti.core.repository.action;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

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

    @Async
	@Query("SELECT a FROM Action a WHERE ("
			+ "LOWER(a.name) LIKE %:searchTerm% OR "
			+ "LOWER(a.description) LIKE %:searchTerm%)")
	public Future<List<Action>> searchActionsByTerm(@Param("searchTerm") String searchTerm);

	public List<Action> findByDescriptionIgnoreCaseContaining(String actionDescription);
	
	public List<Action> findByNameIgnoreCaseContaining(String actionName);

	@Query("SELECT a FROM Action a WHERE a.isActive = :activeFlag")
	public List<Action> findUsingActiveFlag(@Param("activeFlag") Boolean activeFlag);

	public List<Action> findDistinctByCompaniesIn(Set<Company> companies);

	public List<Action> findDistinctByCampaignsIn(Set<Campaign> campaigns);

	public List<Action> findDistinctByContactsIn(Set<Contact> contacts);
	
}
