package com.yeti.core.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.host.HostCompany;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "HostCompany", path = "HostCompanies")
public interface HostCompanyRepository extends JpaRepository<HostCompany, Integer> {  //Entity, Id

}
