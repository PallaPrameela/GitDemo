package com.parasoft.parabank.pages;

import com.parasoft.parabank.pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage{
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return wait.until(driver1 -> driver1.getTitle().contains("ParaBank | Register for Free Online Account Access"));
    }

    private final By inputFirstName = By.id("customer.firstName");

    private final By inputLastName = By.id("customer.lastName");

    private final By inputAddress = By.id("customer.address.street");

    private final By inputCity = By.id("customer.address.city");

    private final By inputState = By.id("customer.address.state");

    private final By inputZipcode = By.id("customer.address.zipCode");

    private final By inputPhoneNo = By.id("customer.phoneNumber");

    private final By inputSSN = By.id("customer.ssn");

    private final By inputUsername = By.id("customer.username");

    private final By inputPassword = By.id("customer.password");

    private final By inputConfirmPassword = By.id("repeatedPassword");

    private final By btnRegister = By.cssSelector("input[value = 'Register']");


    public AccountServicesPage registerUserAs(User user){

        this.element.enterText(inputFirstName, user.getFirstName());
        this.element.enterText(inputLastName, user.getLastName());
        this.element.enterText(inputAddress, user.getAddress());
        this.element.enterText(inputCity, user.getCity());
        this.element.enterText(inputState, user.getState());
        this.element.enterText(inputZipcode, user.getZipcode());
        this.element.enterText(inputPhoneNo, user.getPhone());
        this.element.enterText(inputSSN, user.getSsn());
        this.element.enterText(inputUsername, user.getUsername());


        this.element.enterText(inputPassword, user.getPassword());
        this.element.enterText(inputConfirmPassword, user.getPassword());

        this.element.click(btnRegister);

        if(isErrorDisplayed())
        {
            throw new RuntimeException("user not able to register because " + getErrorMessage());
        }

        return new AccountServicesPage(this.driver);
    }

    public boolean isErrorDisplayed(){
        try {
            return this.driver.findElement(By.cssSelector("span.error")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }

    public String getErrorMessage(){
        By errorMsg = By.cssSelector("span.error");
        return this.element.getText(errorMsg);
    }

}
