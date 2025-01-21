package com.tonyadjei.springbootbasics.Exercise4;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TemperatureController {

    @GetMapping("/convert")
    public String convertToFahrenheit(@RequestParam(required = false) Float celsius) {
        if (celsius == null) {
            return "Please add the celsius query parameter in order to make the conversion.";
        }
        return "The temperature in Fahrenheit is: " + ((celsius * 9/5) + 32);
    }
}
