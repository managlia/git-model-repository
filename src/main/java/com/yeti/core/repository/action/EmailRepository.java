package com.yeti.core.repository.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.Email;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Email", path = "Emails")
public interface EmailRepository extends JpaRepository<Email, Integer> {  //Entity, Id


}
