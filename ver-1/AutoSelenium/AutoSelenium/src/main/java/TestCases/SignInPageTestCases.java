package TestCases;
import Core.BaseDriver;
import Mapping.HomePage;
import Mapping.SignInPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class SignInPageTestCases extends BaseDriver {

@BeforeTest
    public void SignInPageTestCases() {
    startSession();
    PageFactory.initElements(driver, HomePage.class);
    PageFactory.initElements(driver, SignInPage.class);
}

@Test
    public void CannotLogInWithBadCredentials(){
    HomePage.signInButton.click();
    SignInPage.emailText.sendKeys("dudi@email.com");
    SignInPage.passwordText.sendKeys("AutomationIsTheBest");
    SignInPage.applySignInButton.click();
    String ErrorMSGtext = SignInPage.authenticationFailedError.getText();
    Assert.assertTrue(ErrorMSGtext.equals("Authentication Failed"));
}



}
