package com.ibm.finaops.services;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.finaops.model.CustomerAccountDetails;
import com.ibm.finaops.model.FundTranferRes;
import com.ibm.finaops.model.FundTransferTO;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



public class FundTransferService {

	//final String BACK_END_SERVICE_URL = "https://finaops-bold-hartebeest.eu-gb.mybluemix.net/api/transferAmount";
	final String BACK_END_SERVICE_URL = "https://iciciservice-bold-hartebeest.eu-gb.mybluemix.net/api/transferAmount";
	final String SUCCESS_MESSAGE = "Fund Transferred Successfully !!";
	final String FAILURE_MESSAGE = "Fund Transfer Failed - ";

	@Autowired
	FundTranferRes responseEntity;

	RestTemplate restTemplate = new RestTemplate();

	public String initiateFundTransfer(FundTransferTO fTrfTO)
			throws JsonGenerationException, JsonMappingException, IOException, JSONException {
		
		FundTranferRes responseEntity = new FundTranferRes();

		MultiValueMap<String, String> body = new LinkedMultiValueMap<String, String>();

		body.add("accNo1", fTrfTO.getFromAcct());
		body.add("accNo2", fTrfTO.getToAcct());
		body.add("amount", fTrfTO.getTrfAmnt());

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("my-header", fTrfTO.getHeaderData());

		HttpEntity<?> entity = new HttpEntity<Object>(body, headers);

		responseEntity = restTemplate.postForObject(BACK_END_SERVICE_URL, entity, FundTranferRes.class);
		JSONObject jsonObj = new JSONObject();
		if (responseEntity.getResult().equalsIgnoreCase("success"))
			jsonObj.put("message", SUCCESS_MESSAGE);
		else
			jsonObj.put("message", FAILURE_MESSAGE + "- " + responseEntity.getResult());

		return jsonObj.toString();
	}

	public String initiateFundTransferMock(FundTransferTO fTrfTO)
			throws JsonGenerationException, JsonMappingException, IOException, JSONException {
		ObjectMapper mapper = new ObjectMapper();
		FundTranferRes responseEntity = mapper.readValue(new File("src/main/resources/fundTransferSucess.json"), FundTranferRes.class);
		JSONObject jsonObj = new JSONObject();
		if (responseEntity.getResult().equalsIgnoreCase("success"))
			jsonObj.put("message", SUCCESS_MESSAGE);
		else
			jsonObj.put("message", FAILURE_MESSAGE + "- " + responseEntity.getResult());

		return jsonObj.toString();
	}

	

}
