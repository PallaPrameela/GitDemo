package com.parasoft.parabank.core;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverInstance {

    private static final ThreadLocal<WebDriver> wDriver = new ThreadLocal<>();

    public static WebDriver getBrowserDriver(String browsername){

        WebDriver driver = null;

        switch (browsername){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            default:
                System.err.println("browser name is not correct ");
        }

       // assert driver !=null;
        if(driver==null){
            throw new RuntimeException("Driver is null");
        }
        wDriver.set(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        return driver;
    }

    public static WebDriver getDriver(){
        if(wDriver.get() ==null){
            throw new RuntimeException("driver is not initialized");
        }

        return wDriver.get();
    }

    public static void kill(){
        if(getDriver() != null){
            getDriver().quit();
        }
        wDriver.remove();
    }
}
