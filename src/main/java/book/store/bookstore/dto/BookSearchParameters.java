package book.store.bookstore.dto;

import java.math.BigDecimal;

public record BookSearchParameters(String[] authors, BigDecimal minPrice, BigDecimal maxPrice) {
}
