import API.AccountTests;
import API.OptionsTests;
import API.models.dto.AccountCredentialsDTO;
import API.models.dto.AccountRegistrationDTO;
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

    @Test
    public void accountRegister(){
        account.registrationValid(new AccountRegistrationDTO("ekaterina99", "password", "acciosky@mail.ru" ));
        account.registrationWithMissingCredentials();
        account.registrationWithEmptyCredentials();
        account.registrationLoginIsAlreadyTaken();
        account.registrationEmailIsAlreadyTaken();
        //account.updateEmail();
        account.ban("1","Altairka", true);

    }

}
