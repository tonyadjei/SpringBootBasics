package com.tonyadjei.springbootbasics.Exercise2;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculatorController {

    @GetMapping("add")
    public String addition(@RequestParam(required = false) Long a, @RequestParam(required = false) Long b) {
        return a != null && b != null ? "The sum is: " + (a + b) : "Please add 2 query parameters, a and b in the url to perform an addition";
    }

    @GetMapping("multiply/{a}/{b}")
    public String multiplication(@PathVariable(required = false) Long a, @PathVariable(required = false) Long b) {
        return a != null && b != null ? "The product is: " + (a * b) : "Please add 2 path parameters, a and b in the url to perform a multiplication";
    }

    @GetMapping("multiply")
    public String multiply() {
        return "Please add 2 path parameters, a and b in the url to perform a multiplication";
    }
}
