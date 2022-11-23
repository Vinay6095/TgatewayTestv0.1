package gateway.pages;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import gateway.base.TestBase;

public class InvoiceListPage extends TestBase {

	public InvoiceListPage() throws IOException {
		PageFactory.initElements(driver, this);

	}

	public void VerifyingInvoicepage() {

		String PageName = driver.findElement(By.xpath("//app-invoice-list/div[1]/h1")).getText();
		System.out.println(PageName);
		Assert.assertEquals(PageName, "Invoice List");

	}

	public void ResetBtn() throws InterruptedException {

		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();
		Thread.sleep(1000);
	}
	
	public void SelectFromDate(String fromyear, String frommonth) throws InterruptedException {
		

		driver.findElement(By.xpath("//input[@placeholder='From date']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'2022')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/bs-datepicker-container[1]/div[1]/div[1]/div[1]/div[1]/bs-years-calendar-view[1]/bs-calendar-layout[1]/div[2]/table[1]/tbody[1]/tr/td/span[contains(text(),'"
						+ fromyear + "')]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/bs-datepicker-container[1]/div[1]/div[1]/div[1]/div[1]/bs-month-calendar-view[1]/bs-calendar-layout[1]/div[2]/table[1]/tbody[1]/tr/td/span[contains(text(),'"
						+ frommonth + "')]"))
				.click();
		Thread.sleep(1000);

		int Fromdate = Integer.valueOf(prop.getProperty("fromdate"));

		if (Fromdate <= 24) {
			OUTER: for (int i = 1; i <= 6; i++) {
				for (int j = 1; j <= 7; j++) {
					String date = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]/span[1]")).getText();
					// System.out.println(date);

					if (date.equals(prop.getProperty("ifromdate"))) {

						driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]/span[1]")).click();
						break OUTER;
						// Thread.sleep(1000);
					}

				}

			}
		}
		if (Fromdate > 24) {
			OUTER: for (int i = 6; i >= 1; i--) {
				for (int j = 7; j >= 1; j--) {
					String date = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]/span[1]")).getText();
					// System.out.println(date);

					if (date.equals(prop.getProperty("fromdate"))) {

						driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]/span[1]")).click();

						break OUTER;
					}

				}

			}

		}

	}

	public void SelectToDate(String toyear, String tomonth) throws InterruptedException {

		driver.findElement(By.xpath(
				"//body/app[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-invoice-list[1]/section[1]/div[1]/div[1]/div[1]/div[1]/app-list-filter[1]/div[1]/div[2]/input[1]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(text(),'2022')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/bs-datepicker-container[1]/div[1]/div[1]/div[1]/div[1]/bs-years-calendar-view[1]/bs-calendar-layout[1]/div[2]/table[1]/tbody[1]/tr/td/span[contains(text(),'"
						+ toyear + "')]"))
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html[1]/body[1]/bs-datepicker-container[1]/div[1]/div[1]/div[1]/div[1]/bs-month-calendar-view[1]/bs-calendar-layout[1]/div[2]/table[1]/tbody[1]/tr/td/span[contains(text(),'"
						+ tomonth + "')]"))
				.click();
		Thread.sleep(1000);

		int Todate = Integer.valueOf(prop.getProperty("todate"));
		if (Todate <= 24) {

			OUTER: for (int i = 1; i <= 6; i++) {
				for (int j = 1; j <= 7; j++) {

					String date = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]/span[1]")).getText();
					// System.out.println(date);

					if (date.equals(prop.getProperty("todate"))) {

						driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]/span[1]")).click();
						break OUTER;
						// Thread.sleep(1000);
					}

				}

			}
		}
		if (Todate > 24) {
			OUTER: for (int i = 6; i >= 1; i--) {
				for (int j = 7; j >= 1; j--) {

					String date = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]/span[1]")).getText();
					// System.out.println(date);

					if (date.equals(prop.getProperty("todate"))) {

						driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[" + j + "]/span[1]")).click();
						break OUTER;

					}

				}

			}

		}
	}
	
	public void ClickApply() throws InterruptedException {

		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		Thread.sleep(1000);
		System.out.println("Clicked on Apply Button");

	}
	
	public void SelectFilter(String status) throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Status Filter')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + status + "')]")).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//body/app[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-order[1]/section[1]/div[1]/div[1]/div[1]/div[1]/app-list-filter[1]/div[1]/div[3]/ngx-select-dropdown[1]/div[1]/button[1]/span[2]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//app-list-filter[1]/div[1]/div[3]/ngx-select-dropdown[1]/div[1]/button[1]/span[2]")).click();
		Thread.sleep(1000);
		String selectedfilter = driver
				.findElement(By.xpath("//app-list-filter/div[1]/div[3]/ngx-select-dropdown/div[1]/button/span[1]"))
				.getText();

		System.out.println("selected Status Filter  " + selectedfilter);
		Thread.sleep(1000);

	}
	
	public void SelectFilterValidations() throws InterruptedException {
		SoftAssert Assertsoft = new SoftAssert();
		
		String nodata=driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println(nodata);
		if (nodata.equals("No data!")) {
			
			fail("No data Found on This Filter");
		}
		
		
		driver.findElement(By.xpath("//a[@id='DataTables_Table_0_last']")).click();
		Thread.sleep(2000);
		String Lastpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("Total number of pages: " + Lastpage);

		int Totalpages = Integer.valueOf(Lastpage);

		int totalrows = 0;
		for (int i = 1; i <= Totalpages; i++) {

			driver.findElement(By.xpath("//a[contains(text(),'" + i + "')]")).click();
			Thread.sleep(2000);
			String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
			System.out.println("Current Page is: " + currentpage);
			Thread.sleep(1000);
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[5]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;

			for (int j = 1; j <= matchingelement; j++) {

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();

				if (Status.equals(prop.getProperty("iselectfilter"))) {

					String inno = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + inno + " invoice number is in " + Status + " State");

				} else {
					String inno = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + inno + " invoice number is in " + Status + " State");
					Assertsoft.assertEquals(Status, prop.getProperty("iselectfilter"),
							"Failed at page " + i + " at row number " + j);

				}
				// Assertsoft.assertEquals(Status, prop.getProperty("selectfilter1"));

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

	}
	
	public void MultiSelectStatusFilter(String filter1, String filter2) throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Status Filter')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + filter1 + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + filter2 + "')]")).click();
	}
	
	public void MultiSelectFilterValidations() throws InterruptedException {
		SoftAssert Assertsoft = new SoftAssert();
		String nodata=driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println(nodata);
		if (nodata.equals("No data!")) {
			
			fail("No data Found on This Filter");
		}

		driver.findElement(By.xpath("//a[@id='DataTables_Table_0_last']")).click();
		Thread.sleep(2000);
		String Lastpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("Total number of pages: " + Lastpage);

		int Totalpages = Integer.valueOf(Lastpage);

		int totalrows = 0;
		for (int i = 1; i <= Totalpages; i++) {

			driver.findElement(By.xpath("//a[contains(text(),'" + i + "')]")).click();
			Thread.sleep(2000);
			String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
			System.out.println("Current Page is: " + currentpage);
			Thread.sleep(1000);
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[5]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;

			for (int j = 1; j <= matchingelement; j++) {

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();

				if (Status.equals(prop.getProperty("iselectfilter1"))
						|| Status.equals(prop.getProperty("iselectfilter2"))) {

					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + PoNo + " PO number is in " + Status + " State");

				} else {
					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + PoNo + " PO number is in " + Status + " State");

					Assertsoft.assertEquals(j, matchingelement + 1, "Failed at page " + i + " at row number " + j);

				}

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

	}
	
	
	public void StatusFilterCloseOptin() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[contains(text(),'Status Filter')]")).click();
		Thread.sleep(1000);
		int NoOfOptions=driver.findElements(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[2]/li")).size();
		
		
		System.out.println(NoOfOptions);
		for (int i = 1; i <=NoOfOptions; i++) {
			driver.findElement(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[2]/li[1]")).click();
			Thread.sleep(1000);
		}
		int NoOfselectedOptions=driver.findElements(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[1]/li")).size();
		System.out.println(NoOfselectedOptions);
		for (int j = 1; j <=NoOfselectedOptions; j++) {
			
			driver.findElement(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[1]/li/span[1]")).click();
			Thread.sleep(1000);
		}
		Assert.assertEquals(NoOfOptions, NoOfselectedOptions);
		
	}
	
	public void SearchOptioninStatusFilter() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Status Filter')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//ngx-select-dropdown/div[1]/div[1]/div[1]/input"))
				.sendKeys("Invoice Acknowledged");

		Thread.sleep(1000);

	}
	
	public void ReceiverFilter(String receiver) throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Receiver Filter')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + receiver + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//app-list-filter[1]/div[1]/div[4]/ngx-select-dropdown[1]/div[1]/button[1]/span[2]")).click();
		Thread.sleep(1000);
		String Rcvfilter = driver
				.findElement(By.xpath("//app-list-filter/div[1]/div[4]/ngx-select-dropdown/div[1]/button/span[1]"))
				.getText();
		System.out.println("Selected Reciever filter  " + Rcvfilter);
		Thread.sleep(1000);
	}
	
	public void ReceieverFilterValidation() throws InterruptedException {
		SoftAssert Assertsoft = new SoftAssert();
		String nodata=driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println(nodata);
		if (nodata.equals("No data!")) {
			
			fail("No data Found on This Filter");
		}
		
		driver.findElement(By.xpath("//a[@id='DataTables_Table_0_last']")).click();
		Thread.sleep(2000);
		String Lastpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("Total number of pages: " + Lastpage);

		int Totalpages = Integer.valueOf(Lastpage);

		int totalrows = 0;
		for (int i = 1; i <= Totalpages; i++) {

			driver.findElement(By.xpath("//a[contains(text(),'" + i + "')]")).click();
			Thread.sleep(2000);
			String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
			System.out.println("Current Page is: " + currentpage);
			Thread.sleep(1000);
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[5]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;

			for (int j = 1; j <= matchingelement; j++) {

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[1]")).getText();

				if (Status.equals(prop.getProperty("irecieverfilter"))) {

					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + PoNo + " Invoice number is under " + Status + " receiver");

				} else {
					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + PoNo + " Invoice number is under " + Status + " receiver");
					Assertsoft.assertEquals(Status, prop.getProperty("irecieverfilter"),
							"Failed at page " + i + " at row number " + j);

				}

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

	}
	
	
	public void MultiReceiverFilter(String filter1, String filter2) throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Receiver Filter')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + filter1 + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + filter2 + "')]")).click();
	}
	
	
	public void MultiReceieverFilterValidation() throws InterruptedException {
		SoftAssert Assertsoft = new SoftAssert();
		String nodata=driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println(nodata);
		if (nodata.equals("No data!")) {
			
			fail("No data Found on This Filter");
		}
		
		driver.findElement(By.xpath("//a[@id='DataTables_Table_0_last']")).click();
		Thread.sleep(2000);
		String Lastpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("Total number of pages: " + Lastpage);

		int Totalpages = Integer.valueOf(Lastpage);

		int totalrows = 0;
		for (int i = 1; i <= Totalpages; i++) {

			driver.findElement(By.xpath("//a[contains(text(),'" + i + "')]")).click();
			Thread.sleep(2000);
			String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
			System.out.println("Current Page is: " + currentpage);
			Thread.sleep(1000);
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[5]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;

			for (int j = 1; j <= matchingelement; j++) {

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[1]")).getText();

				if (Status.equals(prop.getProperty("irecieverfilter1"))
						|| Status.equals(prop.getProperty("irecieverfilter2"))) {

					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + PoNo + "PO number is under " + Status + " receiver");

				} else {
					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + PoNo + "PO number is under " + Status + " receiver");
					Assertsoft.assertEquals(j, matchingelement + 1, "Failed at page " + i + " at row number " + j);

				}

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

	}
	
	
	public void Receiverfiltercloseoption() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[contains(text(),'Receiver Filter')]")).click();
		Thread.sleep(1000);
		int NoOfOptions=driver.findElements(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[2]/li")).size();
		
		
		System.out.println(NoOfOptions);
		for (int i = 1; i <=NoOfOptions; i++) {
			driver.findElement(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[2]/li[1]")).click();
			Thread.sleep(1000);
		}
		int NoOfselectedOptions=driver.findElements(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[1]/li")).size();
		System.out.println(NoOfselectedOptions);
		for (int j = 1; j <=NoOfselectedOptions; j++) {
			
			driver.findElement(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[1]/li/span[1]")).click();
			Thread.sleep(1000);
		}
		Assert.assertEquals(NoOfOptions, NoOfselectedOptions);
		
	}
	
	public void SearchOptioninReceiverFilter() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Receiver Filter')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//ngx-select-dropdown/div[1]/div[1]/div[1]/input"))
				.sendKeys("8717045000002");

		Thread.sleep(1000);

	}
	
	public void RegionFilter(String region) throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Region Filter')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + region + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//app-list-filter[1]/div[1]/div[5]/ngx-select-dropdown[1]/div[1]/button[1]/span[2]")).click();
		Thread.sleep(1000);
		String regionfilter = driver.findElement(By.xpath("//span[contains(text(),'" + region + "')]")).getText();
		System.out.println("Selected Region Filter " + regionfilter);
		Thread.sleep(1000);

	}
	
	public void RegionFilterValidation() throws InterruptedException {
		SoftAssert Assertsoft = new SoftAssert();
		String nodata=driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println(nodata);
		if (nodata.equals("No data!")) {
			
			fail("No data Found on Filter");
		}
		
		driver.findElement(By.xpath("//a[@id='DataTables_Table_0_last']")).click();
		Thread.sleep(2000);
		String Lastpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("Total number of pages: " + Lastpage);

		int Totalpages = Integer.valueOf(Lastpage);

		int totalrows = 0;
		for (int i = 1; i <= Totalpages; i++) {

			driver.findElement(By.xpath("//a[contains(text(),'" + i + "')]")).click();
			Thread.sleep(2000);
			String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
			System.out.println("Current Page is: " + currentpage);
			Thread.sleep(1000);
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[5]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;

			for (int j = 1; j <= matchingelement; j++) {

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[2]")).getText();

				if (Status.equals(prop.getProperty("iregionfilter"))) {

					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + PoNo + " Invoice number is under " + Status + " receiver");

				} else {
					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + PoNo + " Invoice number is under " + Status + " receiver");
					Assertsoft.assertEquals(Status, prop.getProperty("iregionfilter"),
							"Failed at page " + i + " at row number " + j);

				}

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

	}
	
	public void MultiRegionFilter(String filter1, String filter2) throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Region Filter')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + filter1 + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + filter2 + "')]")).click();
	}
	
	
	public void MultiRegionFilterValidation() throws InterruptedException {
		SoftAssert Assertsoft = new SoftAssert();
		String nodata=driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println(nodata);
		if (nodata.equals("No data!")) {
			
			fail("No data Found on Filter");
		}
		
		driver.findElement(By.xpath("//a[@id='DataTables_Table_0_last']")).click();
		Thread.sleep(2000);
		String Lastpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("Total number of pages: " + Lastpage);

		int Totalpages = Integer.valueOf(Lastpage);

		int totalrows = 0;
		for (int i = 1; i <= Totalpages; i++) {

			driver.findElement(By.xpath("//a[contains(text(),'" + i + "')]")).click();
			Thread.sleep(2000);
			String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
			System.out.println("Current Page is: " + currentpage);
			Thread.sleep(1000);
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[5]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;

			for (int j = 1; j <= matchingelement; j++) {

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[2]")).getText();

				if (Status.equals(prop.getProperty("iregionfilter1")) || Status.equals(prop.get("iregionfilter2"))) {

					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + PoNo + " Invoice number is under " + Status + " receiver");

				} else {
					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + PoNo + " Invoice number is under " + Status + " receiver");
					Assertsoft.assertEquals(j, matchingelement + 1,
							"Failed at page " + i + " at row number " + j);

				}

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

	}
	
	
    public void Regionfiltercloseoption() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[contains(text(),'Region Filter')]")).click();
		Thread.sleep(1000);
		int NoOfOptions=driver.findElements(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[2]/li")).size();
		
		
		System.out.println(NoOfOptions);
		for (int i = 1; i <=NoOfOptions; i++) {
			driver.findElement(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[2]/li[1]")).click();
			Thread.sleep(1000);
		}
		int NoOfselectedOptions=driver.findElements(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[1]/li")).size();
		System.out.println(NoOfselectedOptions);
		for (int j = 1; j <=NoOfselectedOptions; j++) {
			
			driver.findElement(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[1]/li/span[1]")).click();
			Thread.sleep(1000);
		}
		Assert.assertEquals(NoOfOptions, NoOfselectedOptions);
		
	}
    
    public void SearchOptioninRegionFilter() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Region Filter')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//ngx-select-dropdown/div[1]/div[1]/div[1]/input"))
				.sendKeys("EUROPE");

		Thread.sleep(1000);

	}
    
public void PartnerOrgfiltercloseoption() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[contains(text(),'Partner Org Filter')]")).click();
		Thread.sleep(1000);
		int NoOfOptions=driver.findElements(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[2]/li")).size();
		
		
		System.out.println(NoOfOptions);
		for (int i = 1; i <=NoOfOptions; i++) {
			driver.findElement(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[2]/li[1]")).click();
			Thread.sleep(1000);
		}
		int NoOfselectedOptions=driver.findElements(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[1]/li")).size();
		System.out.println(NoOfselectedOptions);
		for (int j = 1; j <=NoOfselectedOptions; j++) {
			
			driver.findElement(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[1]/li/span[1]")).click();
			Thread.sleep(1000);
		}
		Assert.assertEquals(NoOfOptions, NoOfselectedOptions);
		
	}
    
    public void SearchOptioninPatnerOrgFilter() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Partner Org Filter')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//ngx-select-dropdown/div[1]/div[1]/div[1]/input"))
				.sendKeys("AIRGASNATIONAL");

		Thread.sleep(1000);

	}
    
    
    public void Partnerfiltercloseoption() throws InterruptedException {
		
		driver.findElement(By.xpath("//span[contains(text(),'Partner Filter')]")).click();
		Thread.sleep(1000);
		int NoOfOptions=driver.findElements(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[2]/li")).size();
		
		
		System.out.println(NoOfOptions);
		for (int i = 1; i <=NoOfOptions; i++) {
			driver.findElement(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[2]/li[1]")).click();
			Thread.sleep(1000);
		}
		int NoOfselectedOptions=driver.findElements(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[1]/li")).size();
		System.out.println(NoOfselectedOptions);
		for (int j = 1; j <=NoOfselectedOptions; j++) {
			
			driver.findElement(By.xpath("//ngx-select-dropdown/div[1]/div[1]/ul[1]/li/span[1]")).click();
			Thread.sleep(1000);
		}
		Assert.assertEquals(NoOfOptions, NoOfselectedOptions);
		
	}
    
    
    public void SearchOptioninPatnerFilter() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Partner Filter')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//ngx-select-dropdown/div[1]/div[1]/div[1]/input"))
				.sendKeys("Continental Czech Republic : Brandys");

		Thread.sleep(1000);

	}
    
    public void ResetBtnValidation() throws InterruptedException {

		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();

		Thread.sleep(2000);
		System.out.println("Clicked on Reset Button");
		String reset = driver.findElement(By.xpath("//span[contains(text(),'Status Filter')]")).getText();

		Assert.assertEquals(reset, "Status Filter");
		System.out.println("Text Cleared from the fields  " + reset);
	}
    
    public void ShowEntries(String entries) throws InterruptedException {

		Select sel = new Select(driver.findElement(By.xpath(
				"//section/div[2]/div[1]/div[1]/div[2]/div[1]/label[1]/select")));

		sel.selectByValue(entries);
		Thread.sleep(2000);
		int matchingelement = driver.findElements(By.xpath("//tbody/tr/td[5]")).size();
		String Actualmaching=String.valueOf(matchingelement);
		Assert.assertEquals(Actualmaching, prop.get("iNumberofEnteries"));

		System.out.println("Number of enteries showing :" + matchingelement);
	}
    
    
    public void Pagination() throws InterruptedException {
    	

		String text = driver.findElement(By.xpath("//section[1]/div[2]/div[1]/div[1]/div[4]")).getText();

		System.out.println(text);

		String str = "";
		int res = 0;
		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) == 'f' && text.charAt(i + 1) == ' ') {

				str += text.charAt(i + 2);

				// System.out.println(str);

				for (int j = i + 3; j < text.length(); j++) {

					if (Character.isDigit(text.charAt(j))) {

						str += text.charAt(j);

					} else {
						break;
					}

				}
				break;

			}

		}

		res = Integer.parseInt(str);
		System.out.println("Total Number Of Invoice  " + res);

		String Lastpage = driver.findElement(By.xpath("//section[1]/div[2]/div[1]/div[1]/div[5]/span[1]/a[6]"))
				.getText();
		// System.out.println("Total number of pages: "+Lastpage);

		int Totalpages = Integer.valueOf(Lastpage);
		System.out.println("Total number of pages: " + Totalpages);

		int totalrows = 0;

		for (int p = 1; p <= Totalpages; p++) {

			WebElement Currentpage = driver.findElement(By.xpath("//a[contains(text(),'" + p + "')]"));
			System.out.println("Current page no: " + Currentpage.getText());
			Currentpage.click();
			Thread.sleep(1000);
			int matchingelement = driver.findElements(By.xpath("//tbody/tr/td[5]")).size();
			System.out.println("Number of rows preset: " + matchingelement);

			totalrows = totalrows + matchingelement;

		}

		System.out.println("Total number of rows: " + totalrows);

		Assert.assertEquals(totalrows, res);

	}

	public void PriviousPage() throws InterruptedException {

		//driver.findElement(By.xpath("//a[contains(text(),'3')]")).click();
		//Thread.sleep(1000);

		String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		Thread.sleep(1000);
		System.out.println("Current page: " + currentpage);
		driver.findElement(By.xpath("//a[@id='DataTables_Table_0_previous']")).click();
		Thread.sleep(2000);
		String previouspage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		Thread.sleep(1000);
		System.out.println("After clicked on previous page: " + previouspage);
		Assert.assertNotEquals(currentpage, previouspage);
		Thread.sleep(2000);

	}

	public void Nextpage() throws InterruptedException {

		String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("Current page:" + currentpage);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='DataTables_Table_0_next']")).click();
		Thread.sleep(2000);
		String nextpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();

		System.out.println("After clicked on Next page: " + nextpage);

		Assert.assertNotEquals(currentpage, nextpage);

	}

	public void FirstPage() throws InterruptedException {
		
       // driver.findElement(By.xpath("//a[contains(text(),'1')]")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'4')]")).click();
		//Thread.sleep(2000);
		String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		Thread.sleep(1000);
		System.out.println("Current page: " + currentpage);
		driver.findElement(By.xpath("//a[@class='paginate_button first']")).click();
		Thread.sleep(1000);
		String firstpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("After clicked on first page: " + firstpage);

		Assert.assertNotEquals(currentpage, firstpage);
	}

	public void LastPage() throws InterruptedException {

		String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("Current page: " + currentpage);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='paginate_button last']")).click();
		Thread.sleep(2000);
		String Lastpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("After clicked on last page: " + Lastpage);

		Assert.assertNotEquals(currentpage, Lastpage);

	}
	
	public void ArrowBtn() throws InterruptedException {
		driver.findElement(By.xpath("//tbody/tr[1]/td[10]/a[1]/span[1]")).click();
		Thread.sleep(2000);
		String text=driver.findElement(By.xpath("//app-invoice[1]/div[1]/h1[1]")).getText();
		Thread.sleep(2000);
		
		Assert.assertEquals(text, "Invoice-Details");
		
	}
	
	public void getponumber() throws InterruptedException {
		String text1=driver.findElement(By.xpath("//section/div[1]/div[1]/div[1]/div[1]/a[1]")).getText();
		System.out.println(text1);
		
		
		String Pono="";
		int count=0;
		for (int k =0; k<text1.length(); k++) {
			
			if (text1.charAt(k)==' ') {
				count++;
				
				
			}else {
				if (count==3) {
					
					Pono += text1.charAt(k);
				}
			}
				
				
		}
		System.out.println(Pono);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//section/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
		Thread.sleep(3000);
		// get the targeted element
		WebElement element = driver.findElement(By.cssSelector("//Podetsils/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1][@class='podetails']/strongspan[contains(text(),'PO Number # ')]/following::text()"));
		
		String Podetsils=element.getText();
		System.out.println(Podetsils);
 
		
	}
	
	public void VerifyingPoDetails() throws InterruptedException {
		
		driver.findElement(By.xpath("//section/div[1]/div[1]/div[1]/div[1]/a[1]")).click();
		Thread.sleep(2000);
		String PODetailesPage=driver.findElement(By.xpath("//app-po-details/div[1]/h1[1]")).getText();
		System.out.println(PODetailesPage);
		Assert.assertEquals(PODetailesPage, "Purchase Order-Details");

		
		
	}
	
	public void VerifyingASNDetailes() throws InterruptedException {
		
		driver.findElement(By.xpath("//section/div[1]/div[1]/div[1]/div[1]/a[2]")).click();
		Thread.sleep(2000);
		String ASNPage=driver.findElement(By.xpath("//app-asn-details/div[1]/h1[1]")).getText();
		Assert.assertEquals(ASNPage, "Shipment-Details");
	}
	
	public void ViewAllowence() throws InterruptedException {
		driver.findElement(By.xpath("//section/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/button[1]/i[1]")).click();
		Thread.sleep(2000);
		String popup=driver.findElement(By.xpath("//modal-container/div[1]/div[1]/div[1]/span[1]")).getText();
		Assert.assertEquals(popup, "Allowances:");
		
	}
	
	public void TopArrow() throws InterruptedException {
		driver.findElement(By.xpath("//a[@id='back2Top']")).click();
		Thread.sleep(2000);
		String text=driver.findElement(By.xpath("//app-invoice/div[1]/h1[1]")).getText();
		Thread.sleep(1000);
		
		Assert.assertEquals(text, "Invoice-Details");
		
		
	}
	
	public void GenerateInvoiceReport() throws InterruptedException {
		 
		driver.findElement(By.xpath("//tbody/tr/td[5]")).click();
		driver.findElement(By.xpath("//section[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Generate Invoice Report')]")).click();
		Thread.sleep(2000);
		
		
	}
	
	public void VerifyTotalInvoice() throws InterruptedException {

		String text = driver.findElement(By.xpath("//div[@id='DataTables_Table_0_info']")).getText();

		System.out.println(text);

		String str = "";
		int res = 0;
		for (int i = 0; i < text.length(); i++) {

			if (text.charAt(i) == 'f' && text.charAt(i + 1) == ' ') {

				str += text.charAt(i + 2);

				// System.out.println(str);

				for (int j = i + 3; j < text.length(); j++) {

					if (Character.isDigit(text.charAt(j))) {

						str += text.charAt(j);

					} else {
						break;
					}

				}
				break;

			}

		}

		res = Integer.parseInt(str);
		System.out.println("Total Number Of PO's  " + res);
		
		String Lastpage = driver.findElement(By.xpath("//section[1]/div[2]/div[1]/div[1]/div[5]/span[1]/a[6]"))
				.getText();
		// System.out.println("Total number of pages: "+Lastpage);

		int Totalpages = Integer.valueOf(Lastpage);
		System.out.println("Total number of pages: " + Totalpages);

		int totalrows = 0;

		for (int p = 1; p <= Totalpages; p++) {

			WebElement Currentpage = driver.findElement(By.xpath("//a[contains(text(),'" + p + "')]"));
			System.out.println("Current page no: " + Currentpage.getText());
			Currentpage.click();
			Thread.sleep(1000);
			int matchingelement = driver.findElements(By.xpath("//tbody/tr/td[5]")).size();
			System.out.println("Number of rows preset: " + matchingelement);

			totalrows = totalrows + matchingelement;

		}

		System.out.println("Total number of rows: " + totalrows);

		Assert.assertEquals(totalrows, res);

	}
	
	public void downloadInvoice() throws InterruptedException {
		
		driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Download Invoice')]")).click();
		Thread.sleep(1000);
	}
	
	public void PrintInvoice() throws InterruptedException {
		
		String parent=driver.getWindowHandle();
		System.out.println(parent);
		driver.findElement(By.xpath("//section[1]/div[1]/div[2]/div[1]/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Print Invoice')]")).click();
		Thread.sleep(4000);
		Set<String> allwindow=driver.getWindowHandles();
		int count=allwindow.size();
		System.out.println(count);
		
		for(String child:allwindow) {
			
			if (!parent.equalsIgnoreCase(child)) {
				
				driver.switchTo().window(child);
				
			}
			
		}
	}

	
	
	
   
	






	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
