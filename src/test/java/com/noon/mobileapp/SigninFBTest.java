package com.noon.mobileapp;

import com.noon.mobileapp.base.BaseTest;
import com.noon.mobileapp.pages.SigninPage;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SigninFBTest extends BaseTest {
	
String testName="SigninFacebookTest";

	@Test
	public void loginFacebookTest() throws InterruptedException {
		test = rep.startTest(testName);
		test.log(LogStatus.INFO, "Starting the Sign FB test");

		launchApp();
		allowAppPermission();
		test.log(LogStatus.INFO, "App Launch successfully");
		
		SigninPage signinPage = new SigninPage(aDriver,test);
		PageFactory.initElements(new AppiumFieldDecorator(aDriver),signinPage);

		String userName = "testnoon11@gmail.com";
		String password = "W3lcome!";
		
		signinPage.signinWithFB(userName,password);
		signinPage.verifyLogin();
		signinPage.logout();

		test.log(LogStatus.PASS, "Test Passed");
	}
}
