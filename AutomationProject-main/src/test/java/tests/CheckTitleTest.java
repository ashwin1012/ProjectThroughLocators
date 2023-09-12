package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import genericPages.CommonMethods;
import genericPages.MasterPage;
import pages.HomePage;
import pages.LoginPage;

public class CheckTitleTest extends CommonMethods {

	
	public CheckTitleTest() throws Exception {
	}

	@BeforeClass
	public void beforeTest() {
		// Open the browser and hit the url
		initializeBrowser();
	}

	@Test
	public void checkTitle() throws Exception {
		test = reports.startTest("TC001 Verify all menu's on the home page");
		HomePage homePage = new HomePage();
		
		// Verify beauty page title
		homePage.verifyBeautyPageTitle();
		
		// Verify hair page title
		homePage.verifyHairPageTitle();
		
		// Verify face page title
		homePage.verifyFacePageTitle();
		
		// Verify body page title
		homePage.verifyBodyPageTitle();
		
		// Verify makeup page title
		homePage.verifyMakeupPageTitle();
	}

	
	@AfterClass
	public void afterTest() {
		// Close the browser
		driver.quit();
		reports.endTest(test);
		reports.flush();
	}

}
