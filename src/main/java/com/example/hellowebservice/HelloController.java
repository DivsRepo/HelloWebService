package com.example.hellowebservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
 @GetMapping("/hello")
 public String Hello() {
	 return "Hello WCF-Jenkins CI/CD!";
	  }
}
