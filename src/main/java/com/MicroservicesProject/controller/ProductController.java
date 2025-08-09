package com.MicroservicesProject.controller;

import com.MicroservicesProject.configurations.ExternalizedConfigurations;
import com.MicroservicesProject.domain.Product;
import com.MicroservicesProject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    @Lazy
    private ProductService ProductsService;

    @Autowired
    private ExternalizedConfigurations externalizedConfigurations;

    @GetMapping
    public ResponseEntity<?> getProducts() {
        System.out.println(externalizedConfigurations.toString());
        List<Product> products = ProductsService.getProducts();
        return ResponseEntity.ok(products);
    }

}
