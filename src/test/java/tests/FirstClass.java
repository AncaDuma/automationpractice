package tests;

import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class FirstClass {


    //declaram o variabila WebDriver
    public WebDriver driver;


    //declaram o metoda
    @Test

    public void start1 (){

        System.setProperty("webdriver.chrome.driver","C:\\automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        //deschid un browser, declaram un obiect
        driver.get("https://www.fossil.com/us/en.html?borderFreeCountry=n");
        //accesam un link cu metoda get deschide link-ul daca apelezi cu driverul
        driver.manage().window().maximize();
        //deschide site-ul pe tot ecranul
        driver.quit();
        //close iti inchide un tab cel care e deschis, quit iti inchide browserul cu totul
    }

    @Test
        //daca pun @before imi ruleaza test in rodinea in care vreau
    public void start2 (){

        System.setProperty("webdriver.chrome.driver","C:\\automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        //deschid un browser, declaram un obiect
        driver.get("https://www.youtube.com/channel/UCWv10Q9JJ0ztqSTSs7GRxaw");
        //accesam un link cu metoda get deschide link-ul daca apelezi cu driverul
        driver.manage().window().maximize();
        //deschide site-ul pe tot ecranul
        driver.quit();
        //close iti inchide un tab cel care e deschis, quit iti inchide browserul cu totul
    }


    @Test
    public void start3()
            //deschide pagina de facebook ,si un tab nou cu pag google, apoi le inchide
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");

        ((JavascriptExecutor) driver).executeScript("window.open()"); //se deschide un tab nou
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.google.com/");
        driver.close();
        driver.switchTo().window(tabs.get(0));

        driver.quit();
    }
}
