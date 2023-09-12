package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import genericPages.CommonMethods;
import pages.*;

public class HomeTest extends CommonMethods {

	public HomeTest() throws Exception {
	}

	@BeforeClass
	public void beforeTest() {
		// Open the browser and hit the url
		initializeBrowser();
	}

	
	@Test(priority=1)
	public void searchAndAddToCart() throws Exception {
		test = reports.startTest("TC001 Search and add product to cart");
		HomePage homePage = new HomePage();

		// Search the product
		homePage.searchProduct();

		// Add product to the cart and verify it is added successfully
		homePage.addToCart();

		// Remove product from cart
		homePage.removeFromCart();
		
		//Back To homepage
		homePage.clickBackLogin();
	}

	@Test(priority=2)
	public void loginWithInvalidNumber() throws Exception {
		test = reports.startTest("TC002 Verify login functionality with invalid mobile number");
		LoginPage loginPage = new LoginPage();

		// Open login page
		loginPage.login();

		// Verify login functionality with invalid mobile number
		loginPage.enterInvalidMobileNumber();
	}

	@AfterClass
	public void afterTest() {
		// Close the browser
		driver.quit();
		reports.endTest(test);
		reports.flush();
	}

}
