package book.store.bookstore;

import book.store.bookstore.model.Book;
import book.store.bookstore.service.BookService;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookStoreApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setTitle("Harry Potter");
            book.setAuthor("Joanne Rowling");
            book.setIsbn("9781408856772");
            book.setPrice(BigDecimal.valueOf(1000));
            book.setDescription("An orphaned boy enrolls in a school of wizardry, "
                    + "where he learns the truth about himself, his family and the terrible "
                    + "evil that haunts the magical world.");
            bookService.save(book);
            System.out.println(bookService.findAll());
        };
    }
}
