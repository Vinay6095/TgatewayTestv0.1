package gateway.pages;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

import org.apache.xmlbeans.impl.soap.Text;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import gateway.base.TestBase;

public class PurchaseOrderListPage extends TestBase {

	public PurchaseOrderListPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[contains(text(),'Reset')]")

	WebElement resetbtn;

	public void VerifyPurchaseOrderPage() {
		String str = driver.findElement(By.xpath("//h1[contains(text(),'Purchase Order List')]")).getText();
		System.out.println(str);
		Assert.assertEquals(str, "Purchase Order List");

		System.out.println("Verified page " + str);
	}

	public void VerifyTotalPos() throws InterruptedException {

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

	}

	public void SelectFromDate(String fromyear, String frommonth) throws InterruptedException {
		resetbtn.click();

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

					if (date.equals(prop.getProperty("fromdate"))) {

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

	public void SelectToDate(String toyear, String tomonth, String todate) throws InterruptedException {

		driver.findElement(By.xpath(
				"//app-order[1]/section[1]/div[1]/div[1]/div[1]/div[1]/app-list-filter[1]/div[1]/div[2]/input[1]"))
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

	public void PatnerOrgdFilter(String OrgFilter) throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Partner Org Filter')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + OrgFilter + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//app-list-filter[1]/div[1]/div[5]/ngx-select-dropdown[1]/div[1]/button[1]/span[2]")).click();
		Thread.sleep(1000);
		String Ptnrorg = driver
				.findElement(By.xpath("//app-list-filter/div[1]/div[5]/ngx-select-dropdown/div[1]/button/span[1]"))
				.getText();
		System.out.println("Selected Partner Org Filter " + Ptnrorg);
		Thread.sleep(1000);

	}

	public void Patnerfilter(String patnerfilter) throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Partner Filter')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + patnerfilter + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(
				By.xpath("//app-list-filter[1]/div[1]/div[6]/ngx-select-dropdown[1]/div[1]/button[1]/span[2]")).click();
		Thread.sleep(1000);
		String Ptnrfilter = driver
				.findElement(By.xpath("//app-list-filter/div[1]/div[5]/ngx-select-dropdown/div[1]/button/span[1]"))
				.getText();
		System.out.println("Selected Patner Filter " + Ptnrfilter);
		Thread.sleep(1000);

	}

	public void SearchPO(String Ponumber) throws InterruptedException {
		Thread.sleep(2000);

		driver.findElement(By.xpath(
				"//body[1]/app[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-order[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/input[1]"))
				.sendKeys(Ponumber);

		Thread.sleep(3000);

	}

	public void ResetBtn() throws InterruptedException {

		driver.findElement(By.xpath("//button[contains(text(),'Reset')]")).click();

		Thread.sleep(2000);
		System.out.println("Clicked on Reset Button");
		String reset = driver.findElement(By.xpath("//span[contains(text(),'Status Filter')]")).getText();

		Assert.assertEquals(reset, "Status Filter");
		System.out.println("Text Cleared from all fields  " + reset);
	}

	public void AlreadyAcceptedPo(String Rowno) throws InterruptedException {

		String State = driver.findElement(By.xpath("//tbody/tr[" + Rowno + "]/td[10]")).getText();
		//System.out.println("PO Status is in " + State + " state");
		//Assert.assertEquals(State, "Accepted");
		
        if (State.equals("Accepted")) {
			
		
		driver.findElement(By.xpath("//tbody/tr[" + Rowno + "]/td[10]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@id='button-animated']")).click();

		driver.findElement(By.xpath("//a[contains(text(),'Mark as Accepted')]")).click();
		//System.out.println("Clicked on Mark as Accepted ");

		Alert a = driver.switchTo().alert();

		String popuptext = a.getText();
		System.out.println("Message from pop-up " + popuptext);

		Assert.assertEquals(popuptext, "All selected Purchase Orders are already in Accepted state!");
		Thread.sleep(2000);

		a.accept();
        }
        //Assert.assertEquals(State, "Accepted");
        
	}

	public void DownloadCSV(String CSVFilename) throws InterruptedException {

		driver.findElement(By.xpath("//tbody/tr[5]/td[7]")).click();
		driver.findElement(By.xpath("//button[@id='button-animated']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(text(),'Download CSV')]")).click();
		Thread.sleep(5000);

		File Downloadedcsv = new File(
				"C:\\Users\\Vinay\\Desktop\\Vinay Patil\\Selenium\\TgatewayTest\\" + CSVFilename + "");

		// Assert.assertEquals(Downloadedcsv.getName(), CSVFilename);
		System.out.println(Downloadedcsv.getName());
		// Downloadedcsv.delete();

	}

