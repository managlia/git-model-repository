package com.yeti.core.repository.types;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.contact.ContactUrlType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ContactUrlType", path = "ContactUrlTypes")
public interface ContactUrlTypeRepository extends CrudRepository<ContactUrlType, String> {  //Entity, Id
		
}
