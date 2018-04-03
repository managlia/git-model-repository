package com.yeti.core.repository.types;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.contact.ContactTitleType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ContactTitleType", path = "ContactTitleTypes")
public interface ContactTitleTypeRepository extends JpaRepository<ContactTitleType, Integer> {  //Entity, Id

}
