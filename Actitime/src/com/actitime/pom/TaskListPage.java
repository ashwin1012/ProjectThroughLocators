package com.actitime.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TaskListPage {
	
@FindBy(xpath="//div[text()='Add New']")
 WebElement addNewBtn;
	
@FindBy(xpath="//div[text()='+ New Customer']")
 WebElement newCustomer;
	
@FindBy(xpath="(//input[@placeholder='Enter Customer Name'])[2]")
private WebElement enterCustomerNameTbx;

@FindBy(xpath="//textarea[@placeholder='Enter Customer Description']")
private WebElement enterCustomerDescription;

@FindBy(xpath="//div[text()='- Select Customer -' and @class='emptySelection']")
private WebElement selectCustomerDD;

@FindBy(xpath="//div[text()='Our company' and @class='itemRow cpItemRow ']")
private WebElement ourCompanyTx;

@FindBy(xpath="//div[text()='Create Customer']")
private WebElement createCustomerBtn;

@FindBy(xpath="//div[@class='titleEditButtonContainer']/div[1]")
private WebElement actualCustomerCreated;

public TaskListPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public WebElement getAddNewBtn() {
	return addNewBtn;
}

public WebElement getNewCustomer() {
	return newCustomer;
}

public WebElement getEnterCustomerNameTbx() {
	return enterCustomerNameTbx;
}

public WebElement getEnterCustomerDescription() {
	return enterCustomerDescription;
}

public WebElement getSelectCustomerDD() {
	return selectCustomerDD;
}

public WebElement getOurCompanyTx() {
	return ourCompanyTx;
}

public WebElement getCreateCustomerBtn() {
	return createCustomerBtn;
}

public WebElement getActualCustomerCreated() {
	return actualCustomerCreated;
}


}








