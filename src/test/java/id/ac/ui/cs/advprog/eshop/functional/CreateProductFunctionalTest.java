package id.ac.ui.cs.advprog.eshop.functional;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@ExtendWith(SeleniumJupiter.class)
class CreateProductFunctionalTest {
    @Value("${app.baseUrl:http://localhost}")
    private String testBaseUrl;

    private String baseUrl;

    @Test
    void initialProductListPage_isCorrect (ChromeDriver driver) {
        // Given
        baseUrl = testBaseUrl + ":8080/product/";

        // Exercise
        driver.get(baseUrl + "list");
        String windowTitle = driver.findElement(By.tagName("h2")).getText();
        String tbodyContent = driver.findElement(By.tagName("tbody")).getText();

        // Verify
        assertEquals("Product' List", windowTitle);
        assertEquals("", tbodyContent);
    }

    @Test
    void createProduct(ChromeDriver driver) {
        // Given
        baseUrl = testBaseUrl + ":8080/product/";

        // Exercise
        driver.get(baseUrl + "list");
        driver.findElement(By.linkText("Create Product")).click();
        driver.findElement(By.name("productName")).sendKeys("Panda Pacil");
        driver.findElement(By.name("productQuantity")).sendKeys("1");
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

        // Verify
        String tbodyContent = driver.findElement(By.tagName("td")).getText();
        assertEquals("Panda Pacil", tbodyContent);
    }

    @Test
    void cancelCreateProduct(ChromeDriver driver) {
        // Given
        baseUrl = testBaseUrl + ":8080/product/";

        // Exercise
        driver.get(baseUrl + "list");
        driver.findElement(By.linkText("Create Product")).click();
        driver.findElement(By.name("productName")).sendKeys("Panda Pacil");
        driver.findElement(By.name("productQuantity")).sendKeys("1");
        driver.get(baseUrl + "list");

        // Verify
        String tbodyContent = driver.findElement(By.tagName("tbody")).getText();
        assertNotEquals("Panda Pacil", tbodyContent);
    }
}
