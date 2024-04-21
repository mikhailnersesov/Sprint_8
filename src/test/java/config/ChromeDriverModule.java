package config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverModule extends AbstractModule { // only for chrome
    @Provides
    public WebDriver getWebDriver() {
        return new ChromeDriver();
    }
}

