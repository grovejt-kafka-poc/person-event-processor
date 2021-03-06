package com.dsths.kafkapoc.personeventprocessor.personevent;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.dsths.kafkapoc.personservice.personevent.PersonEventMessage;

@Configuration
public class KafkaConfig {

	@Value("${kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Bean
	public Map<String, Object> consumerConfigs() {

		Map<String, Object> props = new HashMap<>();

		// list of host:port pairs used for establishing the initial connections to the Kafka cluster
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);

		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, LongDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);

//		props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.dsths.kafkapoc.personservice.personevent");
//		props.put(JsonDeserializer.TRUSTED_PACKAGES, "com.dsths.kafkapoc.personservice.personevent.PersonEventMessage");
		props.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
		
		// allows a pool of processes to divide the work of consuming and processing records
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "personEvents");

		// automatically reset the offset to the earliest offset
		props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

		return props;
	}
	
	  @Bean
	  public ConsumerFactory<Long, PersonEventMessage> consumerFactory() {
		    return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new LongDeserializer(),
		            new JsonDeserializer<>(PersonEventMessage.class));
	  }

	  @Bean
	  public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Long, PersonEventMessage>> kafkaListenerContainerFactory() {
	    ConcurrentKafkaListenerContainerFactory<Long, PersonEventMessage> factory =
	        new ConcurrentKafkaListenerContainerFactory<>();
	    factory.setConsumerFactory(consumerFactory());

	    return factory;
	  }

	  @Bean
	  public PersonEventProcessor personEventProcessor() {
	    return new PersonEventProcessor();
	  }	
}
