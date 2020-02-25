package com.ibm.finaops.services;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.finaops.model.CustomerAccountDetails;

public class CustomerAccountsService {

	final String BACKEND_SERVICE_URL = "http://iciciservice-bold-hartebeest.eu-gb.mybluemix.net/api/getCustomerAccountbyId?id=";

	public String getAccountDetailsForUser(String accntNum, String headerData)
			throws  IOException {
		RestTemplate restTemplate = new RestTemplate();
		ObjectMapper mapper = new ObjectMapper();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("my-header", headerData);
		HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		ResponseEntity<CustomerAccountDetails[]> respEntity = restTemplate.exchange(BACKEND_SERVICE_URL + accntNum,
				HttpMethod.GET, entity, CustomerAccountDetails[].class);
		
		System.out.println("JSON = ["+mapper.writeValueAsString(respEntity.getBody())+"]");
		
		CustomerAccountDetails custAcctDtls[] = respEntity.getBody();
		
		
		
		String responseString = null;

		int len = custAcctDtls.length;
		if (len == 1) {
			CustomerAccountDetails custAccntRecord = custAcctDtls[0];
			responseString = mapper.writeValueAsString(custAccntRecord);
		} 
		
		return responseString;
	}
	
	
	public String getAccountDetailsForUserMock(String accntNum, String headerData)
			throws  IOException {
		ObjectMapper mapper = new ObjectMapper();
		CustomerAccountDetails[] custAcctDtls = mapper.readValue(new File("src/main/resources/customerAccountData.json"), CustomerAccountDetails[].class);
		String responseString = null;

		int len = custAcctDtls.length;
		if (custAcctDtls.length!=0) {
			CustomerAccountDetails custAccntRecord = custAcctDtls[0];
			custAccntRecord.setAccountNumber(accntNum);
			responseString = mapper.writeValueAsString(custAccntRecord);
		} 
		
		return responseString;
	}

}
