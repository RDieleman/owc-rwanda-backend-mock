package com.example.owcrwanda.test.web.api.controller;

import com.google.gson.Gson;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/create-checkout-session")
@CrossOrigin("*")
@Api(tags = "Stripe")
public class StripeController {
    private final String KEY = "sk_test_51HzDIHEx7DRYoqykGXU34T9DIdYq6kWSzdf8KENM7ng95aDdW9uUh8lqCntKzg3mxdbmb50ml6ZLAtMHGNsVTF9g00FxUsNr4s";
    private final Gson gson = new Gson();

    public StripeController(){
        Stripe.apiKey = KEY;
    }

    /**
     * Create a new checkout session
     * @return A checkout session
     */
    @ApiOperation(
            value = "Create a new checkout sessions"
    )
    @ApiResponse(
            code=200, message = "A new checkout session has been created and returned."
    )
    @PostMapping("/{amount}")
    public String createSession(@PathVariable long amount){
        if(amount < 1) throw new IllegalArgumentException("Price too low");

        SessionCreateParams params =
                SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.IDEAL)
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.ALIPAY)
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.EPS)
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.GIROPAY)
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.P24)
                        .addPaymentMethodType(SessionCreateParams.PaymentMethodType.SOFORT)

                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setSuccessUrl("https://localhost:3000/result/success")
                .setCancelUrl("https://localhost:3000/result/failed")
                .addLineItem(
                        SessionCreateParams.LineItem.builder()
                        .setQuantity(1L)
                        .setPriceData(
                                SessionCreateParams.LineItem.PriceData.builder()
                                .setCurrency("eur")
                                .setUnitAmount(amount)
                                .setProductData(
                                        SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                        .setName("Donation")
                                        .setDescription("A donation towards the OWC Rwanda charity.")
                                        .build())
                                .build())
                        .build())
                .build();

        Session session = null;
        try {
            session = Session.create(params);
        } catch (StripeException e) {
            e.printStackTrace();
        }

        Map<String, String> responseData = new HashMap();
        responseData.put("id", session.getId());

        return gson.toJson(responseData);

    }

}
