package gateway.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
	 
    public static WebDriver driver;
	public static Properties prop;
	
	//public static ChromeOptions options;
	
	
	public TestBase() throws IOException {
		
	    prop=new Properties();
		FileInputStream ip = new FileInputStream("C:\\Users\\Vinay\\OneDrive - Tangentia India Technologies Pvt Ltd\\Documents\\5 - Selenium & Jmeter\\QA Automation\\Selenium\\TgatewayTest\\src\\main\\java\\gateway\\config\\Config.properties");
		
		prop.load(ip);
		
		//System.out.println(prop.getProperty("browser "));
	}


public static void initialisation() {
	
	String browsername = prop.getProperty("browser");
	
	if(browsername.equals("chrome")) {
		//WebDriverManager.chromedriver.setup();
		ChromeOptions options=new ChromeOptions();
		String downloadpath=System.getProperty("user.dir");
		HashMap<String, Object> chromePref = new HashMap<String, Object>();

		chromePref.put("download.default_directory_content_settings.popup", 0);
		chromePref.put("download.default_directory", downloadpath);
		options.setExperimentalOption("prefs", chromePref);
		
		
		System.setProperty("webdriver.chrome.driver", "C://Users//Vinay//OneDrive - Tangentia India Technologies Pvt Ltd//Documents//5 - Selenium & Jmeter//QA Automation//Selenium//TgatewayTest//Driver/chromedriver.exe");
		driver=new ChromeDriver(options);
	}
	else if(browsername.equals("FireFox")) {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Vinay\\OneDrive - Tangentia India Technologies Pvt Ltd\\Documents\\5 - Selenium & Jmeter\\QA Automation\\Selenium\\TgatewayTest\\Driver/geckodriver.exe");
		driver=new FirefoxDriver();
	}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
	
	System.out.println(prop.getProperty("url"));
	}
}

