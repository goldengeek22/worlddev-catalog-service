package net.worlddev.catalogservice.web;

import jakarta.validation.Valid;
import net.worlddev.catalogservice.domain.Book;
import net.worlddev.catalogservice.domain.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author Alexandre AMEVOR
 */

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> getAll(){
        return bookService.getCatalogBooks();
    }

    @GetMapping("{isbn}")
    public Book findByIsbn(@PathVariable String isbn){
        return bookService.findByIsbn(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@Valid @RequestBody Book book){
        return bookService.addBookToCatalog(book);
    }

    @PutMapping("{isbn}")
    public Book updateBook(@PathVariable String isbn, @Valid @RequestBody Book book){
        return bookService.updateBook(isbn, book);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removeBook(@PathVariable String isbn){
        bookService.removeBookFromCatalog(isbn);
    }
}
