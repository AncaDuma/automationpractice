package tests;

import help.BaseTest;
import help.helpermethods;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class hovertest extends BaseTest {

    //declaram un obiect de tipul helpermethods

    public helpermethods functions=new helpermethods(driver);


    @Test
    public void proba()
    {

        WebElement switchbutton=driver.findElement(By.xpath("//a[contains(text(),'SwitchTo')]"));
        Actions action=new Actions(driver);
        action.moveToElement(switchbutton).build().perform();

        WebElement windowsbutton=driver.findElement(By.xpath("//a[contains(text(), 'Windows')]"));

        //wait explicit

        new WebDriverWait(driver,4500).until(ExpectedConditions.visibilityOf(windowsbutton));
        functions.clickmethod(windowsbutton);


    }
}
