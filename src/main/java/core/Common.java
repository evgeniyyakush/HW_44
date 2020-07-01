package core;

import java.io.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.*;

class Common {
	static WebDriver driver;
    static Writer report;
    static Properties p = new Properties();
	static String url;
	static String browser;
    
	static void getWebDriver(String browser){
//		Warnings OFF
		Logger.getLogger("").setLevel(Level.OFF);
//		Driver Path
		String driverPath = "";	
		
/////////////////////////////  Firefox  /////////////////////////////
		if (browser.equalsIgnoreCase("firefox")) {
			
//		Running on Windows and Mac OS
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))								driverPath = "/usr/local/bin/firefox";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))			driverPath = "c:\\windows\\geckodriver.exe";
		else throw new IllegalArgumentException("Unknown OS");
		
//		Driver Path
		System.setProperty("webdriver.gecko.driver", driverPath);
		
//		Driver
		driver = new FirefoxDriver(); 
		
//		Window size
		driver.manage().window().setSize(new Dimension(1920, 1080));
		//driver.manage().window().maximize();
		
//		implicitWaitTime
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
/////////////////////////////  Chrome  /////////////////////////////
		else if (browser.equalsIgnoreCase("chrome")) {
			
//			Running on Windows and Mac OS
			if (System.getProperty("os.name").toUpperCase().contains("MAC"))							driverPath = "/usr/local/bin/chrome";
			else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))		driverPath = "c:\\windows\\chromedriver.exe";
			else throw new IllegalArgumentException("Unknown OS");
			
//			Driver Path
			System.setProperty("webdriver.chrome.driver", driverPath);
			
//			Warnings OFF
			System.setProperty("webdriver.chrome.silentOutput", "true");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("disable-infobars");
			option.addArguments("--disable-notifications");
			
//			Window size for Windows and Mac OS
			if (System.getProperty("os.name").toUpperCase().contains("MAC"))							option.addArguments("-start-fullscreen");
			else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))		option.addArguments("--start-maximized");
			else throw new IllegalArgumentException("Unknown OS");
			
//			Driver
			driver = new ChromeDriver(option);
			
////			Window size
//			driver.manage().window().setSize(new Dimension(1920, 1080));
//			//driver.manage().window().maximize();
			
//			implicitWaitTime
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
/////////////////////////////  Safari  /////////////////////////////
		else if (browser.equalsIgnoreCase("safari")) {
			
//			Running on Windows and Mac OS
			if (!System.getProperty("os.name").contains("Mac")) {
				throw new IllegalArgumentException("Safari is available only on Mac");
			}
			
//			Driver
			driver = new SafariDriver();
			
//			Window size
			driver.manage().window().setSize(new Dimension(1920, 1080));
			//driver.manage().window().maximize();
			
//			implicitWaitTime
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
/////////////////////////////  Edge  /////////////////////////////
		else if (browser.equalsIgnoreCase("edge")) {
			
//			Running on Windows and Mac OS
			if (System.getProperty("os.name").toUpperCase().contains("MAC"))							driverPath = "/usr/local/bin/edge";
			else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))		driverPath = "c:\\windows\\msedgedriver.exe";
			else throw new IllegalArgumentException("Unknown OS");
			
//			Warnings OFF
			System.setProperty("webdriver.edge.driver", driverPath);
			
//			Driver
			driver = new EdgeDriver();
			
//			Window size
			driver.manage().window().setSize(new Dimension(1920, 1080));
			//driver.manage().window().maximize();
			
//			implicitWaitTime
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		
/////////////////////////////  Unknown  WebDriver  /////////////////////////////
		else {throw new WebDriverException("Unknown WebDriver");}
		}
	
	//------------------------------------------------------------   Common_Methods  -------------------------------------------------------- //
	
///////////////////////////////////////////////////////////////////////////////
	//browserToOpen
	static void open(String browser, String url){
		getWebDriver(browser);
		driver.get(url);
		}
	
///////////////////////////////////////////////////////////////////////////////
	//verifyingPresence
	static boolean isElementPresent(By by) throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty()) {
			highlightElement(driver.findElement(by));
			unhighlightElement(driver.findElement(by));
			return true;}
		else 
			return false;}
	
///////////////////////////////////////////////////////////////////////////////
	//verifyingBySize
	static String getSize(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
			return driver.findElement(by).getSize().toString().replace(", ", "x"); 
		else 
			return "null";}

///////////////////////////////////////////////////////////////////////////////
	//verifyingByLocation
	static String getLocation(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (((RemoteWebDriver) driver).getCapabilities().getBrowserName().equals("Safari")) 
			return "(0x0)";
		else {
			if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
				return driver.findElement(by).getLocation().toString().replace(", ", "x"); 
		else 
			return "null";}
		}
	
