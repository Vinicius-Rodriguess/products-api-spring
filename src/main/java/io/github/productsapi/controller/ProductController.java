package io.github.productsapi.controller;

import io.github.productsapi.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @PostMapping
    public Product save(@RequestBody Product product) {
        System.out.println(
                "Produto recebido " + product
        );

        return product;
    }

}
