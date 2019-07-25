package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class webclass {

    public WebDriver driver;

    @Test
    public void start()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();

        //validam pagina pe care ne aflam (register page)!!!

        String expectedregister= "Register";
        String actualregister=driver.getTitle();
        Assert.assertEquals(expectedregister,actualregister);

        //validam un mesaj

        String expectedmessage="Register";
        WebElement message=driver.findElement(By.xpath("//h2"));
        String actualmessage=message.getText();
        Assert.assertEquals(expectedmessage, actualmessage);

        //completezi first name field
        //VALOARE PE CARE VREAU SA ADUG
        String firstnamevalue = "Kinga";
        //IDENTIFICARE WEBELEMENT
        WebElement firstnameweb=driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        //completeaza
        firstnameweb.sendKeys(firstnamevalue);

        String lastnamevalue = "Luka";
        WebElement lastnameweb=driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastnameweb.sendKeys(lastnamevalue);


// da click
        WebElement maleweb=driver.findElement(By.xpath("//input[@value='Male']"));
        maleweb.click();


//am selectat din date of birth cate un field din fiecare
        WebElement yeardropdown=driver.findElement(By.xpath("//select[@id='yearbox']"));
        String yearvalue="2010";
        Select yearselect = new Select (yeardropdown);
        yearselect.selectByValue(yearvalue);

        WebElement monthdropdown=driver.findElement(By.xpath("//select[@ng-model='monthbox']"));
        String monthvalue="May";
        Select monthselect=new Select(monthdropdown);
        monthselect.selectByValue(monthvalue);

        WebElement daydropdown=driver.findElement(By.xpath("//select[@id='daybox']"));
        String dayvalue="1";
        Select dayselect=new Select(daydropdown);
        dayselect.selectByValue(dayvalue);

        //

        List<WebElement> hobbyweb=driver.findElements(By.xpath("//input[@type='checkbox']"));
        for (int contor=0; contor<hobbyweb.size(); contor++) {
            String curentelement = hobbyweb.get(contor).getAttribute("value");
            if(curentelement.contains("Movies")){
                hobbyweb.get(contor).click();
            }
        }
        // Languages dropdown list
        driver.findElement(By.id("msdd")).click();
        List<WebElement> languages=driver.findElements(By.xpath("//a[@class='ui-corner-all']"));
        for(int i=0;i<languages.size();i++)
        {
            System.out.println(languages.get(i).getText());
            if(languages.get(i).getText().equalsIgnoreCase("Arabic"))
            {
                languages.get(i).click();
                break;
            }
        }

        //div[contains(text(),'textul dupa care vreau sa caut')]  asa cautam cu contains!!!!!(pe google)


    }
}
