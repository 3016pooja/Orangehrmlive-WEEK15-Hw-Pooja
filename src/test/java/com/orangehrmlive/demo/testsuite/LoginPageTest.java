package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(CustomListeners.class)

public class LoginPageTest extends BaseTest {
  LoginPage loginPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage=new LoginPage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        loginPage.enterUsername("Admin");

        loginPage.enterPassword("admin123");       // Enter “admin123“ password
        loginPage.clickOnLoginButton();// 	lick on ‘LOGIN’ button
        loginPage.verifyTheTextDashboard();//Verify the ‘Dashboard’ text is display
        Assert.assertEquals(loginPage.verifyTheTextDashboard(),"Dashboard","Error message not displayed");

    }
    @Test(groups = {"smoke","regression"})
    public void  userShouldNavigateToForgotPasswordPageSuccessfully(){
        loginPage.clickOnForgotPassword();

        loginPage.verifyTextResetPassword();  //verify the text 'Reset Password'
        Assert.assertEquals(loginPage.verifyTextResetPassword(),"Reset Password","Error message not displayed");

    }


}
