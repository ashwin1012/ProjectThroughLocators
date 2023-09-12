package pages;

import genericPages.CommonMethods;

public class LoginPage extends CommonMethods {

	public LoginPage() throws Exception {
		super();
	}
	
	public void login() throws Exception {
		click("loginBtn");
		verifyElementPresent("loginTitle");
	}
	
	public void enterInvalidMobileNumber() throws Exception {
		enterData("phoneNumberInputBox", "invalidMobileNumber");
		click("loginWithOTPButton");
		verifyElementPresent("loginErrorMessage");
	}
	
}
