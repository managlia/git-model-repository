package com.yeti.core.repository.types;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.OrderStateType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "OrderStateType", path = "OrderStateTypes")
public interface OrderStateTypeRepository extends JpaRepository<OrderStateType, String> {  //Entity, Id


}
