package gateway.testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import gateway.base.TestBase;
import gateway.pages.HomePage;
import gateway.pages.LoginPage;
import gateway.pages.PurchaseOrderListPage;

public class PurchaseOrderListTest extends TestBase {

	LoginPage Login;
	HomePage Home;
	PurchaseOrderListPage Order;

	public PurchaseOrderListTest() throws IOException {
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

	public void TC1() throws IOException, InterruptedException {

		Order.VerifyPurchaseOrderPage();
	}

	@Test(priority = 2)

	public void TC2() throws IOException, InterruptedException {
		Order.VerifyPurchaseOrderPage();
		Order.VerifyTotalPos();

	}

	@Test(priority = 3)

	public void TC3() throws IOException, InterruptedException {

		Order.SelectFromDate(prop.getProperty("fromyear"), prop.getProperty("frommonth"));
		Order.SelectToDate(prop.getProperty("toyear"), prop.getProperty("tomonth"), prop.getProperty("todate"));
		Order.ClickApply();
		Thread.sleep(4000);
		Order.ValidationDate();

	}

	@Test(priority = 4)

	public void TC4() throws IOException, InterruptedException {

		Order.SelectFilter(prop.getProperty("selectfilter1"));
		Order.ClickApply();
		Thread.sleep(5000);
		Order.SelectFilterValidations();
	}
	
	@Test(priority = 5)

	public void TC4a() throws IOException, InterruptedException {

		Order.MultiSelectStatusFilter(prop.getProperty("selectfilter1"), prop.getProperty("selectfilter2"));
		Order.ClickApply();
		Thread.sleep(5000);
		Order.MultiSelectFilterValidations();

	}

	@Test(priority = 6)

	public void TC5() throws IOException, InterruptedException {

		Order.ReceiverFilter(prop.getProperty("recieverfilter"));

		Order.ClickApply();
		Thread.sleep(3000);
		Order.ReceieverFilterValidation();
	}
	
	@Test(priority = 7)

	public void TC5a() throws IOException, InterruptedException {

		Order.MultiReceiverFilter(prop.getProperty("recieverfilter1"), prop.getProperty("recieverfilter2"));
		Order.ClickApply();
		Thread.sleep(3000);
		Order.MultiReceieverFilterValidation();

	}

	@Test(priority = 8)

	public void TC6() throws IOException, InterruptedException {

		Order.RegionFilter(prop.getProperty("regionfilter"));
		Order.ClickApply();
		Order.VerifyTotalPos();
	}

	@Test(priority = 9)
	public void TC7() throws IOException, InterruptedException {

		Order.PatnerOrgdFilter(prop.getProperty("patnerorgfilter"));
		Order.ClickApply();
		Order.VerifyTotalPos();
	}

	@Test(priority = 10)

	public void TC8() throws IOException, InterruptedException {

		Order.Patnerfilter(prop.getProperty("patnerfilter"));
		Order.ClickApply();
		Order.VerifyTotalPos();
	}

	@Test(priority = 11)

	public void TC9() throws IOException, InterruptedException {

		Order.SearchPO(prop.getProperty("srchponumber"));
	}

	@Test(priority = 12)

	public void TC10() throws IOException, InterruptedException {

		Order.SelectFromDate(prop.getProperty("fromyear"), prop.getProperty("frommonth"));

		Order.SelectToDate(prop.getProperty("toyear"), prop.getProperty("tomonth"), prop.getProperty("todate"));

		Order.SelectFilter(prop.getProperty("selectfilter"));
		Order.ReceiverFilter(prop.getProperty("recieverfilter"));
		// Order.RegionFilter(prop.getProperty("regionfilter"));
		Order.Patnerfilter(prop.getProperty("patnerorgfilter"));

		Order.ResetBtn();

	}

	@Test(priority = 13)

	public void TC12() throws IOException, InterruptedException {

		Order.AlreadyAcceptedPo(prop.getProperty("Porownumber"));

	}

	@Test(priority = 14)

	public void TC13() throws IOException, InterruptedException {

		Order.DownloadCSV(prop.getProperty("CSVFile"));

	}

	@Test(priority = 15)

	public void TC14() throws IOException, InterruptedException {

		Order.Downloadpdf(prop.getProperty("pdffile"), prop.getProperty("name"));

	}

	@Test(priority = 16)

	public void TC16() throws IOException, InterruptedException {

		Order.SelectFilter(prop.getProperty("selectfilter"));
		Order.ClickApply();
		Order.VerifyTotalPos();
	}

	@Test(priority = 17)
	public void TC17() throws IOException, InterruptedException {
		Order.Pagination();
		Order.FirstPage();
		Order.Nextpage();
		Order.PriviousPage();
		Order.LastPage();

	}

	@Test(priority = 18)

	public void TC18() throws IOException, InterruptedException {

		Order.ShowEntries(prop.getProperty("NumberofEnteries"));
	}

	@Test(priority = 19)

	public void TC20() throws IOException, InterruptedException {

		Order.SearchOptioninStatusFilter();
		Order.SearchOptioninRecieverFilter();
	}

	@Test(priority = 20)

	public void TC21() throws IOException, InterruptedException {

		Order.SelectFilter(prop.getProperty("selectfilter"));

		Order.ReceiverFilter(prop.getProperty("recieverfilter"));

		Order.PatnerOrgdFilter(prop.getProperty("patnerorgfilter"));

		Order.Patnerfilter(prop.getProperty("patnerfilter"));

	}

	@Test(priority = 21)

	public void TC23() throws IOException, InterruptedException {

		Order.NavigatingPoDetailes();

	}

	@Test(priority = 22)

	public void TC25() throws IOException, InterruptedException {

		Order.NavigatingPoDetailes();
		Order.DownloadPDFPODeatilsPage();
	}

	@Test(priority = 23)

	public void TC26() throws IOException, InterruptedException {

		Order.NavigatingPoDetailes();
		Order.PrintPDFPODeatilsPage();
	}

	@Test(priority = 24)

	public void TC27() throws IOException, InterruptedException {

		Order.NavigatingPoDetailes();
		Order.HamburgerButton();
	}

	@Test(priority = 25)

	public void TC28() throws IOException, InterruptedException {

		Order.NavigatingPoDetailes();
		Order.PlusButton();
	}

	@Test(priority = 26)

	public void TC30() throws IOException, InterruptedException {

		Order.SearchPO(prop.getProperty("srchponumber"));
		Order.NavigatingPoDetailes();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);

		Order.PoDtailesPagination();
		System.out.println("For First page");
		Order.PoDetailesFirstPage();
		System.out.println("For Last page");
		Order.PoDetailesLastPage();
		System.out.println("For Privious page");
		Order.PoDetailsPriviousPage();
		System.out.println("For Next page");
		Order.PoDetailsNextpage();

	}

