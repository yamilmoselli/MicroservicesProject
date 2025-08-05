package com.MicroservicesProject.service;

import java.io.IOException;
import java.util.List;
import com.MicroservicesProject.domain.Product;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/*
 Usar @ConditionalOnProperty hace que no carguen ambos servicios a la hora de correr la app, lo que ayuda
 a que se ejecute mas rapido.
 @Primary y @Qualifier cumplen la misma funcion pero ambos servicios cargaran cuando se corra la app.
 */

@Service
@ConditionalOnProperty(name = "service.products", havingValue = "json")
@Lazy
public class ProductServiceJSONImpl implements ProductService {

    @Override
    public List<Product> getProducts() {
        List<Product> products;

        try {
            products = new ObjectMapper()
                    .readValue(this.getClass().getResourceAsStream("/product.json"),
                            new TypeReference<List<Product>>() {});

            return products;

        } catch(IOException e) {

            throw new RuntimeException(e);

        }
    }
}
