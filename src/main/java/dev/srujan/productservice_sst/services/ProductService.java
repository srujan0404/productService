package dev.srujan.productservice_sst.services;

import dev.srujan.productservice_sst.models.Product;

import java.util.*;

public interface ProductService {
      Product getProductById(Long id);

        List<Product> getAllProducts();
}
