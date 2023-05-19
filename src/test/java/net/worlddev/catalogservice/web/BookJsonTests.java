package net.worlddev.catalogservice.web;

import net.worlddev.catalogservice.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexandre AMEVOR
 */

@JsonTest
class BookJsonTests {

    @Autowired
    private JacksonTester<Book> bookJsonTester;

    @Test
    void testSerialize() throws IOException {
        var book = new Book("1234567890", "Title", "Author", 9.90);
        var bookInJson = bookJsonTester.write(book);
        assertThat(bookInJson).extractingJsonPathStringValue("@.isbn").isEqualTo(book.isbn());
        assertThat(bookInJson).extractingJsonPathStringValue("@.title").isEqualTo(book.title());
        assertThat(bookInJson).extractingJsonPathStringValue("@.author").isEqualTo(book.author());
        assertThat(bookInJson).extractingJsonPathNumberValue("@.price").isEqualTo(book.price());
    }

    @Test
    void testDeserialize() throws IOException{
        var bookInJson = """
                {
                    "isbn":"1234567890",
                    "title":"Eleventy by Example",
                    "author":"Bryan Robinson",
                    "price":21.99
                }
                """;
        assertThat(bookJsonTester.parse(bookInJson)).usingRecursiveComparison().isEqualTo(new Book("1234567890","Eleventy by Example","Bryan Robinson",21.99));
    }
}
