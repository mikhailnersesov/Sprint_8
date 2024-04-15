import org.junit.Assert;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        /*
             Этот метод должен проверять, что сохранённая через конструктор строка соответствует требованиям.
             Если строка удовлетворяет условиям, метод возвращает true, иначе — false.
         */
        Assert.assertTrue(name.length() >=3); // проверка длины
        Assert.assertTrue(name.length() <=19); // проверка длины
        Assert.assertFalse(name.endsWith(" ")); // проверка наличие пробела в конце строки
        Assert.assertFalse(name.startsWith(" ")); // проверка наличие пробела в начале строки
        Assert.assertTrue(name.matches("^\\s+$")); // проверка наличие пробела внутри
        return true;

    }

}
