package book.store.bookstore.repository.book.specification;

import book.store.bookstore.model.Book;
import book.store.bookstore.repository.SpecificationProvider;
import java.util.Arrays;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
public class AuthorSpecificationProvider implements SpecificationProvider<Book> {
    @Override
    public String getKey() {
        return "author";
    }

    public Specification<Book> getSpecification(String[] authors) {
        return (root, query, criteriaBuilder) ->
                root.get("author").in(Arrays.stream(authors).toArray());
    }
}
