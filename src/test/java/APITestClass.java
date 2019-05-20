import API.AccountTests;
import API.OptionsTests;
import API.models.dto.AccountCredentialsDTO;
import org.testng.annotations.Test;


public class APITestClass {
    AccountTests account = new AccountTests();
    OptionsTests options = new OptionsTests();

    @Test
    public void checkOptions(){
        options.getTitleOK();
    }

    @Test
    public void accountAuthentication(){
        account.authenticateCredentialsOK(new AccountCredentialsDTO("Altairka", "rainbow"));
        account.authenticateWithInvalidCredentials();
        account.authenticateWithNullCredentials();
        account.authenticateWithWrongCredentials();

    }

}
