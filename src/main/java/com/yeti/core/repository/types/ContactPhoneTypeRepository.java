package com.yeti.core.repository.types;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.contact.ContactPhoneType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ContactPhoneType", path = "ContactPhoneTypes")
public interface ContactPhoneTypeRepository extends CrudRepository<ContactPhoneType, String> {  //Entity, Id
		
}
