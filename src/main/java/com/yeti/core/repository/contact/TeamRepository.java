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

import com.yeti.model.contact.Contact;
import com.yeti.model.contact.Team;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Team", path = "Teams")
public interface TeamRepository extends JpaRepository<Team, Integer> {  //Entity, Id
		
    @Async
	@Query("SELECT t FROM Team t WHERE ("
			+ "LOWER(t.name) LIKE %:searchTerm% OR "
			+ "LOWER(t.description) LIKE %:searchTerm%)")
	public Future<List<Team>> searchTeamsByTerm(@Param("searchTerm") String searchTerm);
	
	public List<Team> findDistinctByContactsIn(Set<Contact> contact);
	

}



