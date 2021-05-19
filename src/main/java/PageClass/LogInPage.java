package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {
	
	WebDriver driver;

    //By signUpLink = By.linkText("Sign Up");
    
    @FindBy(how = How.NAME, using = "session[username_or_email]")
    private WebElement userName;

    @FindBy(how = How.NAME, using = "session[password]")
    private WebElement password;
    
    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'css-901oao css-16my406 r-poiln3 r-bcqeeo r-qvutc0') and text() = 'Log in']")
    private WebElement logInLink;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'The username and password you entered did not match our records')]")
    private WebElement logInErrorText;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Profile')]")
    private WebElement profileLink;
    
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Set up profile')]")
    private WebElement profilePage_SetUpProfile;
    
    public LogInPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void setUserName(String userName) {
    	this.userName.sendKeys(userName);
    }
    
    public void setPassword(String password) {
    	this.password.sendKeys(password);
    }
    
    public void clickLogInLink() {
    	logInLink.click();
    }

    public boolean isLoginErrorDisplayed() {
    	return logInErrorText.isDisplayed();
    }
    
    public void clickProfileLink() {
    	profileLink.click();
    }
    
    public boolean isProfilePageDisplayed() {
    	return profilePage_SetUpProfile.isDisplayed();
}
}


