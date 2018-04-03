package com.yeti.core.repository.types;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.general.ScopeType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "ScopeType", path = "ScopeTypes")
public interface ScopeTypeRepository extends CrudRepository<ScopeType, String> {  //Entity, Id
	
}
