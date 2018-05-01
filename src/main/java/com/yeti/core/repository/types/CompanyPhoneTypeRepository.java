package com.yeti.core.repository.types;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.company.CompanyPhoneType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "CompanyPhoneType", path = "CompanyPhoneTypes")
public interface CompanyPhoneTypeRepository extends CrudRepository<CompanyPhoneType, String> {  //Entity, Id

		
}
