package org.skypro.skyshop.model.product;

import java.util.UUID;

public abstract class FixPricedProduct extends Product {

    private static int FIXED_PRICE = 200; // Пример фиксированной цены

    public FixPricedProduct(UUID id, String name, String description) {
        super(id, name, description);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    public String getContentType() {
        return "FIX_PRICE_PRODUCT";
    }

    @Override
    public String toString() {
        return getName() + " (" + getContentType() + "): Фиксированная цена " + FIXED_PRICE;
    }
}
