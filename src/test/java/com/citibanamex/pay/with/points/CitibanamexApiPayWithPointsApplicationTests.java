package com.citibanamex.pay.with.points;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.citibanamex.api.pay.with.points.PayWithPointsApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PayWithPointsApplication.class,webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class CitibanamexApiPayWithPointsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
