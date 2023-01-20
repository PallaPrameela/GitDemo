package com.parasoft.parabank.pages;

import com.parasoft.parabank.pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillPayPage extends BasePage {
    protected BillPayPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> this.driver.getTitle().contains("ParaBank | Bill Pay"));
    }

    private final By inputPayeeName = By.name("payee.name");
    private final By inputAddress = By.name("payee.address.street");
    private final By inputCity = By.name("payee.address.city");
    private final By inputState = By.name("payee.address.state");
    private final By inputZipcode = By.name("payee.address.zipCode");
    private final By inputPhone = By.name("payee.phoneNumber");
    private final By inputAccount = By.name("payee.accountNumber");
    private final By inputVerifyAccount = By.name("verifyAccount");
    private final By inputAmount = By.name("amount");
    private final By inputFromAccount = By.name("fromAccountId");
    private final By btnSendPayment = By.cssSelector("input.button[value='Send Payment']");

    public void payBillTo(User recipient, int amountToBeTransferred) {

        this.element.enterText(inputPayeeName, recipient.getFirstName() + " " + recipient.getLastName());
        this.element.enterText(inputAddress, recipient.getAddress());
        this.element.enterText(inputCity, recipient.getCity());
        this.element.enterText(inputState, recipient.getState());
        this.element.enterText(inputZipcode, recipient.getZipcode());
        this.element.enterText(inputPhone, recipient.getPhone());
        this.element.enterText(inputAccount, recipient.getAccountNo());
        this.element.enterText(inputVerifyAccount, recipient.getAccountNo());
        this.element.enterText(inputAmount, String.valueOf(amountToBeTransferred));
        this.element.click(btnSendPayment);
    }

    public boolean isPaymentSuccessful(){
        //TODO
        return false;
    }

    public String getPayeeName(){
        //TODO
        return "";
    }

    public int getTransferredAmount(){
        //TODO
        return 0;
    }

    public String getFromAccountNo(){
        //TODO
        return "";
    }
}
