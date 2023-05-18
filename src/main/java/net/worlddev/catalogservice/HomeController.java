package net.worlddev.catalogservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexandre AMEVOR
 */

@RestController
public class HomeController {

    @GetMapping("/")
        public String getGreeting(){
            return "Welcome to WorldDev catalog !!!";
        }
}
