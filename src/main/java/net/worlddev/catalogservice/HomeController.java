package net.worlddev.catalogservice;

import net.worlddev.catalogservice.config.WorldDevProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Alexandre AMEVOR
 */

@RestController
public class HomeController {

    private final WorldDevProperties worldDevProperties;

    public HomeController(WorldDevProperties worldDevProperties) {
        this.worldDevProperties = worldDevProperties;
    }

    @GetMapping("/")
    public String getGreeting() {
        return worldDevProperties.getGreeting();
    }
}
