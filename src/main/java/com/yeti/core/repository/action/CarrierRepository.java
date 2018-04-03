package com.yeti.core.repository.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.general.Carrier;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Carrier", path = "Carriers")
public interface CarrierRepository extends JpaRepository<Carrier, String> {  //Entity, Id

	
}
