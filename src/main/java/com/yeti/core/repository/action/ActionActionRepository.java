package com.yeti.core.repository.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.ActionAction;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ActionAction", path = "ActionActions")
public interface ActionActionRepository extends JpaRepository<ActionAction, Integer> {  //Entity, Id


}
