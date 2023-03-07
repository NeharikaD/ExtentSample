package RestAssuredTest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestRequests {

    public void testMethod() {
        /*
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Hermione");
        map.put("job", "Teacher");

//        System.out.println(map);

        JSONObject jsonObject = new JSONObject(map);

        System.out.println(jsonObject);                                            //gives output same as below
        System.out.println(jsonObject.toJSONString());                             //used to avoid some exceptions
*/      //or

        JSONObject request = new JSONObject();
        request.put("name", "Hermione");
        request.put("job", "Teacher");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .post("https://reqres.in/api/users")
                .then()
                .statusCode(201);

    }

    //@Test
    public void testPutMethod(){

        JSONObject request = new JSONObject();
        request.put("name", "Hermione");
        request.put("job", "Teacher");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .put("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }

    //@Test
    public void testPatchMethod(){

        JSONObject request = new JSONObject();
        request.put("name", "Hermione");
        request.put("job", "Teacher");

        System.out.println(request);
        System.out.println(request.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(request.toJSONString())
                .when()
                .patch("https://reqres.in/api/users/2")
                .then()
                .statusCode(200)
                .log().all();

    }

    @Test
    public void testDeleteMethod(){

        given()
                .when()
                .delete("https://reqres.in/api/users/2")
                .then()
                .statusCode(204)
                .log().all();

    }

}
