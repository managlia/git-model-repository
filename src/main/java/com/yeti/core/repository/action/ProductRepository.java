package com.yeti.core.repository.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.Product;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Product", path = "Products")
public interface ProductRepository extends JpaRepository<Product, String> {  //Entity, Id


}
