import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.alertIsPresent;

public class Main {
    public static void main(String[] args) {



        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Василий\\seleniumDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //в браузер консоли поиск по css = $$()
        List<WebElement> input = driver.findElements(By.xpath("//input[@aria-label='Найти']"));
//        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(10)).
//                until(ExpectedConditions.presenceOfElementLocated(By.id("123"))));
        input.get(0).click();
        driver.close();
        driver = new ChromeDriver();
        driver.get("https://avito.ru");
        try {
            WebElement locationButton = driver.findElement(By.xpath("//button[@data-marker= \"location/tooltip-agree\"]"));
            locationButton.click();
        } catch (Exception e) {
            e.printStackTrace();
        }
        WebElement element = driver.findElement(By.xpath("//a[text()='Личные вещи']"));
        String par = element.getAttribute("offsetWidth");
//        String par = element.getCssValue("display")
        element = driver.findElement(By.xpath("//input[@type ='text']"));
        element.sendKeys("велосипед", Keys.ENTER);

//        Actions actions = new Actions(driver);
//        //actions.moveToElement().keyDown().keyUp().build().perform();// навели на элемент нажали отпустили
//
//        actions.contextClick();//правая кнопка мыши вызов меню

        driver.close();

        WebDriver driver1=new ChromeDriver();
        driver1.get("https://pagination.js.org");
        WebDriverWait wait = new WebDriverWait(driver1,Duration.ofSeconds(10));
        List<WebElement> elements = driver1.findElements(By.xpath("//div[@id='demo1']/div/ul/li"));
        List<WebElement> pages = driver1.findElements(By.xpath("//div[@id='demo1']//div[@class='paginationjs-pages']/ul/li"));

        pages.get(2).click();
        //явное ожидание что элемент пропадет
        wait.until(ExpectedConditions.stalenessOf(elements.get(5)));
        elements = driver1.findElements(By.xpath("//div[@id='demo1']/div/ul/li"));
        String row = elements.get(5).getText();
        System.out.println(row);

        //модальные окна
//        element.click(); после нажатия вылазит алер
//        Alert alert = wait.until(alertIsPresent()); ждем пока появится
//        alert.accept(); жмем на ок

        //изменение атрибута элемента используется для вставки файла

        try{
            driver.get("localhost");
            //WebElement input = driver.findElement(By.id("A"));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document/querySelector('#a').setAtrtribute('style', 'opacity:1')");


        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.printf("");
    }

}
