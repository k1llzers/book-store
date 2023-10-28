package book.store.bookstore.services;

import book.store.bookstore.models.Book;
import java.util.List;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
