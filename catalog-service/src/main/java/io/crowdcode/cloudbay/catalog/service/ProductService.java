package io.crowdcode.cloudbay.catalog.service;

import io.crowdcode.cloudbay.catalog.domain.Product;
import io.crowdcode.cloudbay.catalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public String createProduct(Product product) {
        product.setCreatedAt(LocalDateTime.now());
        productRepository.save(product);
        return product.getSku();
    }

    public Product findProductSku(String productSku) {
        return productRepository.findBySku(productSku);
    }

    public void updateProduct(String productSku, Product productDto) {
        Product productEntity = productRepository.findBySku(productSku);
        mapTo(productDto, productEntity);
        productRepository.save(productEntity);
    }

    public List<Product> search(String[] tags) {
        return productRepository.findByTag(tags);
    }

    private Product mapTo(Product source, Product target) {
        target.setTitle(source.getTitle())
                .setDescription(source.getDescription())
                .setRetailPrice(source.getRetailPrice())
                .setAmount(source.getAmount())
                .setUnit(source.getUnit())
                .setTags(source.getTags());
        return target;
    }

    public List<Product> all() {
        return productRepository.findAll();
    }
}