	@Test(priority = 27)

	public void TC31() throws IOException, InterruptedException {

		Order.NavigatingPoDetailes();
		Order.POAckStatus();
	}

	@Test(priority = 28)

	public void TC33() throws IOException, InterruptedException {

		Order.NavigatingPoDetailes();
		Order.PlusButton();
		Order.Allowence();
	}

	@Test(priority = 29)

	public void TC35() throws IOException, InterruptedException {

		Order.SelectMultiplePo();
	}

	@Test(priority = 30)

	public void TC36() throws IOException, InterruptedException {

		Order.NavigatingPoDetailes();
		Order.SearchOptionPODetailes();
	}

	@Test(priority = 31)

	public void TC38() throws IOException, InterruptedException {

		Order.MultiSelectStatusFilter(prop.getProperty("selectfilter1"), prop.getProperty("selectfilter2"));
		Order.MultiReceiverFilter(prop.getProperty("recieverfilter1"), prop.getProperty("recieverfilter2"));
		// Order.MultipleSelectionOfPartnerOrgFilter();
		// Order.MultipleSelectionOfPartnerFilter();
		Order.ClickApply();
		Order.VerifyTotalPos();

	}

	@Test(priority = 32)

	public void TC42() throws IOException, InterruptedException {

		Order.SelectArrowMark();
		Order.NavigatingPoDetailes();
		Order.InvoiceStatus();
		Order.ClickOnInvoiceno();

	}

	@Test(priority = 33)

	public void TC43() throws IOException, InterruptedException {

		Order.SelectArrowMark();
		Order.NavigatingPoDetailes();
		Order.ShipmentStatus();
		Order.ClickOnASN();

	}

	

	@AfterMethod
	public void close() {
		driver.quit();
	}

}
