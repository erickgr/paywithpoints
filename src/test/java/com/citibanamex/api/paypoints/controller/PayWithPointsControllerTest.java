package com.citibanamex.api.paypoints.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.context.WebApplicationContext;

import com.citibanamex.api.paypoints.PayWithPointsApplication;
import com.citibanamex.api.paypoints.model.EnablementRequest;
import com.citibanamex.api.paypoints.model.IsEligible;
import com.citibanamex.api.paypoints.service.PayPointService;
import com.fasterxml.jackson.databind.ObjectMapper;





@RunWith(SpringRunner.class)
//@SpringBootTest(classes = PayWithPointsApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//@SpringBootTest(classes=PayPointsController.class)	
@WebMvcTest(PayPointsController.class)
@ComponentScan("com.citibanamex.api.paypoints")
public class PayWithPointsControllerTest {

	private IsEligible eligible;
	
	private EnablementRequest enablementRequest;
	
	@MockBean
	private PayPointService payPointService;
		
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void before(){
		MockitoAnnotations.initMocks(this);
		
		eligible = new IsEligible();
		eligible.setEligibilityIndicator("E");
		
		enablementRequest = new EnablementRequest();
		enablementRequest.setCloakedCreditCardNumber("cloaked");
		enablementRequest.setEnableProgramIndicator(false);
		enablementRequest.setMerchantCode("merchant");
		enablementRequest.setRewardLinkCode("link");
		enablementRequest.setRewardProgram("rewardOro");
	}
	@Ignore
	@Test
	public void testGetcheckPoints() throws Exception {
		String cloakedCreditCardNumber = "sha-11";
		String rewardProgram ="dont know", merchantCode="23422";
		String Authorization ="true" ;
		String uuid = "2342d";
		String Accept = "application/json";
		String client_id = "2342";
		String countryCode = "mex";
	    
		when(payPointService.checkRewards(cloakedCreditCardNumber)).thenReturn(eligible);
		mockMvc.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility",cloakedCreditCardNumber).param("rewardProgram", rewardProgram)
				.param("merchantCode", merchantCode).header("Authorization", Authorization).header("uuid", uuid)
				.header("Accept", Accept).header("client_id", client_id).header("countryCode", countryCode))
		        .andExpect(status().isOk()).andDo(print());
	}

//	@Ignore
	@Test
	public void testUpadadteRewards()throws Exception {
		EnablementRequest enablementRequest = new EnablementRequest();
		
		
		String countryCode="lo";
		String businessCode="jh";
		String Authorization="ll";
		String uuid="dsd";
		String Accept="application/json";
		String client_id= "yt";
		
		ObjectMapper oj= new ObjectMapper();
		String json=oj.writeValueAsString(enablementRequest);
//		when(payPointService.updatePayPoints(enablementRequest)).thenReturn(HttpStatus.OK);
		mockMvc.perform(put("/v1/rewards/enablement").contentType(MediaType.APPLICATION_JSON).content(json)
				.header("countryCode", countryCode).header("businessCode", businessCode)
				.header("Authorization", Authorization).header("uuid", uuid).header("Accept", Accept).header("client_id", client_id))
		        .andExpect(status().isOk()).andDo(print());
	}
}
