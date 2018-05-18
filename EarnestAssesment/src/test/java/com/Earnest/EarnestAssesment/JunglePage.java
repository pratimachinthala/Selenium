package com.Earnest.EarnestAssesment;

import java.text.DecimalFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class JunglePage {
	
	WebDriver driver=new FirefoxDriver();
    private static WebElement element = null;
	
	public static WebElement Zebra(WebDriver driver){

        element = driver.findElement(By.id("line_item_quantity_zebra"));

        return element;

    }

    public static WebElement Lion(WebDriver driver){
        element = driver.findElement(By.id("line_item_quantity_lion"));

        return element;

    }

    public static WebElement Elephant(WebDriver driver){
        element = driver.findElement(By.id("line_item_quantity_elephant"));

        return element;
    }

    public static WebElement Giraffe(WebDriver driver){
        element = driver.findElement(By.id("line_item_quantity_giraffe"));

        return element;
    }
    public static Select State(WebDriver driver){
        Select dropdown = new Select (driver.findElement(By.name("state")));

        return dropdown ;

    }

    public static WebElement Checkout(WebDriver driver){
        element = driver.findElement(By.name("commit"));

        return element;
    }

    public static int ZebraCost(){
        int Zc = Data.Zebra * Prices.ZebraPrice;

        return Zc;

    }
    public static int CheckZebra(WebDriver driver){
        WebElement price = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[2]"));

        String PriceText = price.getText();

        WebElement Quantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[2]/td[3]"));

        String QuantityText = Quantity.getText();

       int Zt = Integer.parseInt(PriceText) * Integer.parseInt(QuantityText);

        return Zt;


    }
    public static int ElephantCost(){
        int Ec = Data.Elephant * Prices.ElephantPrice;

        return Ec;
    }

    public static int CheckElephant(WebDriver driver){
        WebElement price = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[2]"));

        String PriceText = price.getText();

        WebElement Quantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[4]/td[3]"));

        String QuantityText = Quantity.getText();

        int Et = Integer.parseInt(PriceText) * Integer.parseInt(QuantityText);

        return Et;


    }

    public static int GiraffeCost(){
        int Gc = Data.Giraffe * Prices.GiraffePrice;

        return Gc;
    }

    public static int CheckGiraffe(WebDriver driver){
        WebElement Price = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[5]/td[2]"));

        String PriceText = Price.getText();

        WebElement Quality = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[5]/td[3]"));

        String QuantityText = Quality.getText();

        int Gt = Integer.parseInt(PriceText) * Integer.parseInt(QuantityText);

        return Gt;



    }
    public static int LionCost(){
        int Lc = Data.Lion * Prices.LionPrice;

        return Lc;

    }

    public static int CheckLion(WebDriver driver){
        WebElement Quantity = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[2]"));

        String QuantityText = Quantity.getText();

        WebElement price = driver.findElement(By.xpath("/html/body/table[2]/tbody/tr[3]/td[3]"));

        String PriceText = price.getText();

        int Lt = Integer.parseInt(PriceText) * Integer.parseInt(QuantityText);

        return Lt;


    }

    public static int Subtotal (){
        int ST = ZebraCost() + ElephantCost() + GiraffeCost() + LionCost();

        return ST;
    }

    public static double TotalTaxes(WebDriver driver){
        WebElement tdElement = driver.findElement(By.id("taxes"));

        String descriptionText = tdElement.getText();

        int Tt = Integer.parseInt(descriptionText);

        return Tt;


    }

    public static String  ExpectedTotal(){
        double d =(Subtotal() +SalesTax(Data.State));
        DecimalFormat df = new DecimalFormat("#0.00");

        String  Et = (String.valueOf((df.format(d))));


        return Et;

    }



    public static String Total(WebDriver driver){
        WebElement tdElement = driver.findElement(By.id("total"));

        String descriptionText = tdElement.getText();

        return descriptionText;
    }

    public static String InvalidStateError(WebDriver driver){
        WebElement PElement = driver.findElement(By.xpath("/ html/body/div/p"));
        String Message = PElement.getText();

        return Message;

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


}

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
    	fn =new FileInputStream(System.getProperty("user.dir")+"//src//config/OR.properties");
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
