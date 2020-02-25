package com.ibm.finaops.services;

import java.io.IOException;
import java.util.Arrays;


import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.finaops.model.FundTranferPushRes;
import com.ibm.finaops.model.FundTransferSessionTO;
import com.ibm.finaops.model.FundTransferToken;

public class FundTransferPushService {
	
	private final String AUTH_END_POINT="http://119.81.79.228:30258/mfp/api/az/v1/token";
	private final String PUSH_END_POINT="http://119.81.79.228:30258/imfpush/v1/apps/com.icicift/messages";
	
	RestTemplate restTemplate = new RestTemplate();
	
	
	public String saveAndSendFundTransferSession(FundTransferSessionTO fundTransferSessionObj)
			throws  IOException, JSONException {
		
		HttpHeaders accessHeaders = new HttpHeaders();
		accessHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		accessHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		accessHeaders.add("Authorization", "Basic dGVzdDp0ZXN0");
			//headers.set("my-header", fundTransferSessionObj.getHeaderData());
		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();
		body.add("grant_type", "client_credentials");
		body.add("scope", "messages.write tags.write messages.read tags.read push.application.com.icicift");

		HttpEntity<?> entity = new HttpEntity<Object>(body, accessHeaders);
		FundTransferToken responseEntity = restTemplate.postForObject(AUTH_END_POINT, entity, FundTransferToken.class);
		String token = responseEntity.getAccess_token();
		
		System.out.println("Service 1 Called and Token Value is - "+token);
		
		HttpHeaders pushHeaders = new HttpHeaders();
		pushHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		pushHeaders.setContentType(MediaType.APPLICATION_JSON);
		pushHeaders.add("Authorization", "Bearer "+token);
		ObjectMapper mapper = new ObjectMapper();
		String bodyJSON_OBJECT = mapper.writeValueAsString(fundTransferSessionObj);
		String userId = fundTransferSessionObj.getUserId();
				
		MultiValueMap<String, String> bodyPush = new LinkedMultiValueMap<String, String>();
		
//		String bodyJSON_PART1 = "{ \"message\":{\"alert\":"
//				+"\"Dear "+userId+", You have an in-progress fund transfer from our website. Do you wish to continue from where you left?\" },\r\n"; 
				
		String bodyMessage = "{ \"message\":{\"alert\":"
				+"\"Dear "+userId+", You have an in-progress fund transfer from our website. Do you wish to continue from where you left?\" },\r\n";  
		String notification = "\"notificationType\": 1,";
		String bodyTarget = "\"target\": { \"tagNames\":[\""+userId+"\"]},";
		String settings = "\"settings\" : {\r\n" + 
				"        \"gcm\" : {\r\n" + 
				"        \"payload\" : \r\n" + bodyJSON_OBJECT + 
				"    }\r\n" + 
				"    }\r\n" +
				"    }";
		
		String bodyJSON = bodyMessage+notification+bodyTarget+settings;
				
		bodyPush.add("message", bodyMessage);
		bodyPush.add("notificationType", "1");
		bodyPush.add("target", bodyTarget);
		bodyPush.add("settings", settings);
		
//		JSONObject newbodymessage = new JSONObject();
//		newbodymessage.put("alert", "Test message");
//
//		JSONObject bodytarget = new JSONObject();
//		bodytarget.put("tagNames", "sunil");
//
//		JSONObject gcmpayload = new JSONObject();
//		gcmpayload.put("test", "123222");
//
//		JSONObject settingsgcm = new JSONObject();
//		settingsgcm.put("payload",gcmpayload);
//
//		JSONObject bodysettings = new JSONObject();
//		bodysettings.put("gcm",settingsgcm);
//
//		bodyPush.add("message", newbodymessage.toString());
//		bodyPush.add("notificationType", "1");
//		bodyPush.add("target", bodytarget.toString());
//		bodyPush.add("settings", bodysettings.toString());

		System.out.println("BODY JSON =  "+bodyJSON);
		
		HttpEntity<?> entityPush = new HttpEntity<Object>(bodyJSON, pushHeaders);
		
		RestTemplate restTemplatePush = new RestTemplate();
		
		Object resultEntity = restTemplatePush.postForObject(PUSH_END_POINT, entityPush, Object.class);

		return mapper.writeValueAsString(resultEntity);
	}

}
