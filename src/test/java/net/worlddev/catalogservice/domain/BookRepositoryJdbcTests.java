package net.worlddev.catalogservice.domain;

import net.worlddev.catalogservice.config.DataConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Alexandre AMEVOR 
 */

@DataJdbcTest
@Import(DataConfig.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("integration")
@Disabled
class BookRepositoryJdbcTests {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private JdbcAggregateTemplate jdbcAggregateTemplate;

    @Test
    @Disabled
    void findBookByIsbnWhenExisting(){
        var bookIsbn = "1234561237";
        var book = Book.of(bookIsbn,"Title","Author","Publisher",12.90);
        jdbcAggregateTemplate.insert(book);
        Optional<Book> byIsbn = bookRepository.findByIsbn(bookIsbn);
        assertThat(byIsbn).isPresent();
        assertThat(byIsbn.get().isbn()).isEqualTo(bookIsbn);
    }
}