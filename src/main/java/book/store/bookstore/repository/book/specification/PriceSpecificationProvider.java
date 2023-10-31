package book.store.bookstore.repository.book.specification;

import book.store.bookstore.model.Book;
import book.store.bookstore.repository.SpecificationProvider;
import java.math.BigDecimal;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class PriceSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return "price";
    }

    public Specification<Book> getSpecification(String[] price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("price"),
                BigDecimal.valueOf(Long.parseLong(price[0])),
                BigDecimal.valueOf(Long.parseLong(price[1])));
    }
}
