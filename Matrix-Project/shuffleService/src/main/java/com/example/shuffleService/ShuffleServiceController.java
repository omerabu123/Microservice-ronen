package com.example.shuffleService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("shuffle")
public class ShuffleServiceController {


	@Autowired
	private ShuffleServiceService shuffleService;
	
	@PostMapping("arrayShuffle")
	public ResponseEntity<Object> shuffleTheArray(@RequestBody UserModel user){
//		List<Integer> list = Arrays.asList(array);
//		Collections.shuffle(list);
//		list.toArray(array);
//		shuffleService.sendToKafka(array);
		try {
			shuffleService.sendToKafka(user);
		} catch (JSONException | JsonProcessingException e) {
			// TODO Auto-generated catch block
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok().body("Produced shuffled array");
	}

}
