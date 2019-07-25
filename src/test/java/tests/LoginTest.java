package tests;
import help.BaseTest;
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

public class LoginTest extends BaseTest {

    public String emailvalue;
    public String passwordvalue;


    @Test
    public void test1()
    {


        //validez pagina de register

        String expectedregister= BaseTest.getvalue("paginaregister");
        String actualregister=driver.getTitle();
        Assert.assertEquals(expectedregister,actualregister);

        //din registerpage dam click pe home button

        WebElement homebutton = driver.findElement(By.xpath("//a[contains(text(),'Home')]"));
        homebutton.click();


        //validez pagina de home

        String expectedres=BaseTest.getvalue("homepage");
        String actualres= driver.getTitle();
        Assert.assertEquals(expectedres,actualres);
        

        //dam click pe sign in button

        WebElement signinbutton = driver.findElement(By.xpath("//button[@id='btn1']"));
        signinbutton.click();

        //validam pagina signin

//        trebuie sa validam si register page tot cu metoda asta cand facem tema
        String expectedresult = BaseTest.getvalue("Loginpagetitle");
        String actualresult = driver.getTitle();
        Assert.assertEquals(expectedresult,actualresult);

//        //login cu valori inexistente pt toate field-urile

        emailvalue=""+BaseTest.getvalue("emailvalues");
        passwordvalue=""+BaseTest.getvalue("passwordvalues");
        String[] parseEmail=emailvalue.split(",");
        String[] parsePassword=passwordvalue.split(",");

        WebElement emailweb = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailvalue = parseEmail[3];
        emailweb.sendKeys(emailvalue);

        WebElement passwordweb = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passwordvalue = parsePassword[3];
        passwordweb.sendKeys(passwordvalue);

        WebElement enterbutton = driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton.click();
//
//        //validam mesajul de eroare
//
        String expectedmessage=BaseTest.getvalue("errormessage");//am apelat din input data properties
        WebElement message=driver.findElement(By.xpath("//label"));
        String actualmessage=message.getText();
        Assert.assertEquals(expectedmessage, actualmessage);

          //validez ca sunt inca pe pg de sign in

        Assert.assertEquals(expectedresult,actualresult);
        driver.navigate().refresh();

          //login cu spatii la email si parola

        WebElement emailweb1= driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailvalue1=parseEmail[4];
        emailweb1.sendKeys(emailvalue1);

        WebElement passweb=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passvalue=parsePassword[4];
        passweb.sendKeys(passvalue);

        WebElement enterbutton1 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton1.click();

        Assert.assertEquals(expectedmessage, actualmessage);
        Assert.assertEquals(expectedresult,actualresult);
        driver.navigate().refresh();

          //login cu caractere speciale la email si password

        WebElement emailweb2= driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailvalue2=parseEmail[3];
        emailweb2.sendKeys(emailvalue2);

        WebElement passweb2=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passvalue2=parsePassword[5];
        passweb2.sendKeys(passvalue2);

        WebElement enterbutton2 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton2.click();

        Assert.assertEquals(expectedmessage, actualmessage);
        Assert.assertEquals(expectedresult,actualresult);
        driver.navigate().refresh();

          //login cu email gresit si password gresit

        WebElement emailweb3= driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailvalue3=parseEmail[2];
        emailweb3.sendKeys(emailvalue3);

        WebElement passweb3=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passvalue3=parsePassword[1];
        passweb3.sendKeys(passvalue3);

        WebElement enterbutton3 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton3.click();

        Assert.assertEquals(expectedmessage, actualmessage);
        Assert.assertEquals(expectedresult,actualresult);
        driver.navigate().refresh();

          //login cu email gresit si password corect

        WebElement emailweb4= driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailvalue4=parseEmail[2];
        emailweb4.sendKeys(emailvalue4);

        WebElement passweb4=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passvalue4=parsePassword[3];
        passweb4.sendKeys(passvalue4);

        WebElement enterbutton4 = driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton4.click();

        Assert.assertEquals(expectedmessage, actualmessage);
        Assert.assertEquals(expectedresult,actualresult);
        driver.navigate().refresh();

          //login cu email corect si password gresit

        WebElement emailweb5=driver.findElement(By.xpath("//input[@placeholder='E mail']"));
        String emailvalue5=parseEmail[0];
        emailweb5.sendKeys(emailvalue5);

        WebElement passweb5=driver.findElement(By.xpath("//input[@placeholder='Password']"));
        String passvalue5=parsePassword[0];
        passweb5.sendKeys(passvalue5);

        WebElement enterbutton5=driver.findElement(By.xpath("//img[@id='enterbtn']"));
        enterbutton5.click();

        Assert.assertEquals(expectedmessage, actualmessage);
        Assert.assertEquals(expectedresult,actualresult);
        driver.navigate().refresh();


//        //daca vrem sa stergem campurile de email si password:

//        WebElement toClearemail = driver.findElement(By.xpath("//input[@placeholder='E mail']"));
//        toClearemail.clear();
//        WebElement toClearpassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
//        toClearpassword.clear();

        //dam refresh sa se stearga


    }

}

