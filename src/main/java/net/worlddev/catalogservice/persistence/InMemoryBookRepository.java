package net.worlddev.catalogservice.persistence;

import net.worlddev.catalogservice.domain.Book;
import net.worlddev.catalogservice.domain.BookRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alexandre AMEVOR
 */

@Repository
public class InMemoryBookRepository implements BookRepository {

    private final Map<String, Book> books = new ConcurrentHashMap<>(); // Need for thread-safe access to entries, that's why ConcurrentHashMap

    @Override
    public Iterable<Book> findAll() {
        return books.values();
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        return existsByIsbn(isbn) ? Optional.of(books.get(isbn)) : Optional.empty();
    }

    @Override
    public boolean existsByIsbn(String isbn) {
        return books.get(isbn) != null;
    }

    @Override
    public Book save(Book book) {
        books.put(book.isbn(), book);
        return book;
    }

    @Override
    public void saveAll(Iterable<Book> books) {
        for (Book book: books){
            save(book);
        }
    }

    @Override
    public void deleteByIsbn(String isbn) {
        books.remove(isbn);
    }
}
