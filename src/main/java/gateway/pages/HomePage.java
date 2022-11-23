package gateway.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import gateway.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//ul/li[2]/div[1]")

	WebElement OrderManagement;
	
	
	@FindBy(xpath = "//ul/li[2]/div[1]/div[2]/div[1]")

	WebElement OrderList;
	
	@FindBy(xpath="//ul/li[3]/div[1]")
	
	WebElement BillingAndPayment;
	
	@FindBy(xpath="//ul/li[3]/div[1]/div[2]/div[1]/a[1]")
	WebElement Invoice;
	
	@FindBy(xpath="//ul/li[2]/div[1]/div[2]/div[2]")
	WebElement ASNList;
	
	

	public HomePage() throws IOException {
		
		
		PageFactory.initElements(driver, this);

	}
	
	public PurchaseOrderListPage VerifyingOrderManagement() throws InterruptedException, IOException {
		
		OrderManagement.click();
		Thread.sleep(1000);
		OrderList.click();
		Thread.sleep(1000);
		
		return new PurchaseOrderListPage();
	}
	
	public InvoiceListPage VerifyingBillingAndPayment() throws InterruptedException, IOException {
		
		BillingAndPayment.click();
		Thread.sleep(1000);
		Invoice.click();
		
		return new InvoiceListPage();
		
	}
	
	public ASNListPage ASNPageVerify() throws InterruptedException, IOException {
		OrderManagement.click();
		Thread.sleep(1000);
		ASNList.click();
		Thread.sleep(1000);
		
		return new ASNListPage();
	}
	
	

}
