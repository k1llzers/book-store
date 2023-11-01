package book.store.bookstore.service;

import book.store.bookstore.dto.BookDto;
import book.store.bookstore.dto.BookSearchParameters;
import book.store.bookstore.dto.CreateBookRequestDto;
import java.util.List;
import org.springframework.data.domain.Pageable;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    List<BookDto> findAll(Pageable pageable);

    BookDto findById(Long id);

    BookDto update(Long id, CreateBookRequestDto createBookRequestDto);

    void deleteById(Long id);

    List<BookDto> search(BookSearchParameters bookSearchParameters);
}
