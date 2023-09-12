package pages;

import genericPages.CommonMethods;

public class HomePage extends CommonMethods {

	public HomePage() throws Exception {
	}

	public void verifyBeautyPageTitle() throws Exception {
		click("beautyMenu");
		verifyElementPresent("beautyPageTitle");
	}

	public void verifyHairPageTitle() throws Exception {
		click("hairMenu");
		Thread.sleep(1000);
		verifyElementPresent("hairPageTitle");
	}

	public void verifyFacePageTitle() throws Exception {
		click("faceMenu");
		Thread.sleep(1000);
		verifyElementPresent("facePageTitle");
	}

	public void verifyBodyPageTitle() throws Exception {
		click("bodyMenu");
		Thread.sleep(1000);
		verifyElementPresent("bodyPageTitle");
	}

	public void verifyMakeupPageTitle() throws Exception {
		click("makeupMenu");
		Thread.sleep(1000);
		verifyElementPresent("makeupPageTitle");
	}

	public void searchProduct() throws Exception {
		click("searchBox");
		enterData("searchInputBox", "searchText");
		Thread.sleep(1000);
	}

	public void addToCart() throws Exception {
		scrollDown();
		click("addToCartButton");
		verifyElementPresent("saveToCartDisplayMessage");
		click("addToCartLogo");
		verifyElementPresent("cartItemTitle");
	}

	public void removeFromCart() throws Exception {
		click("removeItemMinusButton");
		verifyElementPresent("removedFromCartMessage");
	}

    public void clickBackLogin() {
    	click("backToLoginPage");
    }
}
