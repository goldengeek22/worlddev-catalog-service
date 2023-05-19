package net.worlddev.catalogservice.domain;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Alexandre AMEVOR
 */
public class BookValidationTests {

    private static Validator validator;

    @BeforeAll
    static void setUp(){
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void whenAllFieldsCorrectThenValidationSucceeds(){
        var book = new Book("9781837634934","How to Build Android Apps with Kotlin - Second Edition","Alex Forrester",35.99);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertEquals(0,violations.size());
    }

    @Test
    void whenIsbnDefinedButIncorrectThenValidationFails(){
        var book = new Book("978l837634934","How to Build Android Apps with Kotlin - Second Edition","Alex Forrester",35.99);
        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        assertEquals(1,violations.size());
        assertEquals("The ISBN format must be valid.", violations.iterator().next().getMessage());
    }
}
