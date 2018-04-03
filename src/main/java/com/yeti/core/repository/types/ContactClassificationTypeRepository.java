package com.yeti.core.repository.types;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.contact.ContactClassificationType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ContactClassificationType", path = "ContactClassificationTypes")
public interface ContactClassificationTypeRepository extends JpaRepository<ContactClassificationType, String> {  //Entity, Id

}
