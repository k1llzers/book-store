package book.store.bookstore.service;

import book.store.bookstore.dto.BookDto;
import book.store.bookstore.dto.CreateBookRequestDto;
import java.util.List;

public interface BookService {
    BookDto save(CreateBookRequestDto book);

    List<BookDto> findAll();

    BookDto findById(Long id);
}
