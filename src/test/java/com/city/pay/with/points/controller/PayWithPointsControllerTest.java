package com.city.pay.with.points.controller;

import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.citibanamex.api.pay.with.points.controller.PayPointsController;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = PayPointsController.class)
@ComponentScan("com.citibanamex.api.paypoints")
public class PayWithPointsControllerTest {

}
