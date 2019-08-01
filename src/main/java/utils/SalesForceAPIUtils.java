package utils;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.extern.log4j.Log4j2;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

@Log4j2
public class SalesForceAPIUtils {

    private String accessToken;

    public SalesForceAPIUtils() {
        accessToken = getAccessToken();
    }
    /**
     * Returns Authorization Token for SalesForce which can be used in further requests
     * @return
     */
    private String getAccessToken(){
        log.info("Getting Authorization token via API");
        return
                given()
                        .param("client_id", new PropertyManager().get("api.client.id"))
                        .param("client_secret", new PropertyManager().get("api.client.secret"))
                        .param("grant_type", "password")
                        .param("username", new PropertyManager().get("api.user"))
                        .param("password", new PropertyManager().get("api.password"))
                        .param("Content-type", "application/x-www-form-urlencoded")
                        .log().params()
                        .log().uri()
                .when()
                        .post("https://test.salesforce.com/services/oauth2/token")
                .then()
                        .log().body()
                        .statusCode(200)
                        .extract().path("access_token");
        //Response about 'invalid_grant' may be returned in case of incorrect password
    }

    public Response getRequest(String requestURL) {
        log.info(String.format("GET request to: %s", requestURL));
        return
                given()
                        .auth().oauth2(accessToken)
                        .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                        .log().uri()
                .when()
                        .get(requestURL)
                .then()
                        .log().body()
                        .statusCode(200)
                        .contentType(ContentType.JSON).extract().response();
    }

    public void patchRequest(String requestURL, String request) {
        log.info(String.format("PATCH request to: %s with request: %s", requestURL, request));
        given()
                .auth().oauth2(accessToken)
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .body(request)
                .log().uri()
                .log().body()
        .when()
                .patch(requestURL)
        .then()
                .log().body()
                .statusCode(204);
    }

    public Response postRequest(String requestURL, String request) {
        log.info(String.format("POST request to: %s with request: %s", requestURL, request));
        return
                given()
                        .auth().oauth2(accessToken)
                        .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                        .body(request)
                        .log().uri()
                        .log().body()
                .when()
                        .post(requestURL)
                .then()
                        .log().body()
                        .statusCode(201)
                        .contentType(ContentType.JSON).extract().response();
    }
}
