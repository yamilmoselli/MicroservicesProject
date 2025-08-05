package com.MicroservicesProject.service;

import com.MicroservicesProject.domain.Product;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 Usar @ConditionalOnProperty hace que no carguen ambos servicios a la hora de correr la app, lo que ayuda
 a que se ejecute mas rapido.
 @Primary y @Qualifier cumplen la misma funcion pero ambos servicios cargaran cuando se corra la app.
 */

@Service
@ConditionalOnProperty(name = "service.products", havingValue = "list")
@Lazy
public class ProductServiceImpl implements ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(1, "Notebook", 600.0, 15),
            new Product(2, "Mouse", 20.0, 50),
            new Product(3, "Keyboard", 40.0, 30),
            new Product(4, "Smartphone", 700.0, 25)
    ));

    @Override
    public List<Product> getProducts() {
        return products;
    }

}
