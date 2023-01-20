package com.parasoft.parabank.core;

import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ScreenAction {

    private final WebDriverWait wait;

    public ScreenAction(WebDriver driver){
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20l));
    }

    public void click(By locator){
        this.wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    public String getText(By locator){
        return this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    public void enterText(By locator, String text){
        this.wait.until(ExpectedConditions.elementToBeClickable((locator))).clear();
        this.wait.until(ExpectedConditions.elementToBeClickable((locator))).sendKeys(text);
    }
}
