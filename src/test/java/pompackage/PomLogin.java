package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseClass;

public class PomLogin extends BaseClass {
	
  
	@FindBy(id="txtUsername") WebElement Username;
	// Creating Object Repository //driver.findElement(By.	
	@FindBy(id="txtPassword") WebElement Password;
	@FindBy(id="btnLogin") WebElement Loginbutton;
	@FindBy(css="#forgotPasswordLink > a") WebElement Forgotpassword;
	@FindBy(css="#divLogo > img") WebElement Logo;
	
	//Initiate page elements
	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
	
	public void typeusername(String name) {
		Username.sendKeys(name);
	}
	
	public void typepassword(String password) {
		Password.sendKeys(password);
	}
	
	public void clickloginbutton() {
		Loginbutton.click();
	}
	
	/*public void forgotpasswd() {
		Forgotpassword.click();
	}
	
	public void displaylogo() {
		Logo.isDisplayed();
	}
	
	public String verify() {
		return driver.getTitle();*/
		
public String verify() {
	return driver.getTitle();
} }
