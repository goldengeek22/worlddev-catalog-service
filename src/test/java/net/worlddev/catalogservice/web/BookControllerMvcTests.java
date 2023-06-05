package net.worlddev.catalogservice.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.worlddev.catalogservice.domain.Book;
import net.worlddev.catalogservice.domain.BookNotFoundException;
import net.worlddev.catalogservice.domain.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * @author Alexandre AMEVOR
 */

@WebMvcTest(BookController.class)
class BookControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private BookService bookService;

    @Test
    void whenGetBookNoExistingThenShouldReturn404() throws Exception{
        String isbn = "73737313940";
        given(bookService.findByIsbn(isbn)).willThrow(BookNotFoundException.class);
        mockMvc.perform(get("/books/"+isbn)).andExpect(status().isNotFound());
    }

    @Test
    void whenAddingAndNotExistsThenShouldReturn201() throws Exception{
        Book alexForresterBook = Book.of("9781837634934", "How to Build Android Apps with Kotlin - Second Edition", "Alex Forrester", "PacktPub",35.99);
        mockMvc.perform(post("/books")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(alexForresterBook)))
                .andExpect(status().isCreated());

    }
}
