package dev.srujan.productservice_sst.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.srujan.productservice_sst.models.Category;

public interface CateogryRepsitory extends JpaRepository<Category, Long>{
    @Override
    Category save(Category category);
}   
