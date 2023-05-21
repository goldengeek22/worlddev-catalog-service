package net.worlddev.catalogservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * This bean will listen to RefreshScopeRefreshedEvent because it's annotated with @ConfigurationProperties</code>
 * @author Alexandre AMEVOR
 */
@ConfigurationProperties(prefix = "worlddev")
public class WorldDevProperties {

    /**
     *  A message to welcome users.
     */
    private String greeting;
    private boolean testdata_enabled;

    public String getGreeting() {
        return greeting;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public boolean isTestdata_enabled() {
        return testdata_enabled;
    }

    public void setTestdata_enabled(boolean testdata_enabled) {
        this.testdata_enabled = testdata_enabled;
    }
}
