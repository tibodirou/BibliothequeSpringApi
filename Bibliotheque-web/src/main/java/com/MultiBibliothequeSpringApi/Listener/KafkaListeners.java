/*
package com.MultiBibliothequeSpringApi.Listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.MultiBibliothequeSpringApi.controller.LivreResource;

@Component
public class KafkaListeners {
	
	Logger log = LoggerFactory.getLogger(LivreResource.class);

	@KafkaListener(topics = "bibliotheque", groupId = "groupId")
	void listener(String data) {
		log.trace("Listener received : " + data);
		
	}
	
}
*/