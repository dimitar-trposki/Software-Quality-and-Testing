package mk.ukim.finki.sqat.le4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void addProductToCart(String productName) {
        // Најди го производот по име и кликни на копчето за додавање во кошничка

        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("mat-card")));
        for (WebElement product : products) {
            if (product.getText().contains(productName)) {
                WebElement addButton = product.findElement(By.cssSelector("button[aria-label='Add to Basket']"));
                addButton.click();
                break;
            }
        }
    }

    public void openCart() {
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[aria-label='Show the shopping cart']")));
        cartButton.click();
    }

    public boolean isProductInCart(String productName) {
        // Проверка дали производот е присутен во кошничката

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-row[contains(.,'" + productName + "')]")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void removeProductFromCart(String productName) {
        // Отстрани го производот од кошничката

        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//mat-row[contains(.,'" + productName + "')]")));
        WebElement removeButton = cartItem.findElement(By.cssSelector("mat-icon[aria-label='Remove Item']"));
        removeButton.click();
    }

}
