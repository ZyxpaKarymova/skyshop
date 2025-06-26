package org.skypro.skyshop.model.error;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.skypro.skyshop.exception.NoSuchProductException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopError {
    private String code;
    private String message;

    public ShopError(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ShopError fromException(NoSuchProductException e) {
        return new ShopError("Продукт не найден", e.getMessage());
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
