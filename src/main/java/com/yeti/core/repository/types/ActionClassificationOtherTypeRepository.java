package com.yeti.core.repository.types;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.ActionClassificationOtherType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ActionClassificationOtherType", path = "ActionClassificationOtherTypes")
public interface ActionClassificationOtherTypeRepository extends JpaRepository<ActionClassificationOtherType, Integer> {  //Entity, Id

}

