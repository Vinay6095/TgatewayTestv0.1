package gateway.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gateway.base.TestBase;
import gateway.pages.HomePage;
import gateway.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage login;
	

	public LoginPageTest() throws IOException {
		super();
	
	}
	
	@BeforeMethod
	public void SetUp() throws IOException {
		
		initialisation();
		
		login=new LoginPage();
	}
	
	
	
	@Test(priority=1)
		
		public void logintest() throws InterruptedException, IOException {
			
		login.Login(prop.getProperty("username"), prop.getProperty("pass"));
			
	}
		
	@AfterMethod
	public void close() {
		driver.quit();
	}
		
		
	}

