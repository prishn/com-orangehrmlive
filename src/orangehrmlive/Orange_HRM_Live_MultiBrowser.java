package orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Orange_HRM_Live_MultiBrowser {
    //Multi-Browser
    static String browser = "Chrome";
    //static String browser = "Firefox";
    //static  String browser = "Edge";
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    //launch the browser
    static WebDriver driver;

    public void multiBrowserTest() {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Wrong browser name");
        }
    }

    public static void main(String[] args) {
        //object creation for multiBrowserTest
        Orange_HRM_Live_MultiBrowser obj = new Orange_HRM_Live_MultiBrowser();
        obj.multiBrowserTest();

        //open the URL into the browser
        driver.get(baseUrl);

        //maximise the browser
        driver.manage().window().maximize();

        //we give wait to drive until load the browser completely
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //print the title of the page
        System.out.println("Print the title of the page: " + driver.getTitle());

        //print the current URL
        System.out.println("Print the current URL: " + driver.getCurrentUrl());

        //print the page source
        System.out.print("Print the page source: " + driver.getPageSource());

        //click on Forgot your password link
        WebElement forgotPasswordLink = driver.findElement(By.className("orangehrm-login-forgot-header"));
        //WebElement forgotPasswordLink = driver.findElement(By.linkText("Forgot your password? "));
        forgotPasswordLink.click();

        //print the current URL
        System.out.println(driver.getCurrentUrl());

        //navigate back to the login page
        driver.navigate().back();
        System.out.println("Navigate back to the login page: " + driver.getCurrentUrl());

        //Refresh the page
        driver.navigate().refresh();
        System.out.println("Refresh the page: " + driver.getCurrentUrl());

        //enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("admin123@gmail.com");

        //enter the password to password field
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys("admin123");

        //click on login button
        WebElement login = driver.findElement(By.xpath("//button[@type ='submit']"));
        login.click();

        //closing the browser automatically
        driver.quit();
    }
}
