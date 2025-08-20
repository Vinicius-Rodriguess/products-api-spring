package io.github.productsapi.controller;

import io.github.productsapi.model.Product;
import org.springframework.web.bind.annotation.*;
import repository.ProductRepository;

import javax.sound.sampled.Port;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        System.out.println("Produto recebido " + product);

        var id = UUID.randomUUID().toString();
        product.setId(id);

        productRepository.save(product);
        return product;
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable("id") String id) {
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id) {
        productRepository.deleteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable("id") String id, @RequestBody Product product) {
        product.setId(id);
        productRepository.save(product);
    }

    @GetMapping
    public List<Product> find(@RequestParam("name") String name) {
        return productRepository.findByName(name);
    }

}
