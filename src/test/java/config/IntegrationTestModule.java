package config;

import com.google.inject.AbstractModule;

public class IntegrationTestModule extends AbstractModule {
    @Override
    protected void configure() {
        if (System.getProperty("useChrome").equals("true")) {
            install(new ChromeDriverModule());
        } else {
            install(new FirefoxDriverModule());
        }
    }
}
