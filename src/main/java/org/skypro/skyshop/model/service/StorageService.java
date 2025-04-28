package org.skypro.skyshop.model.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> products = new HashMap<>();
    private final Map<UUID, Article> articles = new HashMap<>();

    public StorageService() {
        TestData();
    }

    private void TestData() {
        // Добавляем тестовые продукты
        addProduct(new SimpleProduct(UUID.randomUUID(), "Арбуз", "Фрукт", 150));
        addProduct(new DiscountedProduct(UUID.randomUUID(), "Манго египетское", "Фрукт", 130, 5));
        addProduct(new DiscountedProduct(UUID.randomUUID(), "Манго", "Фрукт", 130, 5));
     //   addProduct(new SimpleProduct(UUID.randomUUID(), "Фисташки", "орехи", 200));

        // Добавляем тестовые статьи
        addArticle(new Article(UUID.randomUUID(), "Когда можно есть арбуз", "Арбуз можно есть в августе."));
        addArticle(new Article(UUID.randomUUID(), "Где растет дыня", "Дыня растет на бахче."));
        addArticle(new Article(UUID.randomUUID(), "Соки из фруктов", "Сок можно делать из разных фруктов."));
        addArticle(new Article(UUID.randomUUID(), "Польза фруктов", "Фрукты вкусны и полезны."));
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }

    public Collection<Article> getAllArticles() {
        return articles.values();
    }

    public Collection<Searchable> getAllSearchables() {
        List<Searchable> result = new ArrayList<>();
        result.addAll(products.values());
        result.addAll(articles.values());
        return result;
    }

    private void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    private void addArticle(Article article) {
        articles.put(article.getId(), article);
    }
}