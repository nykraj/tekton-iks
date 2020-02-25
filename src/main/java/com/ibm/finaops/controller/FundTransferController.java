package com.ibm.finaops.controller;

import java.io.IOException;
import java.util.Random;


import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ibm.finaops.model.AccountPostRequest;
import com.ibm.finaops.model.FundTransferSessionTO;
import com.ibm.finaops.model.FundTransferTO;
import org.json.JSONException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.finaops.model.FundTransferRequest;
import com.ibm.finaops.services.FundTransferPushService;
import com.ibm.finaops.services.FundTransferService;



@RestController
public class FundTransferController {
	
	@RequestMapping(method = RequestMethod.POST, value = "/transferFund", 
			produces = { MediaType.APPLICATION_JSON_VALUE, 
						 MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public String doFundTransfer(@RequestBody FundTransferRequest inputPayload, @RequestHeader HttpHeaders header) {
		FundTransferService service = new FundTransferService();
		String headerData = header.getFirst("my-header");

		
		FundTransferTO fTrfTO = new FundTransferTO();
		fTrfTO.setFromAcct(inputPayload.getFromAcct());
		fTrfTO.setToAcct(inputPayload.getToAcct());
		fTrfTO.setTrfAmnt(inputPayload.getTrfAmnt());
		fTrfTO.setHeaderData(headerData);
		String result = null;
		try {
			result = service.initiateFundTransferMock(fTrfTO);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/saveAndSendFundTransferSession", 
			produces = { MediaType.APPLICATION_JSON_VALUE, 
						 MediaType.APPLICATION_XML_VALUE }, 
			consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public String saveAndSendFundTransferSession(@RequestBody FundTransferSessionTO inputPayload, @RequestHeader HttpHeaders header) {
		
		FundTransferPushService pushService = new FundTransferPushService();

		FundTransferSessionTO fundTransferSessionObj = new FundTransferSessionTO();
		//String headerData = header.getFirst("my-header");
		String response = null;

		
		Random randomNumber = new Random();
		
		fundTransferSessionObj.setTransactionNumber(String.valueOf(randomNumber.nextInt(10000)));
		fundTransferSessionObj.setUserId(inputPayload.getUserId());
		fundTransferSessionObj.setFromAccount(inputPayload.getFromAccount());
		fundTransferSessionObj.setFromAccountType(inputPayload.getFromAccountType());
		fundTransferSessionObj.setBeneficiaryName(inputPayload.getBeneficiaryName());
		fundTransferSessionObj.setToAccount(inputPayload.getToAccount());
		fundTransferSessionObj.setToAccountType(inputPayload.getToAccountType());
		fundTransferSessionObj.setTransferAmount(inputPayload.getTransferAmount());
		//fundTransferSessionObj.setHeaderData(headerData);
		
		try {
			response = pushService.saveAndSendFundTransferSession(fundTransferSessionObj);
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return response;
	}
}
