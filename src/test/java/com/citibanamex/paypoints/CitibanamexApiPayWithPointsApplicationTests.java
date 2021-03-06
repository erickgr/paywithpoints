package com.citibanamex.paypoints;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import com.citibanamex.api.paypoints.PayWithPointsApplication;
import com.citibanamex.api.paypoints.model.EnablementRequest;
import com.citibanamex.api.paypoints.model.IsEligible;
import com.citibanamex.api.paypoints.model.LinkageRequest;
import com.citibanamex.api.paypoints.model.RedemptionRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PayWithPointsApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class CitibanamexApiPayWithPointsApplicationTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	private MockMvc mockMvc;

	@Before
	public void before() {
		mockMvc = webAppContextSetup(webApplicationContext).build();

	}

	@Ignore
	@Test
	public void testGetNearByAtmsStatus() throws Exception {
		String cloakedCreditCardNumber = "sha-11";
		String rewardProgram = "dont know", merchantCode = "23422";
		String Authorization = "true";

		String uuid = "2342d";
		String Accept = "application/json";
		String client_id = "2342";
		String countryCode = "mex";
		mockMvc.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility", cloakedCreditCardNumber)
				.param("rewardProgram", rewardProgram).param("merchantCode", merchantCode)
				.header("Authorization", Authorization).header("uuid", uuid).header("Accept", Accept)
				.header("client_id", client_id).header("countryCode", countryCode)).andExpect(status().isOk())
				.andDo(print());

		MvcResult result = mockMvc
				.perform(get("/v1/rewards/{cloakedCreditCardNumber}/eligibility", cloakedCreditCardNumber)
						.param("rewardProgram", rewardProgram).param("merchantCode", merchantCode)
						.header("Authorization", Authorization).header("uuid", uuid).header("Accept", Accept)
						.header("client_id", client_id).header("countryCode", countryCode))
				.andExpect(status().isOk()).andReturn();

		ObjectMapper objectMapper = new ObjectMapper();
		IsEligible eligible = objectMapper.readValue(result.getResponse().getContentAsString(),
				new TypeReference<IsEligible>() {
				});
		System.out.println("Estatus de elegibilidad: " + eligible.getEligibilityIndicator());

	}

	@Ignore
	@Test
	public void retrieveRewards() throws Exception {
		String cloakedCreditCardNumber = "cloaked";
		String countryCode = "country";
		String rewardProgram = "reward";
		String rewardLinkCode = "rewardLink";
		String merchantCode = "merchant";
		String businessCode = "bussiness";
		String Authorization = "auth";
		String uuid = "uuid";
		String Accept = "application/json";
		String client_id = "client";

		mockMvc.perform(get("/v1/rewards/pointBalance").param("cloakedCreditCardNumber", cloakedCreditCardNumber)
				.param("rewardProgram", rewardProgram).param("rewardLinkCode", rewardLinkCode)
				.param("merchantCode", merchantCode).header("countryCode", countryCode)
				.header("businessCode", businessCode).header("Authorization", Authorization).header("uuid", uuid)
				.header("Accept", Accept).header("client_id", client_id)).andExpect(status().isOk()).andDo(print());

	}

	@Ignore
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

		mockMvc.perform(post("/v1/rewards/linkage").contentType(MediaType.APPLICATION_JSON).content(json)
				.header("countryCode", countryCode).header("businessCode", businessCode)
				.header("Authorization", Authorization).header("uuid", uuid).header("Accept", Accept)
				.header("client_id", client_id)).andExpect(status().isOk()).andDo(print());

	}

	@Test
	public void redeemReward() throws Exception{
		RedemptionRequest redemptionRequest = new RedemptionRequest();
		redemptionRequest.setCloakedCreditCardNumber("cloaked");
		redemptionRequest.setMerchantCode("merchant");
		redemptionRequest.setRewardLinkCode("reward");
		redemptionRequest.setRewardProgram("rewardprogram");
		redemptionRequest.setTransactionReferenceNumber("transaction");

		String countryCode = "Code";
		String businessCode = "bussiness";
		String Authorization = "Auth";
		String uuid = "uuid";
		String Accept = "application/json";
		String client_id = "client";
		
		ObjectMapper obj = new ObjectMapper();
		String json = obj.writeValueAsString(redemptionRequest);

		mockMvc.perform(post("/v1/rewards/redemption").contentType(MediaType.APPLICATION_JSON).content(json)
				.header("countryCode", countryCode).header("businessCode", businessCode)
				.header("Authorization", Authorization).header("uuid", uuid).header("Accept", Accept)
				.header("client_id", client_id)).andExpect(status().isOk()).andDo(print());

	}

	@Ignore
	@Test
	public void testUpdate() throws Exception {
		EnablementRequest enablementRequest = new EnablementRequest();
		enablementRequest.setCloakedCreditCardNumber("cloaked");
		enablementRequest.setEnableProgramIndicator(false);
		enablementRequest.setMerchantCode("merchant");
		enablementRequest.setRewardLinkCode("link");
		enablementRequest.setRewardProgram("rewardOro");

		String countryCode = "lo";
		String businessCode = "jh";
		String Authorization = "ll";
		String uuid = "dsd";
		String Accept = "application/json";
		String client_id = "yt";

		ObjectMapper oj = new ObjectMapper();
		String json = oj.writeValueAsString(enablementRequest);
		mockMvc.perform(put("/v1/rewards/enablement").contentType(MediaType.APPLICATION_JSON).content(json)
				.header("countryCode", countryCode).header("businessCode", businessCode)
				.header("Authorization", Authorization).header("uuid", uuid).header("Accept", Accept)
				.header("client_id", client_id)).andExpect(status().isOk()).andDo(print());

	}

}
