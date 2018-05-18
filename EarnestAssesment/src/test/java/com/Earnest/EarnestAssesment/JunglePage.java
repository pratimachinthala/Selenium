package com.Earnest.EarnestAssesment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class JunglePage {
	
	
	//WebDriver driver=new ChromeDriver();
    private static WebElement element = null;
	
	    /* public static WebElement getElement(WebDriver driver,String locator){
	CONFIG= new Properties();
	FileInputStream fn;
	try {
		fn = new FileInputStream(System.getProperty("user.dir")+"//src//config/config.properties");
	
	try {
		CONFIG.load(fn);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	// OR Properties
	OR= new Properties();
	fn =new FileInputStream(System.getProperty("user.dir")+"//src//OR.properties");
	try {
		OR.load(fn);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    element = driver.findElement(By.id(OR.getProperty(locator)));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    return element;

}
*/
    
    //get data from the Data class & prices ml.m,      from Price class

    public static int ZebraCost(){
        int zebracost = Data.Zebra * Prices.ZebraPrice;

        return zebracost;

    }
    public static int ElephantCost(){
        int elephantcost = Data.Elephant * Prices.ElephantPrice;

        return elephantcost;
    }
    public static int GiraffeCost(){
        int giraffecost = Data.Giraffe * Prices.GiraffePrice;

        return giraffecost;
    }
    public static int LionCost(){
        int lioncost = Data.Lion * Prices.LionPrice;

        return lioncost;

    }
    
    public static int ZCheckoutPrice(WebDriver driver){
        WebElement price = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[2]"));

        String PriceText = price.getText();

        WebElement Quantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]"));

        String QuantityText = Quantity.getText();

       int zebratotal = Integer.parseInt(PriceText) * Integer.parseInt(QuantityText);

        return zebratotal;


    }
    

    public static int ECheckoutPrice(WebDriver driver){
        WebElement price = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[2]"));

        String PriceText = price.getText();

        WebElement Quantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[3]"));

        String QuantityText = Quantity.getText();

        int elephanttoatal = Integer.parseInt(PriceText) * Integer.parseInt(QuantityText);

        return elephanttoatal;


    }

    

    public static int GCheckoutPrice(WebDriver driver){
        WebElement Price = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[5]/td[2]"));

        String PriceText = Price.getText();

        WebElement Quality = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[5]/td[3]"));

        String QuantityText = Quality.getText();

        int giraffetotal = Integer.parseInt(PriceText) * Integer.parseInt(QuantityText);

        return giraffetotal;



    }
   

    public static int LCheckoutPrice(WebDriver driver){
        WebElement Quantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[2]"));

        String QuantityText = Quantity.getText();

        WebElement price = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]"));

        String PriceText = price.getText();

        int ltotal = Integer.parseInt(PriceText) * Integer.parseInt(QuantityText);

        return ltotal;


    }
    public static String Total(WebDriver driver){
        WebElement totalelement = driver.findElement(By.id("total"));

        String totalcheckout = totalelement.getText();

        return totalcheckout;
    }

  

    public static double TotalTaxes(WebDriver driver){
        WebElement totalamount = driver.findElement(By.id("taxes"));

        String taxtext = totalamount.getText();

        int totaltax = Integer.parseInt(taxtext);

        return totaltax;


    }

    

    public static String InvalidStateError(WebDriver driver){
        WebElement PElement = driver.findElement(By.xpath("/ html/body/div/p"));
        String Message = PElement.getText();

        return Message;

    }
    public static int Subtotal (){
        int subtotal = ZebraCost() + ElephantCost() + GiraffeCost() + LionCost();

        return subtotal;
    }
    public static double SalesTax(String State) {
        String stateCA ="CA";
        String stateNY = "NY";
        String stringMN = "MN";


        if (Data.State.equals(stateCA)){
           double CATaxes = (Subtotal() * Taxes.CATax);
            return CATaxes;

        }
        else if(Data.State.equals(stateNY)){
            double NYTaxes = Subtotal()* Taxes.NYTax;
            return NYTaxes;
        }

        else  if (Data.State.equals(stringMN)){
            double MNTaxes= Subtotal() * Taxes.MNYax;
            return MNTaxes;
        }

        else {
            double OtherTaxes = Subtotal() * Taxes.OtherTax;
            return OtherTaxes;
        }




    }
    public static String  ExpectedTotal(){
        double d =(Subtotal() +SalesTax(Data.State));
        DecimalFormat df = new DecimalFormat("#0.00");

        String  expectedtotal = (String.valueOf((df.format(d))));


        return expectedtotal;

    }



}