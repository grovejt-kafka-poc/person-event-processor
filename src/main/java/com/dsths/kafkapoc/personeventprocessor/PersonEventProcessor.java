package com.dsths.kafkapoc.personeventprocessor;


import org.springframework.kafka.annotation.KafkaListener;

import com.dsths.kafkapoc.personservice.person.PersonEvent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PersonEventProcessor {

	  @KafkaListener(topics = "${kafka.topic.personEvent}")
	  public void receive(PersonEvent personEvent) {
	    log.info("received personEvent='{}'", personEvent);
	    //TODO: call the get person api on the person-service and then insert/update that person in the people database.
	  }
}
