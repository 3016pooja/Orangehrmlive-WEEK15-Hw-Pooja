package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(name= "username")
    WebElement userNameField ;
 //By userNameField=By.name("username");

    @CacheLookup
    @FindBy(name = "password")
    WebElement passwordField ;
 //By passwordField=By.name("password");

    @CacheLookup
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginButton ;

    @CacheLookup
    @FindBy(xpath = "//header/div[1]/div[1]/span[1]/h6[1]")
    WebElement verifyText ;
//By verifyText=By.xpath("//header/div[1]/div[1]/span[1]/h6[1]");

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/p[1]")
    WebElement forgotPassword ;
//By forgotPassword=By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/form[1]/div[4]/p[1]");

    @CacheLookup
    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[1]/form[1]/h6[1]")
    WebElement verifyText1 ;
    //By verifyText1=By.xpath("//body/div[@id='app']/div[1]/div[1]/div[1]/form[1]/h6[1]");

    public void enterUsername(String username){
        Reporter.log("Enter password to the  field"+username+ userNameField.toString());
        sendTextToElement(userNameField,username);
       CustomListeners.test.log(Status.PASS,"Enter username" + username);

    }
public void enterPassword(String passwprd){
    Reporter.log("Enter password to the  field"+passwprd+ passwordField.toString());
    sendTextToElement(passwordField,passwprd);
  CustomListeners.test.log(Status.PASS,"Enter password " + passwprd);
}
public void clickOnLoginButton(){
    Reporter.log("click the login button"+ loginButton.toString());
    clickOnElement(loginButton);
    CustomListeners.test.log(Status.PASS,"click to login button ");
}
public String verifyTheTextDashboard(){
    Reporter.log("verify the text dashboard");
    String message=getTextFromElement(verifyText);
  CustomListeners.test.log(Status.PASS,"Get error Message");
    return message;
}
    //click on the ‘Forgot your password’ link
    public void clickOnForgotPassword(){

        Reporter.log("click the forgotpassword button"+ forgotPassword);
        clickOnElement(forgotPassword);
       CustomListeners.test.log(Status.PASS,"click to forgotpassword button ");
    }

    public String verifyTextResetPassword(){
        Reporter.log("returning Customer Text");
        String message=getTextFromElement(verifyText1);
       CustomListeners.test.log(Status.PASS,"Get error Message");
        return message;
    }
}