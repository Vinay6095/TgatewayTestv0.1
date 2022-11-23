package gateway.testcases;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gateway.base.TestBase;
import gateway.pages.ASNListPage;
import gateway.pages.HomePage;
import gateway.pages.LoginPage;
import gateway.pages.PurchaseOrderListPage;

public class ASNListTest extends TestBase {
	
	LoginPage Login;
	HomePage Home;
	ASNListPage ASN;

	public ASNListTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() throws IOException, InterruptedException {

		initialisation();

		Login = new LoginPage();

		Home = new HomePage();
		ASN= new ASNListPage();

		Home = Login.Login(prop.getProperty("username"), prop.getProperty("pass"));
		ASN=Home.ASNPageVerify();

	}
	
	@Test(priority = 1)
	public void TC1() throws InterruptedException {
		
		ASN.VerifyASNPage();
		ASN.VerifyTotalPos();
	}
	
	@Test(priority = 1)
	public void TC3() throws InterruptedException {
		
		ASN.Resetbtn();
		ASN.SelectFromDate(prop.getProperty("Afromyear"), prop.getProperty("Afrommonth"));
		ASN.SelectToDate(prop.getProperty("Atoyear"), prop.getProperty("Atomonth"));
		ASN.ClickOnApply();
		Thread.sleep(1000);
		ASN.ValidationDate();
	}
	
	@Test(priority = 1)
    public void TC4() throws InterruptedException {
		
		ASN.VerifyASNPage();
		ASN.SelectFilter(prop.getProperty("Aselectfilter"));
		ASN.ClickOnApply();
		Thread.sleep(3000);
		ASN.SelectFilterValidations();
		
	}
	
	@Test(priority = 1)
    public void TC5() throws InterruptedException {
		
		ASN.VerifyASNPage();
		ASN.ReceiverFilter(prop.getProperty("Arecieverfilter"));
		ASN.ClickOnApply();
		Thread.sleep(3000);
		ASN.ReceieverFilterValidation();
		
	}
	
	
	
	
	


	
	
	
	
	
	
	
	
	
	
	

}
