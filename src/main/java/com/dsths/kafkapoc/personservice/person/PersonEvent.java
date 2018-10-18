package com.dsths.kafkapoc.personservice.person;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class PersonEvent {

	private PersonEventType eventType;
	private Long personId;
//	private LocalDateTime timestamp;
	
	public PersonEvent() {};
	
	public PersonEvent(PersonEventType eventType, Long personId) {
		this.eventType = eventType;
		this.personId = personId;
	}


}
enum PersonEventType {
	CREATED, CHANGED, DELETED;
}
