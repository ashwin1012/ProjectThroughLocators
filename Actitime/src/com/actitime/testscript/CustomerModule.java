package com.actitime.testscript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.Baseclass;
import com.actitime.pom.HomePage;
import com.actitime.pom.TaskListPage;

public class CustomerModule extends Baseclass{

	@Test(priority=1)
	public void testCreateCustomer() throws EncryptedDocumentException, IOException, InterruptedException  {
		String customerName = f.getExcelData("CreateCustomer", 1, 2);
		String customerDescription = f.getExcelData("CreateCustomer", 1, 3);
		System.out.println(customerName);
		HomePage h=new HomePage(driver);
		Thread.sleep(4000);
		h.setTasks();
		Thread.sleep(2000);
		TaskListPage t=new TaskListPage(driver);
		t.getAddNewBtn().click();
		Thread.sleep(4000);
		t.getNewCustomer().click();
		Thread.sleep(4000);
		t.getEnterCustomerNameTbx().sendKeys(customerName);
		t.getEnterCustomerDescription().sendKeys(customerDescription);
		t.getSelectCustomerDD().click();
		Thread.sleep(2000);
		t.getOurCompanyTx().click();
		t.getCreateCustomerBtn().click();
		String actualCustomerTx = t.getActualCustomerCreated().getText();
		Assert.assertEquals(actualCustomerTx, customerName);
	}	
}






