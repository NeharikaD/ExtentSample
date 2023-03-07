package RestAssuredTest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class Examples {
    //@Test
    public void testGet(){
        baseURI = "http://localhost:3000";

        given()
                .param("name","Development")
                .get("/subjects")
                .then()
                .statusCode(200)
                .log().all();
    }

    //@Test
    public void testPost(){
        baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName", "Hermione");
        request.put("lastName", "Granger");
        request.put("subjectID", 1);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .log().all();
    }

    //@Test
    public void testPatch(){
        baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();
//        request.put("firstName", "Hermione");
        request.put("lastName", "ranger");
//        request.put("subjectID", 1);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .patch("/users/4")
                .then()
                .statusCode(200)
                .log().all();
    }

    //@Test
    public void testPut(){
        baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName", "Lisa");
        request.put("lastName", "Mano-ban");
        request.put("subjectID", 1);

        given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Content-Type", "application/json")
                .body(request.toJSONString())
                .when()
                .put("/users/4")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    public void testDelete(){
        baseURI = "http://localhost:3000";

        when()
                .delete("/users/4")
                .then()
                .statusCode(200);
    }

}
