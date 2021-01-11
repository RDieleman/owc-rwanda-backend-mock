package com.example.owcrwanda.test.web.api.controller;

import com.example.owcrwanda.test.models.Charity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/charity")
@CrossOrigin("*")
@Api(tags = "Charities")
public class CharityController {
    /**
     * Get all available external charities
     * @return A list of charities
     */
    @ApiOperation(
            value = "Get a list of recommended external charities"
    )
    @ApiResponse(
            code=200, message = "A list of recommended external charities has been returned."
    )
    @GetMapping
    public List<Charity> getAllExternalCharities(){
        String name = "Charity name placeholder ";
        String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eu consectetur sem, id finibus augue.";
        String external_url = "https://google.com";
        String logo_url = "https://livejones.com/wp-content/uploads/2020/05/logo-Placeholder.png";

        List<Charity> mockCharities = new ArrayList<>();
        for(int i = 1; i < 6; i++){
            mockCharities.add(new Charity(name, description, external_url, logo_url));
        }

        return mockCharities;
    }
}
