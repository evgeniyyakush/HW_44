package core;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Linear {

	public static void main(String[] args) throws Exception {
//		Warnings OFF
		Logger.getLogger("").setLevel(Level.OFF);
		
		String driverPath = "";
		
//		Running on Windows and Mac OS
		if (System.getProperty("os.name").toUpperCase().contains("MAC"))							driverPath = "/usr/local/bin/firefox";
		else if (System.getProperty("os.name").toUpperCase().contains("WINDOWS"))		driverPath = "c:\\windows\\geckodriver.exe";
		else throw new IllegalArgumentException("Unknown OS");
		
		
//		Path to the driver
		System.setProperty("webdriver.gecko.driver", driverPath);
		
//		Driver
		WebDriver driver = new FirefoxDriver();
		
//		implicidWaitTime
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		
		driver.get("http://alex.academy/exe/signup/www/index.php");
		
		//------------------------------------------------------------   Process  --------------------------------------------------- //

		driver.findElement(By.id("id_fname")).sendKeys("Evgeniy");
		driver.findElement(By.id("id_lname")).sendKeys("Yakush");
		driver.findElement(By.id("id_email")).sendKeys("evgeniy.yakush@gmail.com");
		driver.findElement(By.id("id_phone")).sendKeys("805 705-2795");
		driver.findElement(By.id("id_submit_button")).click();
		
		System.out.println(driver.getTitle().equals("Confirmation") ? "pass" : "fail");
		driver.quit();
	}
}
