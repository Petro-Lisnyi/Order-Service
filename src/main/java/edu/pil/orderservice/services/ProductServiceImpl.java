package edu.pil.orderservice.services;

import edu.pil.orderservice.domain.Product;
import edu.pil.orderservice.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    @Transactional
    public Product updateQuantityOnHand(Long id, Integer newQuantity) {
        var product = productRepository.findById(id).orElseThrow();
        product.setQuantityOnHand(newQuantity);
        return productRepository.saveAndFlush(product);
    }
}
