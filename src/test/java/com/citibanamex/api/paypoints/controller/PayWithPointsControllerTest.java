package com.citibanamex.api.paypoints.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestHeader;





@RunWith(SpringRunner.class)
@SpringBootTest(classes=PayPointsController.class)
@ComponentScan("com.citibanamex.api.paypoints.controller")
public class PayWithPointsControllerTest {

	
	private MockMvc mockMvc;

	@Before
	public void before(){
		
	}
	
	@Ignore
	@Test
	public void testGetNearByAtmsStatus() throws Exception {
		String cloakedCreditCardNumber = "safsaf";
		String rewardProgram ="dont know", merchantCode="23422";
		String Authorization ="true" ;
		 String uuid = "2342d";
		 String Accept = "dsfa";
		 String client_id = "2342";
		String countryCode = "mex";
		mockMvc.perform(get("/v1/rewards/safsaf/eligibility").param("rewardProgram", rewardProgram)
				.param("merchantCode", merchantCode).header("Authorization", Authorization).header("uuid", uuid)
				.header("Accept", Accept).header("client_id", client_id).header("countryCode", countryCode));
		
//		mockMvc.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility}")
//						.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
//		mockMvc.perform(get("/v1/banamex/atms/nearby?radius=1000&address=bosque+de+duraznos+78+Mexico+city"))
//				.andDo(print());
	}

}
