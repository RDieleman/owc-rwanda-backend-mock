package com.example.owcrwanda.test.web.api.controller;

import com.example.owcrwanda.test.models.Project;
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
@RequestMapping("/project")
@CrossOrigin("*")
@Api(tags = "Projects")
public class ProjectController {
    /**
     * Get a list of available projects
     * @return A list of projects
     */
    @ApiOperation(
            value = "Get a list of available projects"
    )
    @ApiResponse(
            code=200, message = "A list of projects has been returned."
    )
    @GetMapping
    public List<Project> getAllProjects(){
        String imageUrl = "https://i.pinimg.com/originals/e5/46/de/e546de0576c7e999f012590c6ab7f356.png";
        String title = "Project title placeholder";
        String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec eu consectetur sem, id finibus augue. Sed pretium, eros non aliquam vulputate, felis ipsum fermentum sem, a pretium nulla lorem vitae orci. Vestibulum ac metus ut orci dignissim pulvinar eu vitae mauris. Maecenas laoreet enim nec tellus tincidunt gravida. Aenean vitae purus eget est luctus lobortis quis vitae libero. Vivamus sed tellus nec leo ullamcorper dapibus. Ut sed ultricies mi.\n" +
                "\n" +
                "Ut et molestie nulla, id egestas turpis. Donec turpis purus, imperdiet interdum nulla in, lobortis porttitor nunc. Quisque sodales fermentum diam, nec bibendum diam tincidunt vitae. Ut venenatis id lorem sed euismod. Nunc finibus, tortor congue feugiat venenatis, tortor nunc sollicitudin lorem, eu efficitur urna ex ac arcu. Praesent quis dignissim magna. Suspendisse nec lacus at odio tempor commodo vel quis tellus. Sed purus est, accumsan condimentum est nec, sollicitudin laoreet nisi. Duis id sem dictum, scelerisque massa nec, suscipit enim.";

        List<Project> mockProjects = new ArrayList<>();
        for(int i = 1; i < 13; i++){
            mockProjects.add(new Project(i, title + " " + i, description, imageUrl));
        }

        return mockProjects;
    }
}
