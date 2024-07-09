package dev.srujan.productservice_sst.services;

import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import dev.srujan.productservice_sst.exceptionhandlers.ProductNotFoundException;
import dev.srujan.productservice_sst.models.Category;
import dev.srujan.productservice_sst.repositories.CateogryRepsitory;
import dev.srujan.productservice_sst.repositories.ProductRepository;

@Service
@Primary
public class SelfProductService implements ProductService{
    private ProductRepository productRepository;
    private CategoryRepsitory categoryRepository;

    SelfProductService(ProductRepository productRepository, CateogryRepsitory cateogryRepsitory){
        this.productRepository = productRepository;
        this.categoryRepository = cateogryRepsitory;
    } 

    @Override
    public Product getProductById(Long id) {
        Optional<product> optionalProduct = productRepository.findById(id);

        if (optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product not found with id: ", id);
        }
        return optionalProduct.get();
    }

    @Override
    public Product createProduct(Product product) {
        Category category = product.getCategory();

        if (category.getId() == null) {
            Category savedCategory = categoryRepository.save(category);
            product.setCategory(savedCategory);
        }

        Product product1 = productRepository.save(product);
        Optional<Category> category1 = categoryRepository.findById(category.getId());
        product1.setCategory(category1.get());
        return product1;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

}
