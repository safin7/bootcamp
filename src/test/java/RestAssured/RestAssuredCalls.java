package RestAssured;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.either;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.text.IsEmptyString.emptyOrNullString;


public class RestAssuredCalls {
    @Test
    public void getUsers(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2";

        Response response= given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("size()", greaterThan(0))
                .extract().response();
        //  System.out.print("Response: " + response.asString());

        JsonPath jsonPath = response.jsonPath();

        List<Map<String, Object>> users = jsonPath.getList("$");
        System.out.println("  ");
        for(Map<String,Object> user : users){
            System.out.println("id: " + user.get("id"));
            System.out.println("name: " + user.get("name"));
            System.out.println("Email: " + user.get("email"));
            System.out.println("Gender: " + user.get("gender"));
            System.out.println("Status: " + user.get("status"));;
            System.out.println("--------------------------------");
        }
    }

    @Test
    public void getUserById(){
        int userID = 6828988;
        String expectedName = "Girindra Pothuvaal";
        String expectedEmail = "pothuvaal_girindra@abbott-marquardt.example";
        String expectedGender = "female";
        String expectedStatus = "active";

        RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
        String BearerToken = "";

        Response response= given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " +BearerToken)
                .pathParams("id",userID)
                .when()
                .get("/{id}")
                .then()
                .statusCode(200)
                .body("id", equalTo(userID))
                .body("name", notNullValue())
                .body("email", containsString("@"))
                .body("gender", either(equalTo("male")).or(equalTo("female")))
                .body("status", not(emptyOrNullString()))
                .body("size()", greaterThan(0))
                .extract().response();

        JsonPath jsonPath = response.jsonPath();

        int id = jsonPath.getInt("id");
        String ActualName = jsonPath.getString("name");
        String ActualEmail = jsonPath.getString("email");
        String ActualGender = jsonPath.getString("gender");
        String ActualStatus = jsonPath.getString("status");

        System.out.println("id: " + id);
        System.out.println("name: " + ActualName);
        System.out.println("Email: " + ActualEmail);
        System.out.println("Gender: " + ActualGender);
        System.out.println("Status: " + ActualStatus);;

//        Assert.assertEquals(ActualStatus, expectedStatus);
//        Assert.assertEquals(ActualName, expectedName);
//        Assert.assertEquals(ActualEmail, expectedEmail);
//        Assert.assertEquals(ActualGender, expectedGender);
//        Assert.assertEquals(id, userID);
    }

    @Test
    public void GetUserByName(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2/users";
        String BearerToken = "";

        String nameToSearch = "John Smith";

        Response response= given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + BearerToken)
                .queryParam("name", nameToSearch)
                .when()
                .get()
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println("Response: " + response.asPrettyString());
    }

    @Test
    public void PostUser(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2/users";

        String BearerToken = "ls1be4f9913e6285e340cb07bfd7b99f0abb84e1fa5da73e4b7f9d73cd8b54e092";

        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer" + BearerToken)
                        .body("""
                        {
                        "name": "John Smith",
                        "email": "JS@example.com",
                        "gender": "male",
                        "status": "inactive"
                        }
                        """)
                        .when()
                        .post()
                        .then()
                        .statusCode(201)
                        .extract().response();

        JsonPath jsonPath = response.jsonPath();

        int id = jsonPath.getInt("id");
        String ActualName = jsonPath.getString("name");
        String ActualEmail = jsonPath.getString("email");
        String ActualGender = jsonPath.getString("gender");
        String ActualStatus = jsonPath.getString("status");

        System.out.println("id: " + id);
        System.out.println("name: " + ActualName);
        System.out.println("Email: " + ActualEmail);
        System.out.println("Gender: " + ActualGender);
        System.out.println("Status: " + ActualStatus);;

    }

    @Test
    public void PutUser(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2/users";

        String BearerToken = "1be4f9913e6285e340cb07bfd7b99f0abb84e1fa5da73e4b7f9d73cd8b54e092";

        int userId = 6828988;
        String newName = "Jason Smith";
        Response response=
                given()
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer" + BearerToken)
                        .body("{\"name\": \"" + newName + "\"}")
                        .when()
                        .put("/"+ userId)
                        .then()
                        .statusCode(200)
                        .extract()
                        .response();

        System.out.println("response: " + response.asPrettyString());

    }

    @Test
    public void DeleteUser(){
        RestAssured.baseURI = "https://gorest.co.in/public/v2/users";

        String BearerToken = "1be4f9913e6285e340cb07bfd7b99f0abb84e1fa5da73e4b7f9d73cd8b54e092";

        int userId = 6828988;

        Response response= given()
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer" + BearerToken)
                .when()
                .delete("/"+ userId)
                .then()
                .statusCode(204)
                .extract().response();

        System.out.println("response: " + response.asPrettyString());

        System.out.println("User with ID: " + userId + " has Been Deleted");
    }
}