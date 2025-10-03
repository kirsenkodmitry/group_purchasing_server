package ru.vlsu.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.vlsu.model.Product;
import ru.vlsu.repository.ProductRepository;
import ru.vlsu.service.ProductService;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Product create(Product product) {
        return productRepository.save(product);
    }
}
