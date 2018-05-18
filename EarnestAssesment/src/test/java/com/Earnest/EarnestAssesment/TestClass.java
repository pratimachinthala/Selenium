package com.Earnest.EarnestAssesment;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {
	public JunglePage junglepage;
    
    private static WebDriver driver = null;



    @Before
    public void beforeMethod() {

        //driver=new FirefoxDriver();
        //landingPage.Website();

    	System.setProperty("webdriver.chrome.driver", "/Users/anil/Downloads/JungleSocks/chromedriver");
		driver =new ChromeDriver();
        driver.get("https://jungle-socks.herokuapp.com/");

    }

    @After
    public void AfterMethod(){
        driver.quit();
    }

    @Test
    public void FirstTest(){
        junglepage.Zebra(driver).sendKeys(String.valueOf(Data.Zebra));
        junglepage.Lion(driver).sendKeys(String.valueOf(Data.Lion));
        junglepage.Elephant(driver).sendKeys(String.valueOf(Data.Elephant));
        junglepage.Giraffe(driver).sendKeys(String.valueOf(Data.Giraffe));
        junglepage.State(driver).selectByValue(Data.State);
        junglepage.Checkout(driver).click();

        assertEquals(("$" + junglepage.ExpectedTotal()),junglepage.Total(driver));


    }

}
