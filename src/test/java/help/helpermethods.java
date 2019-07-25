package help;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class helpermethods {

    WebDriver driver;


    //declaram un constructor


    public helpermethods(WebDriver driver) {

        this.driver=driver;

    }

    //click method

    public void clickmethod(WebElement element) {

        element.click();
    }

    //select dupa valoare method

    public void selectbyvaluedropdown(WebElement element,String value) {

        Select elementselect=new Select(element);
        elementselect.selectByValue(value);

    }

    //metoda ca sa validam titlul unei pagini

    public void validatepagetitle(String expectedvalue, WebDriver driver) {

        if (expectedvalue.length()>0) {

            String actualvalue=driver.getTitle();
            Assert.assertEquals(expectedvalue,actualvalue);
        }
    }
}
