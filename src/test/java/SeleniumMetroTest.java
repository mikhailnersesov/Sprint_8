import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.Assert;


public class SeleniumMetroTest {

    // создали поля для драйвера и страницы
    protected WebDriver driver;
    private MetroHomePage metroPage;
    // создали константы для тестовых данных
    private static final String CITY_SAINTP = "Санкт-Петербург";
    private static final String STATION_SPORTIVNAYA = "Спортивная";

    // добавь константы для станций «Лубянка» и «Красногвардейская»
    private static final String STATION_LUBYANKA = "Лубянка";
    private static final String STATION_KRASNOGVARD = "Красногвардейская";

    @Before
    public void setUp() {
        // открыли браузер
        //TODO disabled for local intelij tests
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage");
//        driver = new ChromeDriver(options);
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        // перешли на страницу тестового приложения
        driver.get("https://qa-metro.stand-2.praktikum-services.ru/");
        // создали объект класса страницы стенда
        metroPage = new MetroHomePage(driver);
        // дождались загрузки страницы
        metroPage.waitForLoadHomePage();

    }

    // проверили выбор города
    @Test
    public void checkChooseCityDropdown() {
        // выбрали Санкт-Петербург в списке городов
        metroPage.chooseCity(CITY_SAINTP);
        // проверили, что видна станция метро «Спортивная»
        metroPage.waitForStationVisibility(STATION_SPORTIVNAYA);
    }

    // проверь отображение времени маршрута
    @Test
    public void checkRouteApproxTimeIsDisplayed() {
        // построй маршрут от «Лубянки» до «Красногвардейской»
        metroPage.buildRoute(STATION_LUBYANKA,STATION_KRASNOGVARD);
        // проверь, что у первого маршрута списка отображается нужное примерное время поездки
        Assert.assertEquals("≈ 36 мин.", metroPage.getApproximateRouteTime(0));
    }

    // проверь отображение станции «Откуда» в карточке маршрута
    @Test
    public void checkRouteStationFromIsCorrect() {
        // построй маршрут от «Лубянки» до «Красногвардейской»
        metroPage.buildRoute(STATION_LUBYANKA,STATION_KRASNOGVARD);
        // проверь, что отображается корректное название станции начала маршрута
        Assert.assertEquals(STATION_LUBYANKA,metroPage.getRouteStationFrom());

    }

    @After
    public void tearDown() {
        // закрыли браузер
        driver.quit();
    }
}