package com.yeti.core.repository.types;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.company.CompanyClassificationType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "CompanyClassificationType", path = "CompanyClassificationTypes")
public interface CompanyClassificationTypeRepository extends JpaRepository<CompanyClassificationType, String> {  //Entity, Id
	  //Entity, Id

}
