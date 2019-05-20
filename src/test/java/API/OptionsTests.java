package API;


import API.models.dto.Social;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;

public class OptionsTests {

    public void getTitleOK() {
        given()
                .spec(Configuration.getRequestSpec())
                .when()
                .get(App.getDomain() + "/api/options/title")
                .then()
                .body("code", equalTo(200));
    }

    public void getSocialNetworksOK() {
        given()
                .spec(Configuration.getRequestSpec())
                .when()
                .get(App.getDomain() + "/api/options/socials")
                .then()
                .body("code", equalTo(200));
    }

    public void getSocialNetworksContainItemsOK() {
        Social[] socials = given()
                .spec(Configuration.getRequestSpec())
                .when()
                .get(App.getDomain() + "/api/options/socials")
                .as(Social[].class);
        assertTrue(socials.length != 0);
    }


    public void postSocialOK(String token, String socialTestNetwork) {
        Social social = new Social(socialTestNetwork, "https://github.com", null, "fab fa-github");
        given()
                .spec(Configuration.getRequestSpec())
                .header("Authentication", "Bearer " + token)
                .contentType(ContentType.JSON)
                .body(social)
                .when()
                .post(App.getDomain() + "/api/options/social")
                .then()
                .statusCode(200)
                .body("code", equalTo(200));
    }

    public void getSocialOK( String socialTestNetworkID) {
        if (socialTestNetworkID == null) {
            fail("Social Test Network ID is null!");
        }
        given()
                .spec(Configuration.getRequestSpec())
                .when()
                .get(App.getDomain() + "/api/options/social/{name}", socialTestNetworkID)
                .then()
                .body("code", equalTo(200));
    }

    public void patchSocialOK(String token, String patchSocial) {
        given()
                .spec(Configuration.getRequestSpec())
                .header("Authentication", "Bearer " + token)
                .body(patchSocial).when()
                .patch(App.getDomain() + "/api/options/social")
                .then()
                .statusCode(200)
                .body("code", equalTo(200));
    }

    public void deleteSocialOK(String token, String socialID) {
        given()
                .spec(Configuration.getRequestSpec())
                .header("Authentication", "Bearer " + token)
                .body(socialID).when()
                .delete(App.getDomain() + "/api/options/social")
                .then()
                .statusCode(200)
                .body("code", equalTo(200));
    }
}
