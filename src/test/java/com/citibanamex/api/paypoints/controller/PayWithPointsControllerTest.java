package com.citibanamex.api.paypoints.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.context.WebApplicationContext;

import com.citibanamex.api.paypoints.PayWithPointsApplication;
import com.citibanamex.api.paypoints.model.IsEligible;
import com.citibanamex.api.paypoints.service.PayPointService;





@RunWith(SpringRunner.class)
@SpringBootTest(classes = PayWithPointsApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
//@SpringBootTest(classes=PayPointsController.class)
//@ComponentScan("com.citibanamex.api.paypoints.controller")
public class PayWithPointsControllerTest {

//	@MockBean
//	private PayPointService payPointService;
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

	@Before
	public void before(){
		mockMvc = webAppContextSetup(webApplicationContext).build();
		
	}
	
//	@Ignore
	@Test
	public void testGetNearByAtmsStatus() throws Exception {
		String cloakedCreditCardNumber = "sha-11";
		String rewardProgram ="dont know", merchantCode="23422";
		String Authorization ="true" ;
		 String uuid = "2342d";
		 String Accept = "application/json";
		 String client_id = "2342";
		String countryCode = "mex";
		//IsEligible eligible = new IsEligible();
		//eligible.setEligibilityIndicator("E");
		//when(payPointService.checkRewards(cloakedCreditCardNumber)).thenReturn(eligible);
		mockMvc.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility",cloakedCreditCardNumber).param("rewardProgram", rewardProgram)
				.param("merchantCode", merchantCode).header("Authorization", Authorization).header("uuid", uuid)
				.header("Accept", Accept).header("client_id", client_id).header("countryCode", countryCode))
		        .andExpect(status().isOk()).andDo(print());
		
//		mockMvc.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility}")
//						.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
//		mockMvc.perform(get("/v1/banamex/atms/nearby?radius=1000&address=bosque+de+duraznos+78+Mexico+city"))
//				.andDo(print());
	}

}
