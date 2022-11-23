package gateway.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gateway.base.TestBase;
import gateway.pages.HomePage;
import gateway.pages.LoginPage;
//import gateway.pages.PurchaseOrderListPage;

public class HomePageTest extends TestBase {
	
	LoginPage login;
	HomePage Home;
	//PurchaseOrderListPage PO;

	public HomePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() throws IOException, InterruptedException {
		
		initialisation();
		
		login=new LoginPage();
		
		Home= new HomePage();
		
		
		Home=login.Login(prop.getProperty("username"), prop.getProperty("pass"));
		
		
	}
	
	@Test(priority=1)
	
	public void Order() throws IOException, InterruptedException {
		
		Home.VerifyingOrderManagement();
		
	}
	
	
	
	@AfterMethod
	public void close() {
	driver.quit();
	}
}
