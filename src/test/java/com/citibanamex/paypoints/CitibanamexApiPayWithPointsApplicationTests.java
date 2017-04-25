package com.citibanamex.paypoints;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;

import com.citibanamex.api.paypoints.PayWithPointsApplication;
import com.citibanamex.api.paypoints.model.IsEligible;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PayWithPointsApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class CitibanamexApiPayWithPointsApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private MockMvc mockMvc;

	@Before
	public void before(){
		mockMvc = webAppContextSetup(webApplicationContext).build();
		
	}
	
	@Test
	public void testGetNearByAtmsStatus() throws Exception {
		String cloakedCreditCardNumber = "sha-11";
		String rewardProgram ="dont know", merchantCode="23422";
		String Authorization ="true" ;
		String uuid = "2342d";
		String Accept = "application/json";
		String client_id = "2342";
		String countryCode = "mex";
		mockMvc.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility",cloakedCreditCardNumber).param("rewardProgram", rewardProgram)
				.param("merchantCode", merchantCode).header("Authorization", Authorization).header("uuid", uuid)
				.header("Accept", Accept).header("client_id", client_id).header("countryCode", countryCode))
		        .andExpect(status().isOk()).andDo(print());
		
	   MvcResult result = mockMvc.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility",cloakedCreditCardNumber).param("rewardProgram", rewardProgram)
				.param("merchantCode", merchantCode).header("Authorization", Authorization).header("uuid", uuid)
				.header("Accept", Accept).header("client_id", client_id).header("countryCode", countryCode))
		        .andExpect(status().isOk()).andReturn();
	   
	   ObjectMapper objectMapper = new ObjectMapper();
	   IsEligible eligible = objectMapper.readValue(result.getResponse().getContentAsString(),
				new TypeReference<IsEligible>() {
				});
	   System.out.println("Estatus de elegibilidad: "+eligible.getEligibilityIndicator());
		
	}

}
