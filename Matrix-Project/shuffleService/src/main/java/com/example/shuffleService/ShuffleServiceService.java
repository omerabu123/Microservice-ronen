package com.example.shuffleService;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class ShuffleServiceService {

	private static final String TOPIC="mainTopic";
	
	@Autowired
	private KafkaTemplate<String , String> kafkaTemplate;
	
	public void sendToKafka(UserModel user) throws JSONException, JsonProcessingException {
		ObjectMapper mapper=new ObjectMapper();
		JSONObject json=new JSONObject(mapper.writeValueAsString(user));
		System.out.println("my json is : "+json);
		String xml=XML.toString(json);
		System.out.println("I converted it to XML for you, sending this : "+xml);
		kafkaTemplate.send(TOPIC,xml);
	}
}
