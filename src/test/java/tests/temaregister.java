package tests;

import help.BaseTest;
import help.helpermethods;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class temaregister extends BaseTest {

    public helpermethods functions =new helpermethods(driver);



    @Test
    public void start()
    {

        String expectedregister= BaseTest.getvalue("paginaregister");
        functions.validatepagetitle(expectedregister, driver);



        String expectedmessage=BaseTest.getvalue("Registerpagetitle");
        WebElement message=driver.findElement(By.xpath("//h2"));
        String actualmessage=message.getText();
        Assert.assertEquals(expectedmessage, actualmessage);


        String firstnamevalue = BaseTest.getvalue("firstname");
        WebElement firstnameweb=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstnameweb.sendKeys(firstnamevalue);

        String lastnamevalue = BaseTest.getvalue("lastname");
        WebElement lastnameweb=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastnameweb.sendKeys(lastnamevalue);

        String adresa=BaseTest.getvalue("adresa");
        WebElement adresaweb=driver.findElement(By.xpath("//textarea"));
        adresaweb.sendKeys(adresa);

        String adresamail=BaseTest.getvalue("adresamail");
        WebElement adresamailweb=driver.findElement(By.xpath("//input[@type='email']"));
        adresamailweb.sendKeys(adresamail);

        String nrtel=BaseTest.getvalue("nrtel");
        WebElement nrtelweb=driver.findElement(By.xpath("//input[@type='tel']"));
        nrtelweb.sendKeys(nrtel);

        //aici facem cu random adresa de mail si random nr de tel
//        String emailvalue = System.currentTimeMillis()+"@gmail.com";
//        WebElement emailweb = driver.findElement(By.xpath("//input[@type='email']"));
//        emailweb.sendKeys(emailvalue);
//
//        String phonevalue = System.currentTimeMillis()+"";//pune sa fie 13 nr
//        String newphone = phonevalue.substring(1,11); //pt ca nr de tel tre sa fie doar 10,
//        WebElement phoneweb = driver.findElement(By.xpath("//input[@type='tel']"));
//        phoneweb.sendKeys(newphone);

        WebElement femaleweb=driver.findElement(By.xpath("//input[@value='FeMale']"));
        femaleweb.click();


        driver.findElement(By.id("msdd")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Catalan')]")).click();


        WebElement skillsdropdown=driver.findElement(By.xpath("//select[@id='Skills']"));
        String skillvalue=BaseTest.getvalue("skillvalues");
        Select skillselect=new Select(skillsdropdown);
        skillselect.selectByValue(skillvalue);

        WebElement taradropdown=driver.findElement(By.xpath("//select[@id='countries']"));
        String taravalue=BaseTest.getvalue("countryvalues");
        functions.selectbyvaluedropdown(taradropdown,taravalue);

        driver.findElement(By.xpath("//span[@class='select2-selection__arrow']")).click();
        driver.findElement(By.xpath("//li[contains(text(), 'India')]")).click();

        WebElement yeardropdown=driver.findElement(By.xpath("//select[@id='yearbox']"));
        String yearvalue=BaseTest.getvalue("yearvalues");
        Select yearselect = new Select (yeardropdown);
        yearselect.selectByValue(yearvalue);

        WebElement monthdropdown=driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
        String monthvalue=BaseTest.getvalue("monthvalues");
        Select monthselect=new Select(monthdropdown);
        monthselect.selectByValue(monthvalue);

        WebElement daydropdown=driver.findElement(By.xpath("//select[@id='daybox']"));
        String dayvalue=BaseTest.getvalue("dayvalues");
        Select dayselect=new Select(daydropdown);
        dayselect.selectByValue(dayvalue);

        String parola=BaseTest.getvalue("passwordvalid");
        WebElement parolaweb=driver.findElement(By.xpath("//input[@id='firstpassword']"));
        parolaweb.sendKeys(parola);

        String confirm=BaseTest.getvalue("passwordvalid");
        WebElement confirmweb=driver.findElement(By.xpath("//input[@id='secondpassword']"));
        confirmweb.sendKeys(confirm); //putem sa nu mai facem string cu confirm, ci punem in paranteza stringul parola


        List<WebElement> hobbyweb=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int contor=0; contor<hobbyweb.size(); contor++) {
            String curentelement = hobbyweb.get(contor).getAttribute("value");
            if(curentelement.contains("Movies")){
                hobbyweb.get(contor).click();
            }
        }

        WebElement submitweb=driver.findElement(By.xpath("//button[@id='submitbtn']"));
        submitweb.click();

//        WebElement refreshweb=driver.findElement(By.xpath("//button[@id='Button1']"));
//        refreshweb.click();

        //validam ca apare o imagine

//        WebElement imagewebelement = driver.findElement(By.xpath("//img[@id='imagetrgt']"));
//        if (imagewebelement.isDisplayed()){
//            Assert.assertTrue(imagewebelement.isDisplayed());
//        }

        //WAIT EXPLICIT

        //validarea ca suntem pe pagina noua //validarea mesajului de deasupra tabelului

        WebElement mesaj = driver.findElement(By.xpath("//h4[1]"));
        Assert.assertTrue("The message is displayed",mesaj.isDisplayed());




    }
}
