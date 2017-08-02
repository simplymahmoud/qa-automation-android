package com.noon.mobileapp;

import com.noon.mobileapp.base.BaseTest;
import com.noon.mobileapp.pages.AddressPage;
import com.noon.mobileapp.pages.SideMenuPage;
import com.noon.mobileapp.pages.SigninPage;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Ignore;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.testng.annotations.Test;

import static org.slf4j.LoggerFactory.getLogger;

public class AddAddressTest extends BaseTest {
	
String testName="AddAddressTest";

	@Test
	public void addAddressInMyAddressesTest() throws InterruptedException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the Address in test");

		String userName = "testnoon10@gmail.com";
		String password = "Test1234";
		emptyCart(userName,password);		emptyCart(userName,password);
		launchApp();
		allowAppPermission();
		test.log(LogStatus.INFO, "App Launch successfully");
		
		SigninPage signinPage = new SigninPage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver),signinPage);
		AddressPage addressPage = new AddressPage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver),addressPage);
		SideMenuPage sideMenuPage = new SideMenuPage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver),sideMenuPage);


		
		signinPage.signinWithEmail(userName,password);
		sideMenuPage.goToMenuPage();
		addressPage.goToAddressBook();
		addressPage.addAnotherAddress();
//		addressPage.addFirstAddress();
		addressPage.addAddressSteps("Building","1", "2", "street a", "055000000000");

		
		test.log(LogStatus.PASS, "Test Passed");
	}

}
