package com.yeti.core.repository.types;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.campaign.CampaignClassificationType;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "CampaignClassificationType", path = "CampaignClassificationTypes")
public interface CampaignClassificationTypeRepository extends JpaRepository<CampaignClassificationType, Integer> {  //Entity, Id

}

