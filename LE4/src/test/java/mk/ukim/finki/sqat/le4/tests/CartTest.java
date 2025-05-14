package mk.ukim.finki.sqat.le4.tests;

import mk.ukim.finki.sqat.le4.pages.ProductPage;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CartTest extends BaseTest {

    @Test
    public void testAddProductToCart() {
        ProductPage productPage = new ProductPage(driver, wait);
        String productName = "Apple Juice (1000ml)";
        productPage.addProductToCart(productName);
        productPage.openCart();
        assertTrue("Производот не е додаден во кошничката.", productPage.isProductInCart(productName));
    }

    @Test
    public void testRemoveProductFromCart() {
        ProductPage productPage = new ProductPage(driver, wait);
        String productName = "Apple Juice (1000ml)";
        productPage.addProductToCart(productName);
        productPage.openCart();
        assertTrue("Производот не е додаден во кошничката.", productPage.isProductInCart(productName));
        productPage.removeProductFromCart(productName);
        assertFalse("Производот не е отстранет од кошничката.", productPage.isProductInCart(productName));
    }
}