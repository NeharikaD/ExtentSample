package RestAssuredTest;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class DataDrivenExamples {
    //@DataProvider(name = "DataForPost")
    public Object[][] dataForPost() {

//        Object[][] data = new Object[2][3];
//
//        data[0][0] = "Thomas";
//        data[0][1] = "Edison";
//        data[0][2] = 1;
//
//        data[1][0] = "Albert";
//        data[1][1] = "Einstein";
//        data[1][2] = 2;
//
//        return data;

        //or

        return new Object[][] {
                {"Stephen", "Hawking", 5},
                {"Alexander", "Bell", 6}
        };
    }

    //@Test(dataProvider = "DataForPost")
    public void testPost(String firstName, String lastName, int subjectID){
        baseURI = "http://localhost:3000";

        JSONObject request = new JSONObject();
        request.put("firstName", firstName);
        request.put("lastName", lastName);
        request.put("subjectID", subjectID);

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

//    @DataProvider(name = "DeleteData")
//    public Object[] dataForDelete() {
//        return new Object[] {
//             2,3
//        };
//    }
//
//    @Test(dataProvider = "DeleteData")
//    public void testDelete(int userId){
//        baseURI = "http://localhost:3000";
//
//        when()
//                .delete("/users"+userId)
//                .then()
//                .statusCode(200);
//    }
}
