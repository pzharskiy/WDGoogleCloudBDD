package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class CloudPage {

    protected WebDriver driver;
    protected String BASE_URL = "https://cloud.google.com/";
    protected WebDriverWait wait;

    public CloudPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 7);
        PageFactory.initElements(driver, this);
    }

    public abstract CloudPage open();


}
