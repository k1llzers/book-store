package book.store.bookstore.repository.book;

import book.store.bookstore.dto.BookSearchParameters;
import book.store.bookstore.model.Book;
import book.store.bookstore.repository.SpecificationBuilder;
import book.store.bookstore.repository.SpecificationProviderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BookSpecificationBuilder implements SpecificationBuilder<Book> {
    private final SpecificationProviderManager<Book> specificationProviderManager;

    @Override
    public Specification<Book> build(BookSearchParameters bookSearchParameters) {
        Specification<Book> specification = Specification.where(null);
        if (bookSearchParameters.authors() != null && bookSearchParameters.authors().length > 0) {
            specification = specification
                    .and(specificationProviderManager.getSpecificationProvider("author")
                            .getSpecification(bookSearchParameters.authors()));
        }
        if (bookSearchParameters.maxPrice() != null || bookSearchParameters.minPrice() != null) {
            String min = bookSearchParameters.minPrice() == null
                    ? "0"
                    : bookSearchParameters.minPrice().toString();
            String max = bookSearchParameters.maxPrice() == null
                    ? String.valueOf(Long.MAX_VALUE)
                    : bookSearchParameters.maxPrice().toString();
            specification = specification
                    .and(specificationProviderManager.getSpecificationProvider("price")
                            .getSpecification(new String[]{min,max}));
        }
        return specification;
    }
}
