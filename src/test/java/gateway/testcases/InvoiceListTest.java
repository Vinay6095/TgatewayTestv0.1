package gateway.testcases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gateway.base.TestBase;
import gateway.pages.HomePage;
import gateway.pages.InvoiceListPage;
import gateway.pages.LoginPage;

public class InvoiceListTest extends TestBase {
	LoginPage Login;
	HomePage Home;
	InvoiceListPage Invoice;

	public InvoiceListTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void SetUp() throws IOException, InterruptedException {
		
		initialisation();
		Login = new LoginPage();
		Home = new HomePage();
		Login.Login(prop.getProperty("username"), prop.getProperty("pass"));
		Home.VerifyingBillingAndPayment();
		Invoice=new InvoiceListPage();
		
	}
	
	@Test(priority=1)
	public void TC1() throws InterruptedException {
		Invoice.ResetBtn();
		Invoice.VerifyingInvoicepage();
		
	}
	
	@Test(priority=2)
	public void TC2() throws InterruptedException {
		//Invoice.ResetBtn();
		Invoice.SelectFromDate(prop.getProperty("ifromyear"), prop.getProperty("ifrommonth"));
		Invoice.SelectToDate(prop.getProperty("itoyear"), prop.getProperty("itomonth"));
		Invoice.ClickApply();
	}
	
	@Test(priority=3)
	public void TC3AndTC4() throws InterruptedException {
		Invoice.SelectFromDate(prop.getProperty("ifromyear"), prop.getProperty("ifrommonth"));
		Invoice.SelectToDate(prop.getProperty("itoyear"), prop.getProperty("itomonth"));
		Invoice.SelectFilter(prop.getProperty("iselectfilter"));
		Invoice.ClickApply();
		Thread.sleep(2000);
		Invoice.SelectFilterValidations();
	}
	
	
	@Test(priority=4)
	public void TC5() throws InterruptedException {
		Invoice.MultiSelectStatusFilter(prop.getProperty("iselectfilter1"), prop.getProperty("iselectfilter2"));
		Invoice.ClickApply();
		Thread.sleep(2000);
		Invoice.MultiSelectFilterValidations();
	}
	
	@Test(priority=5)
	public void TC6() throws InterruptedException {
		Invoice.StatusFilterCloseOptin();
	}
	
	@Test(priority=6)
	public void TC7() throws InterruptedException {
		Invoice.SearchOptioninStatusFilter();
	}
	
	@Test(priority=7)
	public void TC8() throws InterruptedException {
		Invoice.ReceiverFilter(prop.getProperty("irecieverfilter"));
		Invoice.ClickApply();
		Thread.sleep(2000);
		Invoice.ReceieverFilterValidation();
	}
	
	@Test(priority=8)
	public void TC9() throws InterruptedException {
		Invoice.MultiReceiverFilter(prop.getProperty("irecieverfilter1"), prop.getProperty("irecieverfilter2"));
		Invoice.ClickApply();
		Thread.sleep(2000);
		Invoice.MultiReceieverFilterValidation();
	}
	
	@Test(priority=9)
	public void TC10() throws InterruptedException {
		Invoice.Receiverfiltercloseoption();
	}
	
	@Test(priority=10)
	public void TC11() throws InterruptedException {
		Invoice.SearchOptioninReceiverFilter();
	}
	
	@Test(priority=11)
	public void TC12() throws InterruptedException {
		Invoice.RegionFilter(prop.getProperty("iregionfilter"));
		Invoice.ClickApply();
		//Invoice.RegionFilterValidation();
	}
	
	@Test(priority=12)
	public void TC13() throws InterruptedException {
		Invoice.MultiRegionFilter(prop.getProperty("iregionfilter1"), prop.getProperty("iregionfilter2"));
		Invoice.ClickApply();
		//Invoice.MultiRegionFilterValidation();
	}
	
	@Test(priority=13)
	public void TC14() throws InterruptedException {
		Invoice.Regionfiltercloseoption();
	}
	
	@Test(priority=14)
	public void TC15() throws InterruptedException {
		Invoice.SearchOptioninRegionFilter();
	}
	
	@Test(priority=15)
	public void TC18() throws InterruptedException {
		Invoice.PartnerOrgfiltercloseoption();
	}
	
	@Test(priority=16)
	public void TC19() throws InterruptedException {
		Invoice.SearchOptioninPatnerOrgFilter();
	}
	
	@Test(priority=17)
	public void TC22() throws InterruptedException {
		Invoice.Partnerfiltercloseoption();
	}
	
	@Test(priority=18)
	public void TC23() throws InterruptedException {
		Invoice.SearchOptioninPatnerFilter();
	}
	
	@Test(priority=19)
	public void TC24() throws InterruptedException {
		Invoice.SelectFilter(prop.getProperty("iselectfilter"));
		Invoice.ReceiverFilter(prop.getProperty("irecieverfilter"));
		Invoice.ClickApply();
		
	}
	
	@Test(priority=20)
	public void TC25() throws InterruptedException {
		Invoice.SelectFilter(prop.getProperty("iselectfilter"));
		
		Invoice.ResetBtnValidation();
		
	}
	
	@Test(priority=21)
	public void TC26And27() throws InterruptedException {
		Invoice.SelectFromDate(prop.getProperty("ifromyear"), prop.getProperty("ifrommonth"));
		Invoice.SelectToDate(prop.getProperty("itoyear"), prop.getProperty("itomonth"));
		Invoice.ClickApply();
		Thread.sleep(2000);
		Invoice.GenerateInvoiceReport();
		
	}
	
	@Test(priority=22)
	public void TC36() throws InterruptedException {
		
		Invoice.ShowEntries(prop.getProperty("iNumberofEnteries"));
	}
	
	@Test(priority=23)
	public void TC39() throws InterruptedException {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		
		Invoice.Pagination();
		Thread.sleep(1000);
		Invoice.FirstPage();
		Thread.sleep(1000);
		Invoice.Nextpage();
		Thread.sleep(1000);
		Invoice.PriviousPage();
		Thread.sleep(1000);
		Invoice.LastPage();
	}
	
	@Test(priority=24)
	public void TC40() throws InterruptedException {
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		Invoice.VerifyTotalInvoice();
		
	}
	
	
	
	@Test(priority=25)
	public void TC42() throws InterruptedException {
		
		Invoice.ArrowBtn();
		
	}
	
	@Test(priority=26)
	public void TC44() throws InterruptedException {
		
		Invoice.ArrowBtn();
		Invoice.VerifyingPoDetails();
		
	}
	
	@Test(priority=27)
	public void TC46() throws InterruptedException {
		
		Invoice.ArrowBtn();
		Invoice.VerifyingASNDetailes();
		
	}
	
	@Test(priority=28)
	public void TC47() throws InterruptedException {
		
		Invoice.ArrowBtn();
		Invoice.ViewAllowence();
		
	}
	
	@Test(priority=29)
	public void TC49() throws InterruptedException {
		
	    Invoice.ArrowBtn();
	    Thread.sleep(1000);
	    Invoice.downloadInvoice();
	    Thread.sleep(3000);
		
	}
	
	@Test(priority=30)
	public void TC53() throws InterruptedException {
		
		Invoice.ArrowBtn();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		Invoice.TopArrow();
		
		
	}
	
	
	
	
	
	
	
	
	
	
	@AfterMethod
	public void close() {
	 driver.quit();
	}


}
