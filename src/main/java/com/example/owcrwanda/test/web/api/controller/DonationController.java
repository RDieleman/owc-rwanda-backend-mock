package com.example.owcrwanda.test.web.api.controller;

import com.example.owcrwanda.test.models.Donation;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/donation")
@CrossOrigin("*")
@Api(tags = "Donations")
public class DonationController {

    /**
     * Get a list of recent donations
     * @return A list of donations
     */
    @ApiOperation(
            value = "Get a list of recent donations"
    )
    @ApiResponse(
            code=200, message = "A list of recent donations has been returned."
    )
    @GetMapping
    public List<Donation> getRecentDonations() {
        String name = "Name placeholder ";
        String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque mi turpis, egestas ac lobortis a, gravida sollicitudin erat.";

        List<Donation> donations = new ArrayList<>();
        for (int i = 1; i < 21; i++) {
            donations.add(
                    new Donation(
                            name + i,
                            message,
                            ThreadLocalRandom.current().nextInt(1, 15) * 10)
            );
        }

        return donations;
    }
}
