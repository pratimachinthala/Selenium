package com.Earnest.EarnestAssesment;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass extends JunglePage {
	public JunglePage junglepage;
    
	public static WebDriver driver = null;
	
    @Before
    public void beforeTest() {


    	System.setProperty("webdriver.chrome.driver", "/Users/anil/Downloads/JungleSocks/chromedriver");
		driver =new ChromeDriver();
        driver.get("https://jungle-socks.herokuapp.com/");

    }

    @Test
    public void CheckoutTest(){
    	driver.findElement(By.id("line_item_quantity_zebra")).sendKeys(String.valueOf(Data.Zebra));
    	driver.findElement(By.id("line_item_quantity_lion")).sendKeys(String.valueOf(Data.Lion));
    	driver.findElement(By.id("line_item_quantity_elephant")).sendKeys(String.valueOf(Data.Elephant));
    	driver.findElement(By.id("line_item_quantity_giraffe")).sendKeys(String.valueOf(Data.Giraffe));
    	 Select dropdown = new Select (driver.findElement(By.name("state")));
    	 dropdown.selectByValue(Data.State);
    	 driver.findElement(By.name("commit")).click();
    
        assertEquals(("$" + junglepage.ExpectedTotal()),junglepage.Total(driver));


    }
    @After
    public void AfterTest(){
    
		//	Thread.sleep(1000);
		
        driver.quit();
    }

}
