package TestCases;
import Core.BaseDriver;
import Mapping.NewWebCheckboxesPage;
import Mapping.NewWebHomePage;
import Mapping.OldWebsiteHomePage;
import Mapping.OldWebsiteSignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class OldWebsiteSignInPageTestCases extends BaseDriver {

@BeforeTest
    public void SignInPageTestCases() {
    startSession();
    PageFactory.initElements(driver, OldWebsiteHomePage.class);
    PageFactory.initElements(driver, OldWebsiteSignInPage.class);
}

@Test
    public void CannotLogInWithBadCredentials() throws InterruptedException {
    OldWebsiteHomePage.signInButton.click();
    Thread.sleep(1000);
    OldWebsiteSignInPage.emailTextFiled.sendKeys("dudi@email.com");
    Thread.sleep(1000);
    OldWebsiteSignInPage.passwordTextField.sendKeys("AutomationIsTheBest");
    Thread.sleep(1000);
    OldWebsiteSignInPage.applySignInButton.click();
    String ErrorMSGtext = OldWebsiteSignInPage.authenticationFailedError.getText();
    Assert.assertTrue(ErrorMSGtext.equals("Authentication Failed"));
}


    public static class CheckboxesTestCases extends BaseDriver {

        @BeforeTest
        public void CheckboxesTestCases() {
            startSession();
            PageFactory.initElements(driver, NewWebCheckboxesPage.class);
            PageFactory.initElements(driver, NewWebHomePage.class);
        }

        @Test
        public void checkTheFirstCheckbox() throws InterruptedException {
            Thread.sleep(1000);
            NewWebHomePage.checkboxesPageLink.click();
            Thread.sleep(1000);
            NewWebCheckboxesPage.checkboxesNumber1.click();
            Thread.sleep(5000);
            NewWebCheckboxesPage.checkboxesNumber2.click();
            Thread.sleep(5000);

            Thread.sleep(1000);
            driver.findElement(By.id("//*[@id='content']/ul/li[6]/a")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("//*[@id='checkboxes']/input[1]")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("//*[@id='checkboxes']/input[2]")).click();



            //WebElement checkBoxElement1 = NewWebCheckboxesPage.checkboxesNumber1;
            boolean isSelected = NewWebCheckboxesPage.checkboxesNumber1.isSelected();
            if (isSelected == true){
                NewWebCheckboxesPage.checkboxesNumber1.click();
                Thread.sleep(5000);

            }
        }

        @AfterTest
        public void CheckboxesTestCasesFinish(){
            stopSession();
        }
    }
}
