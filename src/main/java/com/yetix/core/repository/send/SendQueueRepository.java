package com.yetix.core.repository.send;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yetix.model.send.SendQueue;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "SendQueue", path = "SendQueues")
public interface SendQueueRepository extends JpaRepository<SendQueue, Integer> {

}