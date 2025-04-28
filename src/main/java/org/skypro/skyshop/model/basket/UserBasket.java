package org.skypro.skyshop.model.basket;

import java.util.List;

public class UserBasket {
    private final List<BasketItem> items;
    private final double total;

    public UserBasket(List<BasketItem> items) {
        this.items = items;
        this.total = calculateTotalSum(items);
    }

    private double calculateTotalSum(List<BasketItem> items) {
        return items.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
    }

    public List<BasketItem> getBasketItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }
}
