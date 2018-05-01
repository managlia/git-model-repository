package com.yeti.core.repository.contact;

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
import com.yeti.model.contact.Contact;
import com.yeti.model.contact.Team;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Contact", path = "Contacts")
public interface ContactRepository extends JpaRepository<Contact, Integer> {  //Entity, Id

	public List<Contact> findByCompanyId(Integer companyId); 

    @Async
	@Query("SELECT c FROM Contact c WHERE ("
			+ "LOWER(c.firstName) LIKE %:searchTerm% OR "
			+ "LOWER(c.lastName) LIKE %:searchTerm% OR "
			+ "LOWER(c.description) LIKE %:searchTerm%)")
	public Future<List<Contact>> searchContactsByTerm(@Param("searchTerm") String searchTerm);

    @Async
	@Query("SELECT c FROM Contact c WHERE c.companyId = :companyId AND ("
			+ "LOWER(c.firstName) LIKE %:searchTerm% OR "
			+ "LOWER(c.lastName) LIKE %:searchTerm% OR "
			+ "LOWER(c.description) LIKE %:searchTerm%)")
	public Future<List<Contact>> searchContactsByTermAndHost(
			@Param("searchTerm") String searchTerm,
			@Param("companyId") Integer companyId
			);
    
    public List<Contact> findDistinctByActionsIn(Set<Action> actions);
	
	public List<Contact> findDistinctByCampaignsIn(Set<Campaign> campaigns);

	public List<Contact> findDistinctByTeamsIn(Set<Team> campaigns);
}
