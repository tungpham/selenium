package com.gui;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Go {

	public static void main(String...args) throws AWTException {
		
		File firefox = new File("C:\\Users\\tpham104\\Downloads\\FirefoxPortable\\FirefoxPortable.exe"); //path to portable firefox .exe file
		FirefoxBinary ffbin = new FirefoxBinary(firefox);
		
		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability(FirefoxDriver.BINARY, ffbin); 
		
		final WebDriver driver = new FirefoxDriver(cap);							
//		driver.get("https://signin.ebay.com/ws/eBayISAPI.dll?SellItem");
//		driver.get("http://csr.ebay.com/cse/start.jsf");
		driver.get("http://csr.ebay.com/sell/list.jsf?usecase=create&mode=AddItem&categoryId=97036&rp=srp&categoryPath=26395|180959|97033|97036&title=Supplement&motors=0");						
		
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {				
				//Find the text input element by its name				
		        WebElement username = driver.findElement(By.xpath("//input[(@placeholder='Email or username' or @placeholder='Email, phone or username') and @type='text']"));		        		        		        		        
		        WebElement password = driver.findElement(By.xpath("//input[@type='password' and not(@tabindex)]"));
		        return username.isDisplayed() && password.isDisplayed();
			}
		});		
		
		WebElement username = driver.findElement(By.xpath("//input[(@placeholder='Email or username' or @placeholder='Email, phone or username') and @type='text']"));		        		        		        		        
		username.sendKeys("blablaxxx@gmail.com");
		
		WebElement pass = driver.findElement(By.xpath("//input[@type='password' and not(@tabindex)]"));
        pass.sendKeys("Spring2016");
        
        pass.submit();
        
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {				
				//Find the text input element by its name				
		        WebElement condition = driver.findElement(By.id("condition"));        
		        return condition.isDisplayed();
			}
		});
        
        WebElement condition = driver.findElement(By.id("condition"));  
        Select select = new Select(condition);
        select.selectByVisibleText("New");
        
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\tpham104\\Koala.jpg");
        driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\tpham104\\Tulips.jpg");
        
        
//        driver.findElement(By.id("uLi")).click();                     
//        Robot r = new Robot();
//        type(r);                       
	}
	
	public static void type(Robot r) {
		press(r, KeyEvent.VK_C);
		press(r, KeyEvent.VK_SHIFT);
		press(r, KeyEvent.VK_SEMICOLON);
		press(r, KeyEvent.VK_BACK_SLASH);
		press(r, KeyEvent.VK_U);
		press(r, KeyEvent.VK_S);
		press(r, KeyEvent.VK_E);
		press(r, KeyEvent.VK_R);
		press(r, KeyEvent.VK_S);
		press(r, KeyEvent.VK_BACK_SLASH);
		press(r, KeyEvent.VK_T);
		press(r, KeyEvent.VK_P);
		press(r, KeyEvent.VK_H);
		press(r, KeyEvent.VK_A);
		press(r, KeyEvent.VK_M);
		press(r, KeyEvent.VK_1);
		press(r, KeyEvent.VK_0);
		press(r, KeyEvent.VK_4);
		press(r, KeyEvent.VK_BACK_SLASH);
		press(r, KeyEvent.VK_K);
		press(r, KeyEvent.VK_O);
		press(r, KeyEvent.VK_A);
		press(r, KeyEvent.VK_L);
		press(r, KeyEvent.VK_A);
		press(r, KeyEvent.VK_PERIOD);
		press(r, KeyEvent.VK_J);
		press(r, KeyEvent.VK_P);
		press(r, KeyEvent.VK_G);
	}
	
	public static void press(Robot r, int key) {
		r.keyPress(key);
		r.keyRelease(key);
	}
}
