package com.parasoft.parabank.pages;

import com.parasoft.parabank.core.ScreenAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {

    private static final Long SECONDS = 20l;
    final WebDriver driver;
    final WebDriverWait wait;

    final ScreenAction element;

    protected BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(SECONDS));
        this.element = new ScreenAction(driver);
    }

    public abstract boolean isAt();

    public String getPageHeading(){
        return this.driver.findElement(By.tagName("h2")).getText();
    }
}
