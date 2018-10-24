package com.dsths.kafkapoc.personeventprocessor.personevent;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class PersonEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Enumerated(EnumType.STRING)
	private PersonEventType eventType;
	
	private Long personId;
	
	@Enumerated(EnumType.STRING)
	private EventStatus EventStatus;
	
	private String processingFailureException;
	
	public PersonEvent() {};
	
	public PersonEvent(PersonEventType eventType, Long personId) {
		this.eventType = eventType;
		this.personId = personId;
	}

}

enum EventStatus {

	RECEIVED, PROCESSING, PROCESSED, PROCESSING_FAILED;
}
