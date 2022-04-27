package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseUrl = "https://courses.ultimateqa.com/";
    @Before
    public void openUp(){
        openBrowser(baseUrl);
    }
  //  @After
    public void tearDoen(){
        closeBrowser();
    }
    @Test
    public void userShouldNavigateToLoginPageSuccessfully(){
//lolocate signin button

        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));

        //This is requirement
        String expectedText = "Welcome Back!";
        //actual text
       String actualText= getTextFromElement(By.tagName("h1"));

        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void verifyTheErrorMessage(){
        //locate sign in
        clickOnElement(By.xpath("//header/div[1]/div[1]/section[1]/ul[1]/li[1]/a[1]"));

        //locate username field
        sendTextToElement(By.id("user[email]"),"abc@yahoo.com");

        //locate password Field
        sendTextToElement(By.id("user[password]"),"123456");

        // locate Click button
        clickOnElement(By.xpath("//body/main[@id='main-content']/div[1]/div[1]/article[1]/form[1]/div[4]/input[1]"));

        // this is requirement
        String expectedMessage = "Invalid email or password.";
        //actual Text
        String actualMessage = getTextFromElement(By.xpath("//li[contains(text(),'Invalid email or password.')]"));
        Assert.assertEquals(expectedMessage,actualMessage);

    }
}
