package com.citibanamex.api.paypoints.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;





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
		mockMvc.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility",cloakedCreditCardNumber).contentType(MediaType.APPLICATION_JSON));
		
//		mockMvc.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility}")
//						.accept(MediaType.APPLICATION_JSON))
//				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
//		mockMvc.perform(get("/v1/banamex/atms/nearby?radius=1000&address=bosque+de+duraznos+78+Mexico+city"))
//				.andDo(print());
	}

}
