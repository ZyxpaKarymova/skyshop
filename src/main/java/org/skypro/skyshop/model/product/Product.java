package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    private final UUID id;
    private final String name;
    private final String description;

    public Product(UUID id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    @JsonIgnore
    public String getSearchTerm() {
        return getName().toLowerCase() + " " + getDescription().toLowerCase();
    }

    @Override
    @JsonIgnore
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String toString() {
        return getName() + " (" + getContentType() + ")";
    }
}
