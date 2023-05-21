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
        var book1 = new Book("9781617297175", "Kubernetes for Developers", "William Denniss", 31.99);
        var book2 = new Book("9781617297618", "Kubernetes in Action, Second Edition", "Marko Lukša", 44.79);
        var book3 = new Book("9781617295959", "Microservices Security in Action", "Prabath Siriwardena & Nuwan Dias", 44.79);
        var book4 = new Book("9781617299773", "Troubleshooting Java", "Laurențiu Spilcă", 38.39);
        var book5 = new Book("9781617295829", "Istio in Action", "Christian E. Posta & Rinor Maloku", 38.39);
        var book6 = new Book("9781617296895", "Terraform in Action", "Scott Winkler", 31.99);
        var book7 = new Book("9781617294839", "OpenShift in Action", "Jamie Duncan & John Osborne", 28.79);
        var book8 = new Book("9781617297274", "GitOps and Kubernetes", "Billy Yuen & Alexander Matyushentsev & Todd Ekenstam & Jesse Suen", 31.99);
        var book9 = new Book("9781617295485", "Advanced Algorithms and Data Structures", "Marcello La Rocca", 38.39);
        var book10 = new Book("9781617295232", "Kafka in Action", "Dylan Scott & Viktor Gamov & Dave Klein", 28.79);
        var book11 = new Book("9781617296642", "Knative in Action", "Jacques Chester", 38.39);
        var book12 = new Book("9781617298653", "Kubernetes Native Microservices with Quarkus and MicroProfile", "John Clingan & Ken Finnigan", 38.39);
        bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12));
    }
}