	public void Downloadpdf(String PdfFilename, String name) throws InterruptedException {

		driver.findElement(By.xpath("//tbody/tr[5]/td[7]")).click();
		driver.findElement(By.xpath("//button[@id='button-animated']")).click();
		Thread.sleep(1000);
		// driver.findElement(By.xpath("//a[contains(text(),'Download PDF')]")).click();
		Thread.sleep(5000);

		// File Downloadedpdf=new File("C:\\Users\\Vinay\\Desktop\\Vinay
		// Patil\\Selenium\\TgatewayTest\\Driver");
		//File Downloadedpdf = new File(
				//"C:\\Users\\Vinay\\Desktop\\Vinay Patil\\Selenium\\TgatewayTest\\" + PdfFilename + "");

		// Assert.assertEquals(Downloadedpdf.getName(), name);
		//System.out.println(Downloadedpdf.getName());
		// Downloadedpdf.delete();

	}

	public void Pagination() throws InterruptedException {

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
			int matchingelement = driver.findElements(By.xpath("//tbody/tr/td[3]")).size();
			System.out.println("Number of rows preset: " + matchingelement);

			totalrows = totalrows + matchingelement;

		}

		System.out.println("Total number of rows: " + totalrows);

		Assert.assertEquals(totalrows, res);

	}

	public void PriviousPage() throws InterruptedException {

		driver.findElement(By.xpath("//a[contains(text(),'3')]")).click();
		Thread.sleep(1000);

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
		
        driver.findElement(By.xpath("//a[contains(text(),'1')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'4')]")).click();
		Thread.sleep(2000);
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

	public void ShowEntries(String entries) throws InterruptedException {

		Select sel = new Select(driver.findElement(By.xpath(
				"//body/app[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-order[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/label[1]/select[1]")));

		sel.selectByValue(entries);
		Thread.sleep(2000);
		int matchingelement = driver.findElements(By.xpath("//tbody/tr/td[3]")).size();

		System.out.println("Number of enteries showing :" + matchingelement);
	}

	public void SearchOptioninStatusFilter() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Status Filter')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//body/app[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-order[1]/section[1]/div[1]/div[1]/div[1]/div[1]/app-list-filter[1]/div[1]/div[3]/ngx-select-dropdown[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("Accepted");

		Thread.sleep(2000);

	}

	public void SearchOptioninRecieverFilter() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Receiver Filter')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(
				"//body/app[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-order[1]/section[1]/div[1]/div[1]/div[1]/div[1]/app-list-filter[1]/div[1]/div[4]/ngx-select-dropdown[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys("ATIONAL");

		Thread.sleep(2000);

	}

	public void NavigatingPoDetailes() throws InterruptedException {

		driver.findElement(By.xpath("//tbody[1]/tr[1]/td[11]/a[1]")).click();
		Thread.sleep(2000);
		String PoDetailes = driver.findElement(By.xpath("//h1[contains(text(),'Purchase Order-Details')]")).getText();
		System.out.println(PoDetailes);

		Assert.assertEquals(PoDetailes, "Purchase Order-Details");
		Thread.sleep(2000);

	}

	public void DownloadPDFPODeatilsPage() throws InterruptedException {

		driver.findElement(By.xpath("//button[contains(text(),'Download PDF')]")).click();
		Thread.sleep(2000);

	}

	public void PrintPDFPODeatilsPage() throws InterruptedException {

		driver.findElement(By.xpath("//button[contains(text(),'Print PDF')]")).click();
		Thread.sleep(2000);

	}

	public void HamburgerButton() throws InterruptedException {
		driver.findElement(By.xpath("//app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/i[1]"))
				.click();
		Thread.sleep(2000);
		String Hamburge = driver.findElement(By.xpath("//h4[contains(text(),'Purchase Order Changed History:')]"))
				.getText();
		System.out.println(Hamburge);
		Assert.assertEquals(Hamburge, "Purchase Order Changed History:");

	}

	public void PlusButton() throws InterruptedException {

		driver.findElement(
				By.xpath("//app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/p[1]/button[1]"))
				.click();
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath(
				"//app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]"))
				.getText();
		// System.out.println(text);
		Thread.sleep(2000);

	}

	public void POAckStatus() throws InterruptedException {

		driver.findElement(By.xpath("//li[contains(text(),'A')]")).click();
		Thread.sleep(2000);

		String Ackstatus = driver.findElement(By.xpath("//h4[contains(text(),'PO Acknowledged Status')]")).getText();
		System.out.println(Ackstatus);
		Assert.assertEquals(Ackstatus, "PO Acknowledged Status");
	}

	public void InvoiceStatus() throws InterruptedException {
		driver.findElement(By.xpath("//li[@tooltip='Invoice Status']")).click();
		Thread.sleep(2000);
		String Text = driver.findElement(By.xpath("//h4[contains(text(),'Invoice Status')]")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text, "Invoice Status");
	}

	public void ShipmentStatus() throws InterruptedException {

		driver.findElement(By.xpath("//li[contains(text(),'S')]")).click();
		Thread.sleep(1000);
		String Text = driver.findElement(By.xpath("//h4[contains(text(),'Shipment Status')]")).getText();
		System.out.println(Text);
		Assert.assertEquals(Text, "Shipment Status");
	}

	public void Allowence() throws InterruptedException {

		driver.findElement(By.xpath(
				"//app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[6]/button[1]"))
				.click();
		Thread.sleep(2000);
		String Allowence = driver.findElement(By.xpath("//span[contains(text(),'Allowances:')]")).getText();
		System.out.println(Allowence);
		Assert.assertEquals(Allowence, "Allowances:");

	}

	public void ShowingEntries() {
		String Text = driver
				.findElement(
						By.xpath("//app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]"))
				.getText();
		System.out.println(Text);
		Assert.assertEquals(Text, "Showing 1 to 2 of 2 entries");

	}

	public void SelectMultiplePo() throws InterruptedException {
		// Select sel = new
		// Select(driver.findElement(By.xpath("//body/app[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-order[1]/section[1]/div[2]/div[1]/div[1]/div[2]/div[1]/label[1]/select[1]")));

		// sel.selectByValue("100");
		// Thread.sleep(2000);

		int NofPo = driver.findElements(By.xpath("//tbody/tr/td[7]")).size();
		System.out.println(NofPo);

		for (int i = 1; i <= NofPo; i++) {

			WebElement click = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[7]"));
			String Pono = click.getText();
			click.click();
			System.out.println("Clicked on Po Number: " + Pono);
			Thread.sleep(1000);

		}

	}

	public void SearchOptionPODetailes() throws InterruptedException {

		int machingproductcode = driver.findElements(By.xpath(
				"//app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr/td[1]/p[1]"))
				.size();
		System.out.println(machingproductcode);
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);

		String Productcode = driver.findElement(By.xpath(
				"//app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/table[1]/tbody[1]/tr[1]/td[1]/p[1]"))
				.getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"//app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/input[1]"))
				.sendKeys(Productcode);
		System.out.println("Checked Productcode no: " + Productcode);
		Thread.sleep(1000);

	}

	

	public void MultiSelectStatusFilter(String filter1, String filter2) throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Status Filter')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + filter1 + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + filter2 + "')]")).click();
	}

	public void MultiReceiverFilter(String filter1, String filter2) throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Receiver Filter')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + filter1 + "')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(text(),'" + filter2 + "')]")).click();
	}

	public void MultipleSelectionOfPartnerOrgFilter() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Partner Org Filter')]")).click();
		Thread.sleep(1000);
		int Nooptions = driver.findElements(By.xpath("//ul[2]/li")).size();
		// System.out.println(Nooptions);

		for (int i = 1; i <= 2; i++) {

			driver.findElement(By.xpath("//ul[2]/li[1]")).click();
			Thread.sleep(1000);
			String text = driver.findElement(By.xpath("//ngx-select-dropdown[1]/div[1]/div[1]/ul[1]/li[" + i + "]"))
					.getText();
			System.out.println("Selected Partner Org Filter is: " + text);
			// Thread.sleep(1000);

		}

	}

	public void MultipleSelectionOfPartnerFilter() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Partner Filter')]")).click();
		Thread.sleep(1000);
		int Nooptions = driver.findElements(By.xpath("//ul[2]/li")).size();
		// System.out.println(Nooptions);

		for (int i = 1; i <= 2; i++) {

			driver.findElement(By.xpath("//ul[2]/li[1]")).click();
			Thread.sleep(1000);
			String text = driver.findElement(By.xpath("//ngx-select-dropdown[1]/div[1]/div[1]/ul[1]/li[" + i + "]"))
					.getText();
			System.out.println("Selected Partner Filter is: " + text);
			// Thread.sleep(1000);

		}

	}

	public void SelectArrowMark() throws InterruptedException {

		driver.findElement(By.xpath(
				"//body[1]/app[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-order[1]/section[1]/div[2]/div[1]/div[1]/div[1]/div[1]/label[1]/input[1]"))
				.sendKeys("9827736731");

		Thread.sleep(2000);

	}

	public void ClickOnInvoiceno() throws InterruptedException {

		driver.findElement(By.xpath("//tbody[1]/tr[1]/td[3]/div[1]")).click();
		Thread.sleep(2000);

		String Text = driver.findElement(By.xpath("//h1[contains(text(),'Invoice-Details')]")).getText();
		// System.out.println(Text+" popup");
		Assert.assertEquals(Text, "Invoice-Details");

	}

	public void ClickOnASN() throws InterruptedException {
		driver.findElement(By.xpath("//tbody[1]/tr[1]/td[3]/div[1]")).click();
		Thread.sleep(1000);
		String Text = driver.findElement(By.xpath("//h1[contains(text(),'Shipment-Details')]")).getText();
		Assert.assertEquals(Text, "Shipment-Details");

	}

	public void RevicedNotification() throws InterruptedException {

		char[] Text = driver.findElement(By.xpath("//p[@id='notification']")).getText().toCharArray();
		System.out.println(Text);

		String str = "";
		int n = Text.length;
		int res = 0;

		for (int i = 0; i < n; i++) {

			if (Text[i] - '0' >= 0 && Text[i] - '0' <= 9) {

				str += Text[i];

				Thread.sleep(1000);

			}
		}
		res = Integer.parseInt(str);
		System.out.println("Total no of Reviced Po's " + res);

	}

	public void SelectAction(String name) throws InterruptedException {

		Select sel = new Select(driver.findElement(By.name("status")));

		sel.selectByValue(name);
		Thread.sleep(2000);
	}

	public void VerifyingPopupdetailes() throws InterruptedException {

		int size = driver
				.findElements(By.xpath(
						"/html[1]/body[1]/modal-container[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td[5]"))
				.size();
		// System.out.println("Number of rows in popup " + size);

		for (int i = 1; i <= size; i++) {

			String text = driver.findElement(
					By.xpath("/html[1]/body[1]/modal-container[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[" + i
							+ "]/td[5]"))
					.getText();

			//System.out.println("The status is " + text);
			// Assert.assertEquals(text, "Revised");
			Thread.sleep(2000);

			if (text.equals("Revised")) {

				System.out.println("The status is " + text);

				String CreatedOn = driver.findElement(
						By.xpath("/html[1]/body[1]/modal-container[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr["
								+ i + "]/td[1]"))
						.getText();
				System.out.println("Created Dte: " + CreatedOn);

				String PONumber = driver.findElement(
						By.xpath("/html[1]/body[1]/modal-container[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr["
								+ i + "]/td[2]"))
						.getText();
				System.out.println("Po number: " + PONumber);

				String InternalPo = driver.findElement(
						By.xpath("/html[1]/body[1]/modal-container[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr["
								+ i + "]/td[3]"))
						.getText();
				System.out.println("Internal PO Number: " + InternalPo);

				String ActionDate = driver.findElement(
						By.xpath("/html[1]/body[1]/modal-container[1]/div[1]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr["
								+ i + "]/td[4]/div[1]"))
						.getText();
				System.out.println("Action Date: " + ActionDate);

			}

		}

	}

	public void TotalREVACTPOs() throws InterruptedException {

		driver.findElement(By.xpath("//span[contains(text(),'Status Filter')]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'REV ACPT')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		Thread.sleep(2000);

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
		System.out.println("Total Number Of REV ACPT PO's  " + res);

	}

	public void TotalREVRJCTPos() throws InterruptedException {
		driver.findElement(By.xpath("//span[contains(text(),'Status Filter')]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//li[contains(text(),'REV RJCT')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(text(),'Apply')]")).click();
		Thread.sleep(2000);

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
		System.out.println("Total Number Of REV RJCT PO's  " + res);

	}

	public void PoDtailesPagination() throws InterruptedException {

		String text = driver.findElement(By.xpath("//div[@id='DataTables_Table_1_info']")).getText();

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

		driver.findElement(By.xpath("//a[@class='paginate_button last']")).click();

		String Lastpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		// System.out.println("Total number of pages: "+Lastpage);

		int Totalpages = Integer.valueOf(Lastpage);
		System.out.println("Total number of pages: " + Totalpages);
       Thread.sleep(1000);
       driver.findElement(By.xpath("//a[@class='paginate_button first']")).click();
       Thread.sleep(1000);
		int totalrows = 0;

		for (int p = 1; p <= Totalpages; p++) {

			driver.findElement(By.xpath("//body/app[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/span[1]/a["+p+"]")).click();
		    String currentno=driver.findElement(By.xpath("//body/app[1]/div[1]/div[1]/div[1]/div[1]/div[1]/app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/span[1]/a["+p+"]")).getText();
			System.out.println("Current page no: " + currentno);
			Thread.sleep(2000);
			//int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[7]")).size();
			//System.out.println("Number of rows preset: " + matchingelement);
			//Thread.sleep(1000);

			//totalrows = totalrows + matchingelement;

		}

		System.out.println("Total number of rows: " + totalrows);

		//Assert.assertEquals(totalrows, res);

	}

	public void PoDetailesFirstPage() throws InterruptedException {

		driver.findElement(By.xpath(
				"//app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/span[1]/a[2]"))
				.click();
		Thread.sleep(2000);
		String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		Thread.sleep(1000);
		System.out.println("Current page: " + currentpage);
		driver.findElement(By.xpath("//a[@class='paginate_button first']")).click();
		Thread.sleep(1000);
		String firstpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("After clicked on first page: " + firstpage);

		Assert.assertNotEquals(currentpage, firstpage);
	}

	public void PoDetailesLastPage() throws InterruptedException {

		String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("Current page: " + currentpage);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='paginate_button last']")).click();
		Thread.sleep(2000);
		String Lastpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("After clicked on last page: " + Lastpage);

		Assert.assertNotEquals(currentpage, Lastpage);

	}

	public void PoDetailsPriviousPage() throws InterruptedException {

		driver.findElement(By.xpath(
				"//app-po-details[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/span[1]/a[2]"))
				.click();
		Thread.sleep(1000);

		String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		Thread.sleep(1000);
		System.out.println("Current page: " + currentpage);
		driver.findElement(By.xpath("//a[@class='paginate_button previous']")).click();
		Thread.sleep(2000);
		String previouspage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		Thread.sleep(1000);
		System.out.println("After clicked on previous page: " + previouspage);
		Assert.assertNotEquals(currentpage, previouspage);
		Thread.sleep(2000);

	}

	public void PoDetailsNextpage() throws InterruptedException {

		String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("Current page:" + currentpage);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='paginate_button next']")).click();
		Thread.sleep(2000);
		String nextpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();

		System.out.println("After clicked on Next page: " + nextpage);

		Assert.assertNotEquals(currentpage, nextpage);

	}

	public void SelectFilterValidations() throws InterruptedException {
		SoftAssert Assertsoft = new SoftAssert();
		
		String nodata=driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println(nodata);
		if (nodata.equals("No data!")) {
			
			fail("No data Found on This Filter");
		}

		driver.findElement(By.xpath("//a[@class='paginate_button last']")).click();
		Thread.sleep(3000);
		String Lastpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
		System.out.println("Total number of pages: " + Lastpage);
		Thread.sleep(1000);

		int Totalpages = Integer.valueOf(Lastpage);

		int totalrows = 0;
		for (int i = 1; i <= Totalpages; i++) {

			driver.findElement(By.xpath("//a[contains(text(),'" + i + "')]")).click();
			Thread.sleep(2000);
			String currentpage = driver.findElement(By.xpath("//a[@class='paginate_button current']")).getText();
			System.out.println("Current Page is: " + currentpage);
			Thread.sleep(1000);
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[7]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;

			for (int j = 1; j <= matchingelement; j++) {

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[10]")).getText();

				if (Status.equals(prop.getProperty("selectfilter1"))) {

					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();
					System.out.println(j + ". " + PoNo + " PO number is in " + Status + " State");

				} else {
					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();
					System.out.println(j + ". " + PoNo + " PO number is in " + Status + " State");
					Assertsoft.assertEquals(Status, prop.getProperty("selectfilter1"),
							"Failed at page " + i + " at row number " + j);

				}
				// Assertsoft.assertEquals(Status, prop.getProperty("selectfilter1"));

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

	}

	public void MultiSelectFilterValidations() throws InterruptedException {
		SoftAssert Assertsoft = new SoftAssert();

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
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[7]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;

			for (int j = 1; j <= matchingelement; j++) {

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[10]")).getText();

				if (Status.equals(prop.getProperty("selectfilter1"))
						|| Status.equals(prop.getProperty("selectfilter2"))) {

					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();
					System.out.println(j + ". " + PoNo + " PO number is in " + Status + " State");

				} else {
					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();
					System.out.println(j + ". " + PoNo + " PO number is in " + Status + " State");

					Assertsoft.assertEquals(j, matchingelement + 1, "Failed at page " + i + " at row number " + j);

				}

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

	}

	public void ReceieverFilterValidation() throws InterruptedException {
		SoftAssert Assertsoft = new SoftAssert();
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
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[7]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;

			for (int j = 1; j <= matchingelement; j++) {

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[3]")).getText();

				if (Status.equals(prop.getProperty("recieverfilter"))) {

					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();
					System.out.println(j + ". " + PoNo + "PO number is under " + Status + " receiver");

				} else {
					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();
					System.out.println(j + ". " + PoNo + "PO number is under " + Status + " receiver");
					Assertsoft.assertEquals(Status, prop.getProperty("recieverfilter"),
							"Failed at page " + i + " at row number " + j);

				}

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

	}

	public void MultiReceieverFilterValidation() throws InterruptedException {
		SoftAssert Assertsoft = new SoftAssert();
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
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[7]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;

			for (int j = 1; j <= matchingelement; j++) {

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[3]")).getText();

				if (Status.equals(prop.getProperty("recieverfilter1"))
						|| Status.equals(prop.getProperty("recieverfilter2"))) {

					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();
					System.out.println(j + ". " + PoNo + "PO number is under " + Status + " receiver");

				} else {
					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();
					System.out.println(j + ". " + PoNo + "PO number is under " + Status + " receiver");
					Assertsoft.assertEquals(j, matchingelement + 1, "Failed at page " + i + " at row number " + j);

				}

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

	}

	public void PatnerOrgFilterValidation() throws InterruptedException {
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
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[7]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;

			for (int j = 1; j <= matchingelement; j++) {

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();

				Assert.assertEquals(Status, prop.getProperty("patnerorgfilter"));

				if (Status.equals(prop.getProperty("patnerorgfilter"))) {

					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();
					System.out.println(j + ". " + PoNo + "PO number is under " + Status + " Patner");

				} else {
					String PoNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();
					System.out.println(j + ". " + PoNo + "PO number is under " + Status + " Patner");

				}
				Assert.assertEquals(Status, prop.getProperty("patnerorgfilter"));

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);

	}

	public void ValidationDate() throws InterruptedException {
		
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
			int matchingelement = driver.findElements(By.xpath("//tbody[1]/tr/td[7]")).size();
			System.out.println("Number of rows present: " + matchingelement);

			totalrows = totalrows + matchingelement;
			for (int j = 1; j <= matchingelement; j++) {

				String text = driver.findElement(By.xpath("//tbody[1]/tr[" + j + "]/td[8]")).getText();
				String PONo=driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[7]")).getText();
				//System.out.println("Date " + text);
				String Month = "";
				String Year = "";
				for (int k = 0; k < text.length(); k++) {
					if (text.charAt(k + 1) == ' ') {
						Month += text.charAt(k);
						break;

					} else {
						Month += text.charAt(k);
					}

				}
				int count=0;
				for (int k =0; k<text.length(); k++) {
					
					if (text.charAt(k)==' ') {
						count++;
						
						
					}else {
						if (count==2) {
							
							Year += text.charAt(k);
						}
					}
						
						
				}

				System.out.println(Month);
				System.out.println(Year);
				System.out.println(j+". "+PONo+" is in "+Month+" "+Year);
				Assertsoft.assertEquals(Year, prop.getProperty("fromyear"),"Failed Because "+Year);
				Assertsoft.assertEquals(Month, prop.getProperty("month"),"Failed Because "+Month);
				
			}

		}
		Assertsoft.assertAll();
	}
	
	
	
	

}
