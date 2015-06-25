package io.github.furikuri.squirrel.web;

import io.github.furikuri.squirrel.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;


@RestController
public class SampleController {

    @Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/")
    public String helloWorld() {
        return this.helloWorldService.getHelloMessage();
    }

    @RequestMapping("/async")
    public Callable<String> helloWorldAsync() {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "async: "
                        + SampleController.this.helloWorldService.getHelloMessage();
            }
        };
    }
}