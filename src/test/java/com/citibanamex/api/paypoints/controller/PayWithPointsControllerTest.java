package com.citibanamex.api.paypoints.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
import com.citibanamex.api.paypoints.model.LinkStatus;
import com.citibanamex.api.paypoints.model.LinkageRequest;
import com.citibanamex.api.paypoints.model.PointBalance;
import com.citibanamex.api.paypoints.model.RedemptionOrderSummary;
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
	
	private PointBalance pointBalance;
	
	private RedemptionOrderSummary redemptionOrderSummary;
	
	private LinkStatus linkStatus;
	
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
		
		pointBalance = new  PointBalance();
		pointBalance.setAvailablePointBalance(100);
		pointBalance.setLocalCurrencyCode("MXN");
		pointBalance.setMaximumPointsToRedeem(20);
		pointBalance.setMinimumPointsToRedeem(30);
		pointBalance.setProgramConversionRate(23);
		pointBalance.setRedemptionEligible(true);
		pointBalance.setRedemptionPointIncrement(15);
		
		linkStatus = new LinkStatus();
		linkStatus.setRewardLinkCode(":D");
		
		redemptionOrderSummary = new RedemptionOrderSummary();
		redemptionOrderSummary.setAvailablePointBalance(100);
		redemptionOrderSummary.setOrderID("ABI1");
		
		
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

	@Ignore
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
	
	
	@Ignore
	@Test
	public void retrieveRewards()throws Exception {
		String cloakedCreditCardNumber="cloaked";
		String countryCode="country";
		String rewardProgram="reward";
		String rewardLinkCode="rewardLink";
		String merchantCode="merchant";
		String businessCode="bussiness" ;
		String Authorization="auth";
		String uuid="uuid";
		String Accept="application/json";
		String client_id="client";
		when(payPointService.retrieveRewards()).thenReturn(pointBalance);
		mockMvc.perform(get("/v1/rewards/pointBalance")
				.param("cloakedCreditCardNumber", cloakedCreditCardNumber).param("rewardProgram", rewardProgram)
				.param("rewardLinkCode", rewardLinkCode).param("merchantCode", merchantCode)
				.header("countryCode", countryCode).header("businessCode", businessCode).header("Authorization", Authorization)
				.header("uuid", uuid).header("Accept", Accept).header("client_id", client_id)).andExpect(status().isOk())
				.andDo(print());
		
	}
	
	
	@Test
	public void createLinkCode() throws Exception {
		LinkageRequest linkageRequest = new LinkageRequest();
		linkageRequest.setBillingZipCode("billing");
		linkageRequest.setCloakedCreditCardNumber("cloaked");
		linkageRequest.setMerchantCode("merchant");
		linkageRequest.setRewardProgram("reward");
		String countryCode = "country";
		String businessCode = "bussiness";
		String Authorization = "auth";
		String uuid = "uuid";
		String Accept = "application/json";
		String client_id = "client";

		ObjectMapper obj = new ObjectMapper();
		String json = obj.writeValueAsString(linkageRequest);
		when(payPointService.createLinkCode(linkageRequest)).thenReturn(linkStatus);
		mockMvc.perform(post("/v1/rewards/linkage").contentType(MediaType.APPLICATION_JSON).content(json)
				.header("countryCode", countryCode).header("businessCode", businessCode)
				.header("Authorization", Authorization).header("uuid", uuid).header("Accept", Accept)
				.header("client_id", client_id)).andExpect(status().isOk()).andDo(print());
		
	}
}
