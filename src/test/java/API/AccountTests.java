package API;

import API.models.dto.AccountCredentialsDTO;
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


}
