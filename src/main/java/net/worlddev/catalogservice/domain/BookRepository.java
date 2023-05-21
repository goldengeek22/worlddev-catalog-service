package net.worlddev.catalogservice.domain;

import java.util.Optional;

/**
 * @author Alexandre AMEVOR
 */

public interface BookRepository {
    Iterable<Book> findAll();
    Optional<Book> findByIsbn(String isbn);
    boolean existsByIsbn(String isbn);
    Book save(Book book);
    void deleteByIsbn(String isbn);
    void saveAll(Iterable<Book> books);
}
