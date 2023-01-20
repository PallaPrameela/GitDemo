age com.parasoft.parabank.pages;

import com.parasoft.parabank.pojo.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return wait.until(d -> d.getTitle().contains("ParaBank | Welcome | Online Banking")
                && getPageHeading().contains("Customer Login")
        );
    }

   // private final By btnRegister = By.cssSelector("a[href='register.htm']");
    private final By btnRegister = By.linkText("Register");

    private final By inputUsername = By.name("username");
    private final By inputPassword = By.name("password");
    private final By btnLogin = By.cssSelector("input[value='Log In']");

    public RegistrationPage clickOnRegisterBtn(){
        this.element.click(btnRegister);
        return new RegistrationPage(driver);
    }

    public AccountServicesPage loginAs(User user){

        this.element.enterText(inputUsername, user.getUsername());
        this.element.enterText(inputPassword, user.getPassword());
        this.element.click(btnLogin);

        return new AccountServicesPage(this.driver);
    }



}
