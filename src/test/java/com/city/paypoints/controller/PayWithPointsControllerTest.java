<<<<<<< HEAD:src/test/java/com/city/pay/with/points/controller/PayWithPointsControllerTest.java
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
=======
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
>>>>>>> 1d9eb14e4ad95d96de24cd211953dd64dab171ee:src/test/java/com/city/paypoints/controller/PayWithPointsControllerTest.java
