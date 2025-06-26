package org.skypro.skyshop.model.controller;

import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.SearchResult;
import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.error.ShopError;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.service.BasketService;
import org.skypro.skyshop.model.service.SearchService;
import org.skypro.skyshop.model.service.StorageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shop")
public class ShopController {
    private final StorageService storageService;
    private final SearchService searchService;
    private final BasketService basketService;


    public ShopController(StorageService storageService, SearchService searchService, BasketService basketService) {
        this.storageService = storageService;
        this.searchService = searchService;
        this.basketService = basketService;
    }

    @GetMapping("/products")
    public Collection<Product> getAllProducts() {
        return storageService.getAllStorageProduct().values();
    }

    @GetMapping("/articles")
    public Collection<Article> getAllArticles() {
        return storageService.getAllStorageArticle().values();
    }

    @GetMapping("/search")
    public List<SearchResult> search (@RequestParam String pattern) {
        return searchService.search(pattern);
    }

    @GetMapping("/basket/{id}")
    public ResponseEntity<?> addProduct(@PathVariable UUID id) {
        try {
            basketService.addProduct(id);
            return ResponseEntity.ok("Товар успешно добавлен");
        } catch (NoSuchProductException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ShopError(
                            HttpStatus.NOT_FOUND.value()+" "+HttpStatus.NOT_FOUND.getReasonPhrase(),
                            e.getMessage()

                    ));
        }
    }

    @GetMapping("/basket")
    public ResponseEntity<UserBasket> getUserBasket() {
        return ResponseEntity.ok(basketService.getUserBasket());
    }
}
