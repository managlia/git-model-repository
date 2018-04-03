package com.yeti.core.repository.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.Conversation;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "Conversation", path = "Conversations")
public interface ConversationRepository extends JpaRepository<Conversation, Integer> {  //Entity, Id


}
