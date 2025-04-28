package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StorageService {
    private final Map<UUID, Product> storageProduct;
    private final Map<UUID, Article> storageArticle;

    public StorageService(Map<UUID, Product> storageProduct, Map<UUID, Article> storageArticle) {
        this.storageProduct = storageProduct;
        this.storageArticle = storageArticle;
        fillingMap();
    }

    public Map<UUID, Product> getAllStorageProduct() {
        return storageProduct;
    }

    public Map<UUID, Article> getAllStorageArticle() {
        return storageArticle;
    }

    private void fillingMap() {
        // Добавляем продукты
        SimpleProduct watermelon = new SimpleProduct(UUID.randomUUID(), "Арбуз", "Фрукт", 150);
        DiscountedProduct mangoEgyptian = new DiscountedProduct(UUID.randomUUID(), "Манго египетское", "Фрукт", 130, 5);
        ;
        DiscountedProduct mango = new DiscountedProduct(UUID.randomUUID(), "Манго", "Фрукт", 130, 5);
     //   addProduct(new SimpleProduct(UUID.randomUUID(), "Фисташки", "орехи", 200));

        // Добавляем статьи
        Article watermelonSeason = new Article(UUID.randomUUID(), "Когда можно есть арбуз", "Арбуз можно есть в августе.");
        Article melon = new Article(UUID.randomUUID(), "Где растет дыня", "Дыня растет на бахче.");
        Article juices = new Article(UUID.randomUUID(), "Соки из фруктов", "Сок можно делать из разных фруктов.");
        Article benefits = new Article(UUID.randomUUID(), "Польза фруктов", "Фрукты вкусны и полезны.");

        storageProduct.put(watermelon.getId(), watermelon);
        storageProduct.put(mangoEgyptian.getId(), mangoEgyptian);
        storageProduct.put(mango.getId(), mango);
        storageArticle.put(watermelonSeason.getId(), watermelonSeason);
        storageArticle.put(melon.getId(), melon);
    }

    public Collection<Searchable> allProductsAndArticle() {
        return Stream.concat(
                storageProduct.values().stream(),
                storageArticle.values().stream()
        ).collect(Collectors.toList());
    }

    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(storageProduct.get(id));
    }


}