import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserSearchTest {

    @Test
    public void searchUserTest(String idCompany, String name) {
        given().
            param(idCompany, "user_company_id").
            param(name, "member_name").
        when().
            get("http://some_domain.com/company/" + idCompany + "/users?name=" + name).
        then().
            body(matchesJsonSchemaInClasspath("")).extract().path("company_id").equals("user_company_id");
    }
}
