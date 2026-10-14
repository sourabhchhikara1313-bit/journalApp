package net.engineeringdigest.journalApp.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Tag(name = "Home APIs")
public class HomeController {

    @GetMapping("/")
    public String healthCheck(){
        return "Home";
    }

}
