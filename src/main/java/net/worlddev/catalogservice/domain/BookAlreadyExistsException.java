package net.worlddev.catalogservice.domain;

/**
 * @author Alexandre AMEVOR
 */

public class BookAlreadyExistsException extends RuntimeException{
    public BookAlreadyExistsException(String isbn) {
        super("A book with ISBN " + isbn + " already exists.");
    }
}
