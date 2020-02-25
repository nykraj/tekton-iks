package com.ibm.finaops.controller;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.ibm.finaops.model.AccountPostRequest;
import com.ibm.finaops.services.CustomerAccountsService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CustomerAccountController {

	@RequestMapping(method = RequestMethod.POST, value = "/getAccountDetail", produces = {
			MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public String getAccountDetail(@RequestBody AccountPostRequest inputPayload, @RequestHeader HttpHeaders header) {

		String result = new String("");

		try {
			String headerData = header.getFirst("my-header");
			String accntNum = inputPayload.getAccountNumber();
			CustomerAccountsService custAcctService = new CustomerAccountsService();
			result = custAcctService.getAccountDetailsForUserMock(accntNum, headerData);
		} catch (JsonGenerationException e) {
			result = e.getMessage();
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	

}
