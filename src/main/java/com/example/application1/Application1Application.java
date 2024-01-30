package com.example.application1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application1Application {

    public static void main(String[] args) {
        SpringApplication.run(Application1Application.class, args);
    }

    @GetMapping("/hello")
    public String sayHello(@RequestParam(value="text1",defaultValue="World") String uname) {
        return String.format("Hello %s", uname);
    }



    @GetMapping("/palindrome")
    public String sayHello1(@RequestParam(value="text2") String name) {
    //public String sayHello(@RequestParam String name, @RequestParam String lastname)
        boolean palindrome = isPalindrome(name);
        if (palindrome) {
            return String.format("%s is palindrome...", name);
        }
        else {
            return String.format("%s is not a palindrome...", name);
        }
    }

    public boolean isPalindrome(String text) {
        String clean = text.replaceAll("\\s+", "").toLowerCase();
        int length = clean.length();
        int forward = 0;
        int backward = length - 1;
        while (backward > forward) {
            char forwardChar = clean.charAt(forward++);
            char backwardChar = clean.charAt(backward--);
            if (forwardChar != backwardChar) {
                return false;
            }
        }
        return true;
    }
}
