package org.skypro.skyshop.model.product;

import java.util.UUID;

public class SimpleProduct extends Product {
    private final int price;

    public SimpleProduct(UUID id, String name, String description, int price) {
        super(id, name, description);
        if (price <= 0) {
            throw new IllegalArgumentException("Цена продукта должна быть строго больше 0");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }

    @Override
    public String getContentType() {
        return "SIMPLE_PRODUCT";
    }

    @Override
    public String toString() {
        return getName() + " (" + getContentType() + "): " + getPrice();
    }
}
