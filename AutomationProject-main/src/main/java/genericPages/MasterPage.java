package genericPages;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class MasterPage {

	public static WebDriver driver;
	public Properties propConfig;
	public Properties propLocator;
	public Properties propTestData;

	// Constructor Implementation
	public MasterPage() throws Exception {

		// Configuration properties file Implementation
		FileInputStream fisConfig = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\configuration.properties");
		propConfig = new Properties();
		propConfig.load(fisConfig);

		// Locators properties file Implementation
		FileInputStream fisLoc = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\locators.properties");
		propLocator = new Properties();
		propLocator.load(fisLoc);

		// Test data Properties file Implementation
		FileInputStream fisTestData = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\resources\\repository\\testdata.properties");
		propTestData = new Properties();
		propTestData.load(fisTestData);
	}

}
