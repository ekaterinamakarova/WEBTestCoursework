package API;


import API.models.Social;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.fail;
import static org.testng.AssertJUnit.assertTrue;

public class OptionsTests {

    public void getTitleOK() {
        // given - блок всего, что отправляется серверу (настройки запроса)
        // when - что делать с запросом
        // then - ответ от сервера
        given().
                spec(Configuration.getRequestSpec()).
        when().
                get(App.getDomain() + "/api/options/title").
        then()
                .body("code", equalTo(200));
    }

    public void getSocialNetworksOK() {
        given().spec(Configuration.getRequestSpec()).when().get(App.getDomain() + "/api/options/socials").then()
                .body("code", equalTo(200));
    }

    public void getSocialNetworksContainItemsOK() {
        // Маппинг в объект
        Social[] socials = given().spec(Configuration.getRequestSpec()).when()
                .get(App.getDomain() + "/api/options/socials").as(Social[].class);

        assertTrue(socials.length != 0);
    }

    /* ----- Variables ----- */
    public final String socialTestNetwork = "[TestNetwork]";
    public static String socialTestNetworkID;

    public void postSocialOK() {
        Social social = new Social(socialTestNetwork, "https://github.com", null, "fab fa-github");
        String id = given().spec(Configuration.getRequestSpec()).contentType(ContentType.JSON).body(social).when()
                .post(App.getDomain() + "/api/options/social").then().statusCode(200).contentType(ContentType.JSON)
                .extract().path("object");

        socialTestNetworkID = id;
    }

    public void getSocialOK() {
        if (socialTestNetworkID == null) {
            fail("Social Test Network ID is null!");
        }

        given().spec(Configuration.getRequestSpec()).when()
                .get(App.getDomain() + "/api/options/social/{name}", socialTestNetworkID).then()
                .body("code", equalTo(200));
    }

    public void patchSocialOK() {
        if (socialTestNetworkID == null) {
            fail("Social Test Network ID is null!");
        }

        Social social = new Social(socialTestNetwork, "https://github.com", null, "fab fa-github");
        social.setId(socialTestNetworkID);

        given().spec(Configuration.getRequestSpec()).body(social).when().patch(App.getDomain() + "/api/options/social")
                .then().statusCode(200).body("code", equalTo(200));
    }

    public void deleteSocialOK() {
        if (socialTestNetworkID == null) {
            fail("Social Test Network ID is null!");
        }

        given().spec(Configuration.getRequestSpec()).body(socialTestNetworkID).when()
                .delete(App.getDomain() + "/api/options/social").then().statusCode(200).body("code", equalTo(200));
    }
}
