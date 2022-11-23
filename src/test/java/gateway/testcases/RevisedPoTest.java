package gateway.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gateway.base.TestBase;
import gateway.pages.HomePage;
import gateway.pages.LoginPage;
import gateway.pages.PurchaseOrderListPage;

public class RevisedPoTest extends TestBase {
	
	LoginPage Login;
	HomePage Home;
	PurchaseOrderListPage Order;
	

	public RevisedPoTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() throws IOException, InterruptedException {

		initialisation();

		Login = new LoginPage();

		Home = new HomePage();
		Order = new PurchaseOrderListPage();
		Home = Login.Login(prop.getProperty("username"), prop.getProperty("pass"));

		Order = Home.VerifyingOrderManagement();

	}
	
	@Test(priority = 1)

	public void TC44() throws IOException, InterruptedException {

		Order.VerifyPurchaseOrderPage();
		Order.RevicedNotification();
	}
	
	
	@Test(priority = 2)

	public void TC45() throws IOException, InterruptedException {

		Order.VerifyPurchaseOrderPage();
		Order.RevicedNotification();
		Order.SelectFilter(prop.getProperty("RevisedFilter"));
		Order.ClickApply();
		Thread.sleep(2000);
		Order.NavigatingPoDetailes();
		Order.HamburgerButton();
		Thread.sleep(1000);
		Order.VerifyingPopupdetailes();
		
	}
	
	
	
	
	
	@Test(priority = 3)

	public void TC46() throws IOException, InterruptedException {

		Order.VerifyPurchaseOrderPage();
		//Order.RevicedNotification();
		char[] FirstText=driver.findElement(By.xpath("//p[@id='notification']")).getText().toCharArray();
		System.out.println(FirstText);
		
		String str = "";
		int n = FirstText.length;
		int First = 0;
		
		
		
		for (int i = 0; i < n; i++) {
			 
	        
	       if (FirstText[i] - '0' >= 0 && FirstText[i] - '0' <= 9) {
	      
        	str += FirstText[i];
        	
        	Thread.sleep(1000);
        	
	        }	
	}
		First = Integer.parseInt(str);
		System.out.println("Total no of Reviced Po's First "+First);
		
		
		
		
		Order.SelectFilter(prop.getProperty("RevisedFilter"));
		Order.ClickApply();
		Thread.sleep(2000);
		
		
		Order.NavigatingPoDetailes();
		Order.SelectAction(prop.getProperty("Selectvalue"));
		
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		
		Home.VerifyingOrderManagement();
		
		char[] NextText=driver.findElement(By.xpath("//p[@id='notification']")).getText().toCharArray();
		System.out.println(NextText);
		
		String ntr = "";
		int l = NextText.length;
		int Next = 0;
		
		
		
		for (int i = 0; i < l; i++) {
			 
	        
	       if (NextText[i] - '0' >= 0 && NextText[i] - '0' <= 9) {
	      
	    	   ntr += NextText[i];
        	
        	Thread.sleep(1000);
        	
	        }	
	}
		Next = Integer.parseInt(ntr);
		System.out.println("Total no of Reviced Po's Next "+Next);
		
		
		
		int revisedPo=First-1;
		System.out.println(revisedPo);
		
		Assert.assertEquals(Next, revisedPo );
		
		
	}
	
	
	@Test(priority = 4)

	public void TC47() throws IOException, InterruptedException {

		Order.TotalREVACTPOs();
	}
	
	
	@Test(priority = 5)

	public void TC48() throws IOException, InterruptedException {

		Order.TotalREVRJCTPos();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void close() {
		driver.quit();
	}
	
	


}
