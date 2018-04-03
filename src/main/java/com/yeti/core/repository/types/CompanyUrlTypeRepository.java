package com.yeti.core.repository.types;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.company.CompanyUrlType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "CompanyUrlType", path = "CompanyUrlTypes")
public interface CompanyUrlTypeRepository extends CrudRepository<CompanyUrlType, String> {  //Entity, Id

		
}
