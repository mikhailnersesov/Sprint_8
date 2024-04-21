package config;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxDriverModule extends AbstractModule { // only for firefox
    @Provides
    public WebDriver getWebDriver() {
        return new FirefoxDriver();
    }
}
