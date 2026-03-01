import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TimKiemTest {
    WebDriver driver;
    String url = "http://vitimex.com.vn/search";
    @BeforeEach
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @Test
    public void timKiem() throws InterruptedException {
        driver.get(url);
        driver.findElement(By.className("search_box")).sendKeys("Ao");
        driver.findElement(By.cssSelector("input[type='submit'")).click();
        Thread.sleep(5000);
        System.out.println("Tim kiem thanh cong");
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }

}
