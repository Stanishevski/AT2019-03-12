package by.it.agrinkevich.cucumber;

import by.it.agrinkevich.pages.FactoryResultPage;
import by.it.agrinkevich.pages.FactoryStartPage;
import by.it.agrinkevich.pages.LoginPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.assertNotNull;

public class TaskB {

    private WebDriver driver;
    private FactoryStartPage factoryStartPage;
    private FactoryResultPage factoryResultPage;
    private LoginPage loginPage;


    @Before
    public void инициализация_теста(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    @Дано("^Главная страница загружается из \"([^\"]*)\"$")
    public void главная_страница_загружается_из(String url) throws Throwable {
        driver.get(url);
        factoryStartPage = new FactoryStartPage(driver);
        assertNotNull(factoryStartPage);
    }

  /*  @Когда("^Пользователь открывает выпадающий список аккаунт$")
    public void пользователь_открывает_выпадающий_список_аккаунт() throws Throwable {
        factoryStartPage.openAccountDropDown();
        assertNotNull(factoryStartPage);
    }

    @Когда("^Открывает форму логина$")
    public void открывает_форму_логина() throws Throwable {
        factoryStartPage.openSignInForm();
        assertNotNull(factoryStartPage);
    }

    @Когда("^Вводит почту \"([^\"]*)\"$")
    public void вводит_почту(String email) throws Throwable {
        loginPage = new LoginPage(driver);
        loginPage.setEmail(email);
        assertNotNull(loginPage);
    }

    @Когда("^Вводит пароль \"([^\"]*)\"$")
    public void вводит_пароль(String password) throws Throwable {
        loginPage.setPassword(password);
        assertNotNull(loginPage);
    }

    @Когда("^Нажимает на кнопку логин$")
    public void нажимает_на_кнопку_логин() throws Throwable {
        loginPage.doLogin();
        assertNotNull(loginPage);
    }
*/
    @Когда("^Выбирает режим самолета$")
    public void выбирает_режим_самолета() throws Throwable {
        factoryStartPage.selectSearchFlightMode();
        assertNotNull(factoryStartPage);
    }

    @Когда("^Выбирает поездку в обе стороны$")
    public void выбирает_поездку_в_обе_стороны() throws Throwable {
        factoryStartPage.selectRoundTrip();
        assertNotNull(factoryStartPage);
    }

    @Когда("^Устанавливает пункт отправления \"([^\"]*)\"$")
    public void устанавливает_пункт_отправления(String origin) throws Throwable {
        factoryStartPage.setOrigin(origin);
        assertNotNull(factoryStartPage);
    }

    @Когда("^Устанавливает пункт назначения \"([^\"]*)\"$")
    public void устанавливает_пункт_назначения(String destination) throws Throwable {
        factoryStartPage.setDestination(destination);
        assertNotNull(factoryStartPage);
    }

    @Когда("^К дате отправления прибавляет к текущей дате (\\d+)$")
    public void к_дате_отправления_прибавляет_к_текущей_дате(int num) throws Throwable {
        factoryStartPage.setDepartingDate(num);
        assertNotNull(factoryStartPage);
    }

    @Когда("^К дате возвразения прибавляет к текущей дате (\\d+)$")
    public void к_дате_возвразения_прибавляет_к_текущей_дате(int num) throws Throwable {
        factoryStartPage.setReturningDate(num);
        assertNotNull(factoryStartPage);
    }

    @Когда("^Выбирает двух взрослых$")
    public void выбирает_двух_взрослых() throws Throwable {
        factoryStartPage.setTwoAdult();
        assertNotNull(factoryStartPage);
    }

    @Когда("^Нажимает на поиск$")
    public void нажимает_на_поиск() throws Throwable {
       factoryStartPage.getSearch();
       assertNotNull(factoryStartPage);
    }

    @Тогда("^Считает, являются ли цены больше (\\d+) долларов$")
    public void считает_являются_ли_цены_больше_долларов(int arg1) throws Throwable {
        FactoryResultPage factoryResultPage = new FactoryResultPage(driver);
        List<WebElement> pricesWebElement = factoryResultPage.getPrices();
        List<String> strPrices = pricesWebElement.stream().map(element -> element.getText()).collect(Collectors.toList());
        List<Integer> num = new ArrayList<>();
        Iterator<String> iter = strPrices.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            str = str.replaceAll("[$,]+", "");
            num.add(Integer.parseInt(str));
        }
        Iterator<Integer> iterNum = num.iterator();
        boolean isPriceLower100 = false;
        while (iterNum.hasNext()) {
            Integer myInteger = iterNum.next();
            int myInt = myInteger.intValue();
            if (myInt < 100) {
                isPriceLower100 = true;
                break;
            }
        }
        Assert.assertEquals(false, isPriceLower100);
    }

    @After
    public void закрытие_браузера(){
        driver.quit();
    }
}
