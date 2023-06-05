package net.worlddev.catalogservice.demo;

import net.worlddev.catalogservice.domain.Book;
import net.worlddev.catalogservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Alexandre AMEVOR
 */

@Component
@Profile("testdata")
//@ConditionalOnProperty(name = "worlddev.testdata.enabled",havingValue = "true")
public class BookDataLoader {

    private final BookRepository bookRepository;

    public BookDataLoader(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData() {
        bookRepository.deleteAll();
        var book1 =  Book.of("9781617297175", "Kubernetes for Developers", "William Denniss","Manning", 31.99);
        var book2 = Book.of("9781617297618", "Kubernetes in Action, Second Edition", "Marko Lukša","Manning", 44.79);
        var book3 = Book.of("9781617295959", "Microservices Security in Action", "Prabath Siriwardena & Nuwan Dias","Manning", 44.79);
        var book4 = Book.of("9781617299773", "Troubleshooting Java", "Laurențiu Spilcă", "Manning",38.39);
        var book5 = Book.of("9781617295829", "Istio in Action", "Christian E. Posta & Rinor Maloku", "Manning",38.39);
        var book6 = Book.of("9781617296895", "Terraform in Action", "Scott Winkler", "Manning",31.99);
        var book7 = Book.of("9781617294839", "OpenShift in Action", "Jamie Duncan & John Osborne", "Manning",28.79);
        var book8 = Book.of("9781617297274", "GitOps and Kubernetes", "Billy Yuen & Alexander Matyushentsev & Todd Ekenstam & Jesse Suen", "Manning",31.99);
        var book9 = Book.of("9781617295485", "Advanced Algorithms and Data Structures", "Marcello La Rocca", "Manning",38.39);
        var book10 = Book.of("9781617295232", "Kafka in Action", "Dylan Scott & Viktor Gamov & Dave Klein", "Manning",28.79);
        var book11 = Book.of("9781617296642", "Knative in Action", "Jacques Chester", "Manning",38.39);
        var book12 = Book.of("9781617298653", "Kubernetes Native Microservices with Quarkus and MicroProfile", "John Clingan & Ken Finnigan","Manning", 38.39);
        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12));
    }
}
