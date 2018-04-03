package com.yeti.core.repository.types;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.ActionClassificationType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ActionClassificationType", path = "ActionClassificationTypes")
public interface ActionClassificationTypeRepository extends JpaRepository<ActionClassificationType, String> {  //Entity, Id

}
