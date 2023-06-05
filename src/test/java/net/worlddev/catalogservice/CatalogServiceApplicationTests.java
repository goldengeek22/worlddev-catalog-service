package net.worlddev.catalogservice;

import net.worlddev.catalogservice.domain.Book;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * @author Alexandre AMEVOR
 */

@SpringBootTest(webEnvironment = RANDOM_PORT)
@ActiveProfiles("integration")
@Disabled
class CatalogServiceApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    @Disabled
    void whenPostRequestThenBookCreated() {
        var expectedBook = Book.of("1231231231", "The Cloud Native Developers", "Unknown", "Unknown",9.62);
        var actualBook = webTestClient.post()
                .uri("/books")
                .bodyValue(expectedBook)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Book.class)
                .returnResult()
                .getResponseBody();

        assertThat(actualBook).isNotNull();
        assertThat(actualBook.isbn()).isEqualTo(expectedBook.isbn());
    }

}
