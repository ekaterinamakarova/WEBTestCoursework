package API;

import API.models.dto.AccountBanDTO;
import API.models.dto.AccountCredentialsDTO;
import API.models.dto.AccountEmailDTO;
import API.models.dto.AccountRegistrationDTO;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;

public class AccountTests {
    public void authenticateCredentialsOK(AccountCredentialsDTO dto) {
        given()
                .spec(Configuration.getRequestSpec())
                .contentType(ContentType.JSON)
                .body(dto)
        .when()
                .post(App.getDomain() + "/api/account/authenticate")
        .then()
                .contentType(ContentType.JSON)
                .body("code", equalTo(200));
    }

    public void authenticateWithInvalidCredentials(){
        AccountCredentialsDTO dto = new AccountCredentialsDTO("login", null);
        given()
                .spec(Configuration.getRequestSpec())
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post(App.getDomain() + "/api/account/authenticate")
                .then()
                .statusCode(400);
    }

    public void authenticateWithNullCredentials(){
        AccountCredentialsDTO dto = new AccountCredentialsDTO(null, null);
        given()
                .spec(Configuration.getRequestSpec())
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post(App.getDomain() + "/api/account/authenticate")
                .then()
                .statusCode(400);
    }

    public void authenticateWithWrongCredentials(){
        AccountCredentialsDTO dto = new AccountCredentialsDTO("qwerty", "qwerty");
        given()
                .spec(Configuration.getRequestSpec())
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post(App.getDomain() + "/api/account/authenticate")
                .then()
                .statusCode(404);
    }

    public void registrationValid(AccountRegistrationDTO dto){
        given()
                .spec(Configuration.getRequestSpec())
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post(App.getDomain() + "/api/account/register")
                .then()
                .contentType(ContentType.JSON)
                .body("code", equalTo(200));
    }


    public void registrationWithMissingCredentials(){
        AccountRegistrationDTO dto = new AccountRegistrationDTO("qwerty", "qwerty", null);
        given()
                .spec(Configuration.getRequestSpec())
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post(App.getDomain() + "/api/account/register")
                .then()
                .statusCode(400);
    }

    public void registrationWithEmptyCredentials(){
        AccountRegistrationDTO dto = new AccountRegistrationDTO(null, null, null);
        given()
                .spec(Configuration.getRequestSpec())
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post(App.getDomain() + "/api/account/register")
                .then()
                .statusCode(400);
    }

    public void registrationLoginIsAlreadyTaken(){
        AccountRegistrationDTO dto = new AccountRegistrationDTO("Altairka", "password", "qwerty@mail.com");
        given()
                .spec(Configuration.getRequestSpec())
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post(App.getDomain() + "/api/account/register")
                .then()
                .statusCode(409);
    }

    public void registrationEmailIsAlreadyTaken(){
        AccountRegistrationDTO dto = new AccountRegistrationDTO("newuser", "password", "altair999z@gmail.com");
        given()
                .spec(Configuration.getRequestSpec())
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post(App.getDomain() + "/api/account/register")
                .then()
                .statusCode(409);
    }

    public void updateEmail(AccountEmailDTO dto){
        given()
                .spec(Configuration.getRequestSpec())
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post(App.getDomain() + "/api/account/email")
                .then()
                .contentType(ContentType.JSON)
                .body("code", equalTo(200));
    }

    public void ban(AccountBanDTO dto){
        given()
                .spec(Configuration.getRequestSpec())
                .contentType(ContentType.JSON)
                .body(dto)
                .when()
                .post(App.getDomain() + "/api/account/email")
                .then()
                .contentType(ContentType.JSON)
                .body("code", equalTo(200));
    }





}
