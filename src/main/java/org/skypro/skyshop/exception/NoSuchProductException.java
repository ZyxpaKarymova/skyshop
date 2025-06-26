package org.skypro.skyshop.exception;

import org.springframework.http.HttpStatus;

import java.util.UUID;

public class NoSuchProductException extends RuntimeException {
    private final UUID productId;

    public NoSuchProductException(UUID productId) {
        super("Продукт с ID "+productId+" не найден");
        this.productId = productId;
    }

    public UUID getProductId() {
        return productId;
    }
}
