package com.parasoft.parabank.steps;

import com.github.javafaker.Faker;
import com.parasoft.parabank.core.DriverInstance;
import com.parasoft.parabank.pages.*;
import com.parasoft.parabank.pojo.User;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static com.parasoft.parabank.core.DriverInstance.getDriver;
import static io.github.bonigarcia.wdm.WebDriverManager.getDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BillPaymentSteps {

    User sender;
    User recipient;
    @Given("I navigate to {string}")
    public void iNavigateTo(String url) {

       getDriver().get(url);
       assertTrue(new LoginPage(getDriver()).isAt());
    }

    @And("I register user as {string}")
    public void iRegisterUserAs(String userType) {

            if(userType.equals("SENDER")){
                registerUserAsType(sender);
            }
            else if(userType.equals("RECIPIENT")){
                registerUserAsType(recipient);
            }

    }

    private void registerUserAsType(User user) {
        LoginPage loginPage = new LoginPage(getDriver());
        RegistrationPage registrationPage = loginPage.clickOnRegisterBtn();
        assertTrue(registrationPage.isAt());
        AccountServicesPage accountServicesPage;
        accountServicesPage = registrationPage.registerUserAs(user);
        assertTrue(accountServicesPage.isRegistered(user.getUsername()));

        AccountsOverviewPage accountsOverviewPage = accountServicesPage.goToAccountsOverviewPage();

        assertTrue(accountsOverviewPage.isAt());
        String accountNo = accountsOverviewPage.getAccountNo();
        user.setAccountNo(accountNo);
        System.out.println("account no of " + user + " is " + user.getAccountNo());

        loginPage= accountServicesPage.logout();
        assertTrue(loginPage.isAt());
    }

    @When("I login as a SENDER")
    public void iLoginAsASENDER() {

        LoginPage loginPage = new LoginPage(getDriver());

        AccountServicesPage accountServicesPage = loginPage.loginAs(sender);
        assertTrue(accountServicesPage.isAt());
    }

    @Then("I can transfer money {int} to RECIPIENT")
    public void iCanTransferMoneyToRECIPIENT(int amount) {

        AccountServicesPage accountServicesPage = new AccountServicesPage(getDriver());

        BillPayPage billPayPage = accountServicesPage.goToBillPayPage();
        assertTrue(billPayPage.isAt());

        billPayPage.payBillTo(recipient, amount);

        assertTrue(billPayPage.isPaymentSuccessful());
        assertEquals(billPayPage.getPayeeName(), recipient.getFirstName() + " " + recipient.getLastName());
        assertEquals(billPayPage.getTransferredAmount(), amount);

        accountServicesPage.logout();
    }
    @Given("I generate sender and recipient user data")
    public void iGenerateSenderAndRecipientUserData() {

        Faker faker1 = new Faker();

        sender = new User();
        sender.setFirstName(faker1.name().firstName());
        sender.setLastName(faker1.name().lastName());
        sender.setAddress(faker1.address().streetAddress());
        sender.setCity(faker1.address().city());
        sender.setState(faker1.address().state());
        sender.setZipcode(faker1.address().zipCode());
        sender.setSsn(faker1.idNumber().ssnValid());
        sender.setPhone(faker1.phoneNumber().cellPhone());
        sender.setUsername(faker1.name().username());

        System.out.println("sender data is " + sender);

        Faker faker2 = new Faker();

        recipient = new User();
        recipient.setFirstName(faker2.name().firstName());
        recipient.setLastName(faker2.name().lastName());
        recipient.setAddress(faker2.address().streetAddress());
        recipient.setCity(faker2.address().city());
        recipient.setState(faker2.address().state());
        recipient.setZipcode(faker2.address().zipCode());
        recipient.setSsn(faker2.idNumber().ssnValid());
        recipient.setPhone(faker2.phoneNumber().cellPhone());
        recipient.setUsername(faker2.name().username());

        System.out.println("receiver data is " + recipient);
    }


}