///////////////////////////////////////////////////////////////////////////////
	//highlightingElement
    public static void highlightElement(WebElement element) throws Exception{
    	((RemoteWebDriver) driver).executeScript("arguments[0].setAttribute('style','border: solid 3px red');", element);
        Thread.sleep(10);}
    
///////////////////////////////////////////////////////////////////////////////
    //unHighlightingElement
    public static void unhighlightElement(WebElement element) throws Exception{
    	Thread.sleep(10);
    	//We have "solid 0px" - "0" as if we would have it "3" red color would never go away and would CONSTANTLY (yet we want it to blink/wink)
        ((RemoteWebDriver) driver).executeScript("arguments[0].setAttribute('style','border: solid 0px red');", element);}

///////////////////////////////////////////////////////////////////////////////
    //settingValue
	static void setValue(By by, String value) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && 
			  driver.findElement(by).isDisplayed())
			  driver.findElement(by).sendKeys(value);
	}
	
///////////////////////////////////////////////////////////////////////////////
	//gettingValue
	// also replacing "," with "-"
	static String getValue(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && 
			  driver.findElement(by).isDisplayed() && 
			  driver.findElement(by).getTagName().equalsIgnoreCase("input"))
			// as it is a value on the "SignUp" page
			// for getting value we use value
		return driver.findElement(by).getAttribute("value").toString().trim();

		else if (!driver.findElements(by).isEmpty() && 
				     driver.findElement(by).isDisplayed() && 
				     driver.findElement(by).getTagName().equalsIgnoreCase("span"))
			// as it is a confirmation on the "Confirmation" page 
			// for getting span we can use getText
			return driver.findElement(by).getText().trim().replaceAll(",", " - ");
		else return "null";}
	
///////////////////////////////////////////////////////////////////////////////
	//submitting
	static void submit(By by) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
			  driver.findElement(by).submit();}
	
///////////////////////////////////////////////////////////////////////////////
	//gettingBrowser
	static String getBrowser() {
		String browser = ((RemoteWebDriver) driver).getCapabilities().getBrowserName().toString().trim();
		return browser.replaceFirst(String.valueOf(browser.charAt(0)), String.valueOf(browser.charAt(0)).toUpperCase());
			}
	
///////////////////////////////////////////////////////////////////////////////
	//gettingFileName
	static String getFileName() {
		String file = driver.getCurrentUrl().toString().trim();
		return file.substring(file.lastIndexOf('/') + 1);
			}

///////////////////////////////////////////////////////////////////////////////
	//waitingTitlePage
	static void waitTitlePage(String title){
		WebDriverWait wait = new WebDriverWait(driver, 15); 
		wait.until(ExpectedConditions.titleIs(title));
		}
	
///////////////////////////////////////////////////////////////////////////////
	//writingReportHeader
	static void writeReportHeader(Writer report) throws IOException {
		report.write("#,Browser,Page,Field,isPresent,Value,Size,Location" + "\n");
		System.out.print("#,Browser,Page,Field,isPresent,Value,Size,Location" + "\n");
		}

///////////////////////////////////////////////////////////////////////////////
	//writingReportLine
	static void writeReportLine(String index, String fieldName, By by, Writer report) throws Exception {
			report.write(index + "," + Common.getBrowser() + "," + Common.getFileName() + "," + fieldName + "," + Common.isElementPresent(by) + "," +
				Common.getValue(by) + "," + Common.getSize(by) + "," + Common.getLocation(by) + "\n");	
	System.out.print(index + "," + Common.getBrowser() + "," + Common.getFileName() + "," + fieldName + "," + Common.isElementPresent(by) + "," +
				Common.getValue(by) + "," + Common.getSize(by) + "," + Common.getLocation(by) + "\n");
		}
	
	static void quit(){driver.quit();}
	
///////////////////////////////////////////////////////////////////////////////
	//checkingCheckBox
	public static void checkCheckBox(By by) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && 
	    	   driver.findElement(by).isDisplayed() && 
	    	 !driver.findElement(by).isSelected())
	    	  driver.findElement(by).click();}

///////////////////////////////////////////////////////////////////////////////
	//checkingRadioButton
	public static void checkRadioButton(By by) {
	     if (!driver.findElements(by).isEmpty() && 
		       driver.findElement(by).isDisplayed() && 
		     !driver.findElement(by).isSelected())
		      driver.findElement(by).click();}
	
///////////////////////////////////////////////////////////////////////////////
	//selectingDropDown
	public static void selectDropDown(By by, String value) {
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     if (!driver.findElements(by).isEmpty() && driver.findElement(by).isDisplayed())
	    	 // new Select(driver.findElement(by)).selectByIndex(5);
	    	 // new Select(driver.findElement(by)).selectByValue(value);  // <option value="California">
	    	 new Select(driver.findElement(by)).selectByVisibleText(value);
	     
	     
	}
}
