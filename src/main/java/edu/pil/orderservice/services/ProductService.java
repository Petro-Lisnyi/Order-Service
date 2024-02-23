package edu.pil.orderservice.services;


import edu.pil.orderservice.domain.Product;

public interface ProductService {
   Product saveProduct(Product product);

    Product updateQuantityOnHand(Long id, Integer newQuantity);
}
