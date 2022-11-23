package gateway.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import gateway.base.TestBase;

public class ASNListPage extends TestBase {

	public ASNListPage() throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Shipment-List')]")
	WebElement VerifyASNPage;
	
	@FindBy(xpath="//button[contains(text(),'Apply')]")
	WebElement ApplyBtn;
	
	
	@FindBy(xpath="//button[contains(text(),'Reset')]")
	WebElement Resetbtn;
	
	
	
	public void VerifyASNPage() {
		
		String Text=VerifyASNPage.getText();
		System.out.println(Text);
		Assert.assertEquals(Text, "Shipment-List");
	}
	
	public void VerifyTotalPos() throws InterruptedException {

		String text = driver.findElement(By.xpath("//section/div[2]/div[1]/div[1]/div[4]")).getText();

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
		//resetbtn.click();

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

	public void SelectToDate(String toyear, String tomonth) throws InterruptedException {

		driver.findElement(By.xpath(
				"//app-list-filter[1]/div[1]/div[2]/input[1]"))
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
	
	public void ClickOnApply() {
		
		ApplyBtn.click();
	}
	
	public void Resetbtn() throws InterruptedException {
		Resetbtn.click();
		Thread.sleep(1000);
	}
	
	
public void ValidationDate() throws InterruptedException {
		
		SoftAssert Assertsoft = new SoftAssert();
		
		String nodata=driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText();
		System.out.println(nodata);
		if (nodata.equals("No data!")) {
			
			fail("No data Found on This Filter");
		}

		driver.findElement(By.xpath("//a[@class='paginate_button last']")).click();
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

				String text = driver.findElement(By.xpath("//tbody[1]/tr[" + j + "]/td[7]")).getText();
				String PONo=driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[6]")).getText();
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

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[8]")).getText();

				if (Status.equals(prop.getProperty("Aselectfilter"))) {

					String ASNno = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[6]")).getText();
					System.out.println(j + ". " + ASNno + " ASN number is in " + Status + " State");

				} else {
					String ASNno = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[5]")).getText();
					System.out.println(j + ". " + ASNno + " ASN number is in " + Status + " State");
					Assertsoft.assertEquals(Status, prop.getProperty("Aselectfilter"),
							"Failed at page " + i + " at row number " + j);

				}
				// Assertsoft.assertEquals(Status, prop.getProperty("selectfilter1"));

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

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

				String Status = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[2]")).getText();

				if (Status.equals(prop.getProperty("Arecieverfilter"))) {

					String InvNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td[6]")).getText();
					System.out.println(j + ". " + InvNo + " Invoice number is under " + Status + " receiver");

				} else {
					String InvNo = driver.findElement(By.xpath("//tbody/tr[" + j + "]/td6]")).getText();
					System.out.println(j + ". " + InvNo + " Invoice number is under " + Status + " receiver");
					Assertsoft.assertEquals(Status, prop.getProperty("Arecieverfilter"),
							"Failed at page " + i + " at row number " + j);

				}

			}

		}

		System.out.println("Total Number Of Entries " + totalrows);
		Assertsoft.assertAll();

	}
  
  




	

}
