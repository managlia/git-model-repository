package com.yeti.core.repository.company;

import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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
@RepositoryRestResource(collectionResourceRel = "Company", path = "Companies")
public interface CompanyRepository extends JpaRepository<Company, Integer> {  //Entity, Id

    @Async
	@Query("SELECT c FROM Company c WHERE ("
			+ "LOWER(c.name) LIKE %:searchTerm% OR "
			+ "LOWER(c.description) LIKE %:searchTerm%)")
	public Future<List<Company>> searchCompaniesByTerm(@Param("searchTerm") String searchTerm);
	
	public List<Company> findDistinctByActionsIn(Set<Action> actions);
		
	public List<Company> findDistinctByCampaignsIn(Set<Campaign> campaigns);
	
	public List<Company> findDistinctByContactsIn(Set<Contact> contacts);
	/*
	@Modifying
	@Query("UPDATE Company c SET "
			+ "c.campaigns = :campaignSet "
			+ "WHERE c.companyId = :companyId")
	public void updateCompanyCampaigns(@Param("companyId") Integer companyId, @Param("campaignSet") Set<Campaign> campaignSet);
	*/
	
	
	
}