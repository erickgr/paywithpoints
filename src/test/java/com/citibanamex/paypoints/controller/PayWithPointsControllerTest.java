package com.citibanamex.paypoints.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.citibanamex.api.paypoints.controller.PayPointsController;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=PayPointsController.class)
@ComponentScan("com.citibanamex.api.paypoints.controller")
public class PayWithPointsControllerTest {

	
	private MockMvc mockMvc;

	@Before
	public void before(){
		
	}
	
//	@Ignore
	@Test
	public void testGetNearByAtmsStatus() throws Exception {
		String cloakedCreditCardNumber = "safsaf";
		mockMvc.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility}",cloakedCreditCardNumber).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		mockMvc
				.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility}")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().contentType("application/json;charset=UTF-8"));
		mockMvc.perform(get("/v1/banamex/atms/nearby?radius=1000&address=bosque+de+duraznos+78+Mexico+city"))
				.andDo(print());
	}

}
