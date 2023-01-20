ckage com.parasoft.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsOverviewPage extends BasePage{
    protected AccountsOverviewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return this.wait.until(d -> d.getTitle().contains("ParaBank | Accounts Overview"));
    }

    private final By txtAccountNo = By.xpath("//table[@id='accountTable']/tbody/tr[@ng-repeat='account in accounts']/td/a");

    public String getAccountNo(){
        return this.element.getText(txtAccountNo);
    }
}
