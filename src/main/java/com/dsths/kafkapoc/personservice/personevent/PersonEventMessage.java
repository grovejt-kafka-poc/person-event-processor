//package com.dsths.kafkapoc.personeventprocessor.personevent;
package com.dsths.kafkapoc.personservice.personevent;

import com.dsths.kafkapoc.personeventprocessor.personevent.PersonEventType;

import lombok.Data;

/**
 * This is the message for the person event that was read from kafka.
 * @author grove
 *
 */
@Data
public class PersonEventMessage {

	private PersonEventType eventType;

	private Long personId;

//	private final LocalDateTime createdTimestamp;

	public PersonEventMessage() {};
	
	public PersonEventMessage(PersonEventType eventType, Long personId) {
		this.eventType = eventType;
		this.personId = personId;
	}
//	public PersonEventMessage(PersonEventType eventType, Long personId, LocalDateTime createdTimestamp) {
//		this.eventType = eventType;
//		this.personId = personId;
//		this.createdTimestamp = createdTimestamp;
//	}
}



