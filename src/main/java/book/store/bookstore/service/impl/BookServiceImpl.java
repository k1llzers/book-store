package book.store.bookstore.service.impl;

import book.store.bookstore.dto.BookDto;
import book.store.bookstore.dto.CreateBookRequestDto;
import book.store.bookstore.exception.EntityNotFoundException;
import book.store.bookstore.mapper.BookMapper;
import book.store.bookstore.model.Book;
import book.store.bookstore.repositorie.BookRepository;
import book.store.bookstore.service.BookService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public BookDto save(CreateBookRequestDto book) {
        return bookMapper.toDto(bookRepository.save(bookMapper.toModel(book)));
    }

    @Override
    public List<BookDto> findAll() {
        return bookRepository.findAll().stream()
                .map(bookMapper::toDto)
                .toList();
    }

    @Override
    public BookDto findById(Long id) {
        return bookMapper.toDto(bookRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Book with id " + id + " not found")));
    }

    @Override
    public BookDto update(Long id, CreateBookRequestDto createBookRequestDto) {
        if (bookRepository.existsById(id)) {
            Book book = bookMapper.toModel(createBookRequestDto);
            book.setId(id);
            return bookMapper.toDto(bookRepository.save(book));
        }
        throw new EntityNotFoundException("Can`t find book with id " + id);
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }
}
