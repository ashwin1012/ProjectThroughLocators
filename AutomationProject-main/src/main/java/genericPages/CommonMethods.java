package genericPages;

import java.io.File;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CommonMethods extends MasterPage {

	public static ExtentTest test;
	public static ExtentReports reports = new ExtentReports("src\\main\\resources\\reports\\ExtentReport.html", false);

	public CommonMethods() throws Exception {
	}

	// Initializing the browser
	public void initializeBrowser() {

		if (propConfig.getProperty("browser").equalsIgnoreCase("chrome")) {
			ChromeOptions o = new ChromeOptions();
			o.addArguments("--disable-notifications");
			o.addArguments("--remote-allow-origins=*");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(o);
		} else if (propConfig.getProperty("browser").equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\drivers\\geckodriver.exe");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(propConfig.getProperty("url"));
	}

	// Click on the webelement
	public void click(String locatorKey) {
		try {
			getWebElement(locatorKey).click();
			test.log(LogStatus.PASS, "Click on the element: " + locatorKey,
					"Click on the element " + locatorKey + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Click on the element: " + locatorKey,
					"Failed to click on the element " + locatorKey + e.getLocalizedMessage());
		}

	}

	// Enter the Data
	public void enterData(String locatorKey, String testData) {
		try {

			getWebElement(locatorKey).sendKeys(propTestData.getProperty(testData));
			test.log(LogStatus.PASS, "Enter the : " + locatorKey, "Enter the text into " + testData + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Enter the : " + locatorKey, "Failed to enter " + testData + e.getMessage());
		}

	}

	// Clear the Data
	public void clearData(String locatorKey) {
		try {
			getWebElement(locatorKey).clear();
			test.log(LogStatus.PASS, "Clear the data : " + locatorKey,
					"Clear the data " + locatorKey + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Clear the data : " + locatorKey,
					"Failed to clear the data " + locatorKey + e.getMessage());
		}

	}

	// Mouse Hover
	public void moveToElement(String locatorKey) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(getWebElement(locatorKey)).build().perform();
			test.log(LogStatus.PASS, "Move to the element : " + locatorKey,
					"Move to the element " + locatorKey + "Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Move to the element : " + locatorKey,
					"Failed to move to the element " + locatorKey);
		}

	}

	// Click List of WebElement
	public void clickListElement(String locatorKey, String testData) {
		try {
			List<WebElement> listOfElements = driver
					.findElements(By.xpath(propLocator.getProperty(locatorKey.split(",")[1])));
			for (int i = 0; i < listOfElements.size(); i++) {
				if (listOfElements.get(i).getText().equalsIgnoreCase(propLocator.getProperty(testData))) {
					listOfElements.get(i).click();
				}
			}
			test.log(LogStatus.PASS, "Click on the list element : " + locatorKey,
					"Click on the list element " + locatorKey + "Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Click on the list element : " + locatorKey,
					"Failed to click on the list element ");
		}
	}

	// Click on Radio button
	public void clickRadioButton(String locatorKey) {
		try {
			List<WebElement> radios = driver.findElements(By.xpath(propLocator.getProperty(locatorKey.split(",")[1])));
			String expResult = "testData1";
			for (int i = 0; i < radios.size(); i++) {
				if (radios.get(i).getText().equalsIgnoreCase(expResult)) {
					radios.get(i).click();
					break;
				}
			}
			test.log(LogStatus.PASS, "Click on the radio button : " + locatorKey,
					"Click on the radio button " + locatorKey + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Click on the radio button : " + locatorKey,
					"Failed to Click on the radio button " + e.getMessage());
		}

	}

	// Take a Screenshot
	public String takeScreenShot(String imageName) throws Exception {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destLocation = System.getProperty("user.dir") + "\\src\\main\\resources\\reports\\screenshots\\"
				+ imageName + ".png";
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir")
				+ "\\src\\main\\resources\\reports\\screenshots\\" + imageName + ".png"));
		return "screenshots\\" + imageName + ".png";
	}

	// Select the dropdown values
	public void selectDropdown(String locatorKey) {
		try {
			WebElement element = driver.findElement(By.xpath(propLocator.getProperty(locatorKey)));
			Select webElem = new Select(element);
			webElem.selectByVisibleText("testData");
			test.log(LogStatus.PASS, "Select the dropdown value : " + locatorKey,
					"Select the dropdown value " + locatorKey + " Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Select the dropdown value : " + locatorKey,
					"Faile to Select the dropdown value " + e.getMessage());
		}

	}

	// Alert operation
	public void alertHandling() {
		try {
			Alert alert = driver.switchTo().alert();
			driver.switchTo().alert().accept();
			test.log(LogStatus.PASS, "Alert handlled Successfully");
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Failed to handlled the Alert");
		}

	}

	// Scroll down using javascript
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
	}

	// Scroll till the Element
	public void scrollTillElement(String locatorKey) throws Exception {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", locatorKey);
	}

	// To get webelement
	public WebElement getWebElement(String locatorKey) throws Exception {
		try {
			String locatorValues[] = propLocator.getProperty(locatorKey).split(";");
			String locatorType = locatorValues[0].trim();
			String locatorValue = locatorValues[1].trim();
			WebElement element = null;
			if (locatorType.equalsIgnoreCase("id")) {
				element = driver.findElement(By.id(locatorValue));
			} else if (locatorType.equalsIgnoreCase("class")) {
				element = driver.findElement(By.className(locatorValue));
			} else if (locatorType.equalsIgnoreCase("css")) {
				element = driver.findElement(By.cssSelector(locatorValue));
			} else if (locatorType.equalsIgnoreCase("xpath")) {
				element = driver.findElement(By.xpath(locatorValue));
			} else if (locatorType.equalsIgnoreCase("linktext")) {
				element = driver.findElement(By.linkText(locatorValue));
			}

			return element;
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Get the WebElement : " + locatorKey, "Failed to get the WebElement "
					+ e.getMessage() + test.addScreenCapture(takeScreenShot(locatorKey)));
			return null;
		}
	}

	// To get list of webelements
	public List<WebElement> getWebElements(String locatorkey) {
		String locatorValues[] = propLocator.getProperty(locatorkey).split(",");
		String locatorType = locatorValues[0].trim();
		String locatorValue = locatorValues[1].trim();
		List<WebElement> elements = null;
		if (locatorType.equalsIgnoreCase("id")) {
			elements = driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("class")) {
			elements = driver.findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("css")) {
			elements = driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			elements = driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("linktext")) {
			elements = driver.findElements(By.linkText(locatorValue));
		}
		return elements;
	}

	// Verify element presence on webpage
	public void verifyElementPresent(String locatorkey) throws Exception {
		try {
			getWebElement(locatorkey).isDisplayed();
			test.log(LogStatus.PASS, "Verify element presence:" + locatorkey,
					"Text '" + getWebElement(locatorkey).getText() + "' is displayed Successfully"
							+ test.addScreenCapture(takeScreenShot(locatorkey)));
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Verify element presence: " + locatorkey,
					"Text '" + getWebElement(locatorkey).getText() + "' is not displayed");
		}
	}

}
