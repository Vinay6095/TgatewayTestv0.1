package gateway.pages;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gateway.base.TestBase;

public class LoginPage extends TestBase {
	
	
	//page factory - OR
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath="//button[@class='login100-form-btn']")
	WebElement loginbtn;
	 
	//Initializing page objects:
	public LoginPage() throws IOException {
		
		PageFactory.initElements(driver, this);
		
	}
	//Actions:
public String validateLoginPageTitle() {
	
	return driver.getTitle();
	
}

public HomePage Login(String un, String pwd) throws InterruptedException, IOException {
	
	username.sendKeys(un);
	password.sendKeys(pwd);
	loginbtn.click();
	
	Thread.sleep(3000);
	String pagetitle=driver.getTitle();
	System.out.println(pagetitle);
	
	if(pagetitle.equals("Dashboard")) {
		//System.out.println("insidehome page");
		return new HomePage();
	}else {
	 return null;
	}
	//return new HomePage();
}


}
	

