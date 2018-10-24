package com.dsths.kafkapoc.personeventprocessor;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.slf4j.Slf4j;

/**
 * See https://www.codenotfound.com/spring-kafka-embedded-unit-test-example.html
 * See https://blog.mimacom.com/testing-apache-kafka-with-spring-boot/
 * 
 * This test class focuses on the Receiver which
 * listens to topic topic as defined in the applications.yml properties
 * file. In order to check the correct working, we use a test-template to send a
 * message to this topic. All of the setup will be done before the test case
 * runs using the @Before annotation.
 * 
 * The producer properties are created using the static senderProps() method
 * provided by KafkaUtils. These properties are then used to create a
 * DefaultKafkaProducerFactory which is in turn used to create a KafkaTemplate.
 * Finally we set the default topic that the template uses.
 * 
 * We need to ensure that the Receiver is initialized before sending the test
 * message. For this we use the waitForAssignment() method of
 * ContainerTestUtils. The link to the message listener container is acquired by
 * auto-wiring the KafkaListenerEndpointRegistry which manages the lifecycle of
 * the listener containers that are not created manually.
 * 
 * Note that if you do not create the topics using the KafkaEmbedded constructor
 * you need to manually set the partitions per topic to 1 in the
 * waitForAssignment() method instead of getting the partitions from the
 * embedded Kafka server. The reason for this is that it looks like 1 is used as
 * a default for the number of partitions in case topics are created implicitly.
 * 
 * In the test, we send a person changed event and check that the event was received.
 * 
 * @author grove
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DirtiesContext
@EmbeddedKafka(topics = "${kafka.topic.personEvent}", count = 1, controlledShutdown = true)
@Slf4j
public class PersonEventProcessorTest {

	@Test
	public void testReceive() {
		//TODO - figure out how to test this.
	}

}
