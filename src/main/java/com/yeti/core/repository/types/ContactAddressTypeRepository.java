package com.yeti.core.repository.types;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.contact.ContactAddressType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ContactAddressType", path = "ContactAddressTypes")
public interface ContactAddressTypeRepository extends JpaRepository<ContactAddressType, String> {  //Entity, Id


}
