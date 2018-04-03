package com.yeti.core.repository.action;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.yeti.model.action.CalendarEvent;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "CalendarEvent", path = "CalendarEvents")
public interface CalendarEventRepository extends JpaRepository<CalendarEvent, Integer> {  //Entity, Id


}
