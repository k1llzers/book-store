package book.store.bookstore.repositories;

import book.store.bookstore.models.Book;

import java.util.List;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
