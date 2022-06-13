package io.crowdcode.cloudbay.catalog.web;

import io.crowdcode.cloudbay.catalog.domain.Product;
import io.crowdcode.cloudbay.catalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * @author Ingo Düppe (CROWDCODE)
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> listAll() {
        return ResponseEntity.ok(productService.all());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Void> createProduct(
            @RequestBody Product product, UriComponentsBuilder
            uriComponentsBuilder) {

        productService.createProduct(product);

        URI location = uriComponentsBuilder
                .path("/api/products/{productSku}")
                .buildAndExpand(product.getSku()).toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping(path = "/{productSku}")
    public Product findProductSku(@PathVariable("productSku") String productSku) {
        return productService.findProductSku(productSku);
    }

    @PutMapping(path = "/{productSku}")
    public void updateProduct(@PathVariable("productSku") String productSku, @RequestBody Product productDto) {
        productService.updateProduct(productSku, productDto);
    }

    @GetMapping(path = "/search", params = "tags")
    public List<Product> search(@RequestParam("tags") String[] tags) {
        return productService.search(tags);
    }

}
