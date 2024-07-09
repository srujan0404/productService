package dev.srujan.productservice_sst.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.srujan.productservice_sst.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    @Override
    Optional<Product> finalById(Long id);

    @Override
    Product save(Product product);
}
