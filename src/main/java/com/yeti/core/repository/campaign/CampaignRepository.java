package com.yeti.core.repository.campaign;

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
@RepositoryRestResource(collectionResourceRel = "Campaign", path = "Campaigns")
public interface CampaignRepository extends JpaRepository<Campaign, Integer> {  //Entity, Id

    @Async
	@Query("SELECT c FROM Campaign c WHERE ("
			+ "LOWER(c.name) LIKE %:searchTerm% OR "
			+ "LOWER(c.description) LIKE %:searchTerm%)")
	public Future<List<Campaign>> searchCampaignsByTerm(@Param("searchTerm") String searchTerm);

    public List<Campaign> findDistinctByActionsIn(Set<Action> actions);

	public List<Campaign> findDistinctByCompaniesIn(Set<Company> ts);

	public List<Campaign> findDistinctByContactsIn(Set<Contact> ts);
	
	
}
