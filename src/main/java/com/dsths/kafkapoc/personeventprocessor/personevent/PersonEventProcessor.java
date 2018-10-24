package com.dsths.kafkapoc.personeventprocessor.personevent;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.dsths.kafkapoc.personservice.personevent.PersonEventMessage;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonEventProcessor {

	@Autowired
	PersonEventRepository personEventRepository;
	
	  @KafkaListener(topics = "${kafka.topic.personEvent}")
	  public void receive(PersonEventMessage personEventMessage) {
	    log.info("received personEventMessage='{}'", personEventMessage);
	    
	    PersonEvent personEvent = new PersonEvent(personEventMessage.getEventType(), personEventMessage.getPersonId());
	    personEvent.setEventStatus(EventStatus.RECEIVED);
	    personEventRepository.save(personEvent);
	    
	    //TODO: call the get person api on the mab-person-service to get the latest version of the person 
	    
	    //insert/update that member in the MEMBER table:
	    
	    //update the person event to processed:
	    
	  }
}
