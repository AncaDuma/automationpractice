package help;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.stream.FileImageInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;
    public static Properties property;
    public FileInputStream file;

    @Before
    public void test () throws FileNotFoundException {

        System.setProperty("webdriver.chrome.driver", "C:\\automation\\ChromeDriver\\chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        loadproperty();

    //Wait implicit
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//        loadproperty();
    }

    //metoda care iti incarca un fisier de proprietati

    public void loadproperty () throws FileNotFoundException {

        property=new Properties();
        file=new FileInputStream("C:\\Users\\anca duma\\IdeaProjects\\probaautomation\\src\\test\\resources\\InputData.properties");
        try {
            property.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //metoda care returneaza val dintr-un fisier properties pe baza unei chei

    public static String getvalue (String key){

        return property.getProperty(key);
    }
//    @After
//    public void inchide (){
//        driver.quit();
//    }
}
