package com.tonyadjei.springbootbasics.Exercise8;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("products")
public class AdvancedProductController {
    ArrayList<Product> products = new ArrayList<>();

    @PostMapping("")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        if (!product.getName().isEmpty() && product.getPrice() != null) {
            products.add(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
}
