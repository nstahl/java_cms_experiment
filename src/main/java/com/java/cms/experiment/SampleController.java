package com.java.cms.experiment;

/**
 * Created by niko on 8/8/16.
 */
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        // SpringApplication will bootstrap our application,
        // starting Spring which will in turn start the auto-configured Tomcat web server
        SpringApplication.run(SampleController.class, args);
    }
}
