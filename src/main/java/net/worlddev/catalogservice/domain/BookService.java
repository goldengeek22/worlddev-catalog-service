package net.worlddev.catalogservice.domain;

import org.springframework.stereotype.Service;

/**
 * @author Alexandre AMEVOR
 */

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getCatalogBooks(){
        return bookRepository.findAll();
    }

    public Book findByIsbn(String isbn){
        return bookRepository.findByIsbn(isbn).orElseThrow(()->new BookNotFoundException(isbn));
    }

    public Book addBookToCatalog(Book book){
        if(bookRepository.existsByIsbn(book.isbn())){
            throw new BookAlreadyExistsException(book.isbn());
        }
        return bookRepository.save(book);
    }

    public void removeBookFromCatalog(String isbn){
        bookRepository.deleteByIsbn(isbn);
    }

    public Book updateBook(String isbn, Book book){
        return bookRepository.findByIsbn(isbn)
                .map(retrievedBook -> {
                    var bookWithUpdates = new Book(retrievedBook.id(), retrievedBook.version(),
                            retrievedBook.createdDate(),retrievedBook.lastModifiedDate(),retrievedBook.isbn(), book.title(), book.author(), book.publisher(), book.price());
                    return bookRepository.save(bookWithUpdates);
                }).orElseGet(()-> addBookToCatalog(book));
    }
}
