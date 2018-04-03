package com.yeti.core.repository.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.PlacedOrder;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "PlacedOrder", path = "PlacedOrders")
public interface PlacedOrderRepository extends JpaRepository<PlacedOrder, Integer> {  //Entity, Id


}
