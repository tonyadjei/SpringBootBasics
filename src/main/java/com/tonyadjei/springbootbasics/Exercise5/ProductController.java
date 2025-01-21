package com.tonyadjei.springbootbasics.Exercise5;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;

@RestController
@RequestMapping("/product")
public class ProductController {

    private static final HashMap<Integer, String> products = new HashMap<>();
    private static int nextIDCount = 0;

    static {
        products.put(++nextIDCount, "Banana");
        products.put(++nextIDCount, "Book");
        products.put(++nextIDCount, "Pen");
        products.put(++nextIDCount, "Phone");
        products.put(++nextIDCount, "Laptop");
    }

    @GetMapping("{id}")
    public ResponseEntity<String> getProduct(@PathVariable int id) {
        String product = products.get(id);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with id: " + id + " was not found.");
    }

    @GetMapping("/add")
    public ResponseEntity<String> addProduct(@RequestParam(required = false) String name) {
        if (name != null) {
            products.put(++nextIDCount, name);
            return ResponseEntity.ok(name + " added successfully!");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please add the name query parameter to add a new product.");
    }

    @GetMapping("all")
    public ResponseEntity<Collection<String>> getAllProducts() {
        return ResponseEntity.ok(products.values());
    }
}
