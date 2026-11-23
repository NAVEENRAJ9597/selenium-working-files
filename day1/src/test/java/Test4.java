import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//getCurrentUrl()
//getPageSource()
//getWindowHandle()
//getWindowHandles()
//navigate()


public class Test4 {
    public WebDriver driver;

    @BeforeEach
    void preprocess(){
        driver =new ChromeDriver();
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

    }
    @Disabled
    void checkurl(){
        System.out.println("page url: "+driver.getCurrentUrl());
    }

    @Disabled
    void CheckSource(){
        System.out.println(driver.getPageSource());
    }

    @Disabled
    void checkwindow(){
        System.out.println(driver.getWindowHandle());
    }



    @Disabled
    void checkNavigation() throws InterruptedException {
        driver.navigate().to("https://www.amazon.in/");
        Thread.sleep(2000);

        driver.navigate().back();
        Thread.sleep(2000);

        driver.navigate().forward();
        Thread.sleep(2000);

        driver.navigate().refresh();
    }

    @Test
    void uploadfile(){
        WebElement ele= driver.findElement(By.name("my-file"));

        ele.sendKeys("C:\\Users\nraj6\\Desktop\\empt.txt");
        assertEquals("C:\\Users\\nraj6\\Desktop\\empt.txt",ele.getAttribute("value"));
    }

    @AfterEach
    void postprocess(){
        driver.quit();
    }

}
