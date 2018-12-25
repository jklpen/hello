package ming.cloud.hello.web.controller;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ming.knife.Result;
import ming.knife.ResultBuilder;

@RestController
public class IndexController {
    
    @Value("${spring.application.name}")
    private String applicationName;

    @RequestMapping("/")
    public String index() {
        return "welcome to " + applicationName;
    }

    @RequestMapping("/hello")
    public Result<String> hello() {
        return ResultBuilder.success("hello anonymize");
    }

    @RequestMapping("/roll")
    public Result<Integer> roll(Integer b) {
        Random random = new Random();
        if (null == b) {
            b = 100;
        }
        int i = random.nextInt(b) + 1;
        return ResultBuilder.success(i);
    }

}