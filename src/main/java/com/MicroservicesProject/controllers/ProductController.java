package com.MicroservicesProject.controllers;

import com.MicroservicesProject.domain.Product;
import com.MicroservicesProject.service.ProductService;
import com.MicroservicesProject.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

    @GetMapping
    public ResponseEntity<?> getProducts() {
        List<Product> products = ProductsService.getProducts();
        return ResponseEntity.ok(products);
    }

}
