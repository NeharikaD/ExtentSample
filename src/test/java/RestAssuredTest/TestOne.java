package RestAssuredTest;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class TestOne {
    @Test
    void testMethodOne(){
        //when RestAssured is not static import then {RestAssured.get("https://reqres.in/api/users?page=2");}<-- this is valid. ex:- import io.restassured.RestAssured;
//        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        Response response = get("https://reqres.in/api/users?page=2");
        System.out.println(response.toString());
        System.out.println(response.getBody().toString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    void testMethodTwo(){
        given()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .body("data.id[0]", equalTo(7));
    }
}
