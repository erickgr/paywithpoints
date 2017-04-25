
package com.city.paypoints.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.citibanamex.api.paypoints.controller.PayPointsController;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PayPointsController.class)
@ComponentScan("com.citibanamex.api.accounts")
public class PayWithPointsControllerTest {

}

