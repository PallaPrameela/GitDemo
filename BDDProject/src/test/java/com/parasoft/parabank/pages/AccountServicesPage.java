package com.parasoft.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountServicesPage extends BasePage{

    public AccountServicesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> getPageHeading().contains("Account Services"));
    }

    public boolean isRegistered(String username){
        String titleHeading = this.element.getText(By.cssSelector("h1.title"));
        String titleDescription = this.element.getText(By.cssSelector("h1.title + p"));

        return titleHeading.contains("Welcome " + username) &&
                titleDescription.contains("Your account was created successfully. You are now logged in.");
    }

    public AccountsOverviewPage goToAccountsOverviewPage(){
        this.element.click(By.linkText("Accounts Overview"));
        return new AccountsOverviewPage(driver);
    }

    public BillPayPage goToBillPayPage(){
        By linkBillPay = By.linkText("Bill Pay");
        this.element.click(linkBillPay);
        return new BillPayPage(driver);
    }

    public LoginPage logout(){
        By linkLogout = By.linkText("Log Out");
        this.element.click(linkLogout);
       return new LoginPage(driver);
    }
}
