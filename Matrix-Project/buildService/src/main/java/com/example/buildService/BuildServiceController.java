package com.example.buildService;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
@RequestMapping("build")
public class BuildServiceController {

	@Autowired 
	private BuildServiceService buildService;
	@Autowired
	private RestTemplate restTemplate;
	
	@PostMapping("postUser")
	public void postUser(@RequestBody UserModel user,HttpServletResponse response) {
		restTemplate.postForObject("http://shuffleArrayService/shuffle/arrayShuffle", user, String.class);
		try {
			response.sendRedirect("getUser");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("getUser")
	public ResponseEntity<Object> getUser(){
		while (buildService.jsonObject.isEmpty()) {
			
		}
		System.out.println("in the get user method " + buildService.jsonObject.toString());
		JSONObject jsonToReturn=new JSONObject(buildService.jsonObject.toString());
		buildService.setJsonObjectAsNull();
		return ResponseEntity.ok().body(jsonToReturn.toString());
	}
	
}
