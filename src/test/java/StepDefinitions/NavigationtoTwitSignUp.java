package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageClass.LogInPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class NavigationtoTwitSignUp {
	
	public WebDriver driver;
	LogInPage logInPage;
	
	@Given("^User is on Login Page$")
	public void user_is_on_login_page() {
	    // Initiate chrome browser
		String path = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver",path+"\\src\\test\\java\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		//Created an object of driver
		driver = new ChromeDriver(options);
	    // Enter the url of the website which needs to be navigated
		driver.get("https://twitter.com/login");
		//Wait for 10 seconds to load the page
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		logInPage = new LogInPage(driver);
	}
	
	@Then("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(10000);
		System.out.println(arg1 + " " + arg2 );
	    logInPage.setUserName(arg1);
	    logInPage.setPassword(arg2);
	}

@Then("^clicks on Log In link$")
public void clicks_on_Log_In_link() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	logInPage.clickLogInLink();
}

@Then("^User is logged in successfully$")
public void user_is_logged_in_successfully() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	try {
	//Wait for element to be visible then verify header
	WebDriverWait wait = new WebDriverWait(driver, 30);     
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'What’s happening')]")));
	}
	finally {
	//Close browser
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.quit();
	}
}

@Then("^Login Error is displayed$")
public void login_Error_is_displayed() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    Assert.assertEquals(logInPage.isLoginErrorDisplayed(), true);
}

@Then("^clicks on Profile option$")
public void user_click_on_profile_option() {
	// Click on profile link
	logInPage = new LogInPage(driver);
	logInPage.clickProfileLink();
	
}

@Then("^Profile Page is displayed$")
public void profile_page_is_displayed() throws Throwable {
	try {
		// Wait for element to be visible then verify header
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Set up profile')]")));
	} finally {
		// Close browser
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.quit();
	}
	Assert.assertEquals(logInPage.isProfilePageDisplayed(), true);
	}

}
	

