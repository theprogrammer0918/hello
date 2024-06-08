package com.omcodes.hello.helloworld;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class helloworldController {
    @GetMapping("/hello-world")
    public String prt() {
        return "hello world";
    }
    @GetMapping("/hello-world-bean")
    public helloworldbean prtbean(){
        return new helloworldbean("Hello World");
    }
    // /hello-world/path-variable/{id}
    @GetMapping("/hello-world/path-variable/{name}")
    public helloworldbean prtpath(@PathVariable String name) {
        return new helloworldbean(String.format("Hello World %s",name));
    }
    
}
