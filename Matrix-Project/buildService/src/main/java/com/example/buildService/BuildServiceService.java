package com.example.buildService;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.json.JSONObject;
import org.json.XML;

@Service
public class BuildServiceService {
	
	public JSONObject jsonObject=new JSONObject();

	@KafkaListener(topics = "mainTopic",groupId = "group_id")
	public void consume(String message) {
		System.out.println("I have listened enough, Thats my message:"+ message);	
		jsonObject=XML.toJSONObject(message);
		System.out.println("i have converted the message to Json for you: " + jsonObject.toString());
	}
	
	public void setJsonObjectAsNull() {
		this.jsonObject=null;
	}
}
