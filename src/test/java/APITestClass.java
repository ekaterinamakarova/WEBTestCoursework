import API.AccountTests;
import API.OptionsTests;
import API.models.dto.AccountAuthenticationDTO;
import API.models.dto.AccountBanDTO;
import API.models.dto.AccountEmailDTO;
import API.models.dto.AccountRegistrationDTO;
import org.testng.annotations.Test;


public class APITestClass {

    AccountTests account = new AccountTests();
    OptionsTests options = new OptionsTests();


    @Test
    public void accountAuthentication(){
        account.authenticateCredentialsOK(new AccountAuthenticationDTO("Altairka", "rainbow"));
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
    }

    @Test
    public void updateEmail(){
        account.updateEmail(new AccountEmailDTO("acciosky@mail.ru"));
    }

    @Test
    public void ban(){
        account.ban(new AccountBanDTO(" ", "Altairka", true));
        account.ban(new AccountBanDTO(" ", "Altairka", false));
    }

    @Test
    public void getInfo(){
        account.getAccountInfo("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiJiY2ZiYTNhNS03MDFlLTQ4NmUtODAzNy1hNDM0ZTUwZWNhMjMiLCJ1bmlxdWVfbmFtZSI6ImFsdGFpcmthIiwibmJmIjoxNTU4MTkxMTM5LCJleHAiOjE1NTgyNzc1MzksImlhdCI6MTU1ODE5MTEzOSwiaXNzIjoiaHR0cHM6XFwxMjcuMC4wLjE6NTAwMSIsImF1ZCI6Imh0dHBzOlxcMTI3LjAuMC4xOjUwMDEifQ.p7X43wpWeZdJKqI7fNupYMRRMHJks9qHIYH_IBVMHtA");
        account.getProfileInfo("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9zaWQiOiJiY2ZiYTNhNS03MDFlLTQ4NmUtODAzNy1hNDM0ZTUwZWNhMjMiLCJ1bmlxdWVfbmFtZSI6ImFsdGFpcmthIiwibmJmIjoxNTU4MTkxMTM5LCJleHAiOjE1NTgyNzc1MzksImlhdCI6MTU1ODE5MTEzOSwiaXNzIjoiaHR0cHM6XFwxMjcuMC4wLjE6NTAwMSIsImF1ZCI6Imh0dHBzOlxcMTI3LjAuMC4xOjUwMDEifQ.p7X43wpWeZdJKqI7fNupYMRRMHJks9qHIYH_IBVMHtA");
    }

    @Test
    public void checkOptions(){
        options.getTitleOK();
        options.getSocialNetworksOK();
        options.getSocialNetworksContainItemsOK();
//        options.postSocialOK();
//        options.getSocialOK();
//        options.patchSocialOK();
//        options.deleteSocialOK();
    }



}
