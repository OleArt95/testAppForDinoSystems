import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class UserSearchTest {

    public static final int USER_COMPANY_ID = 1;
    public static final String MEMBER_NAME  = "member_name";

    @Test
    public void searchUserTest(String idCompany, String name) {
        given().
            param(idCompany,USER_COMPANY_ID).
            param(name,              MEMBER_NAME).
        when().
            get("http://some_domain.com/company/" + idCompany + "/users?name=" + name).
        then().
            body(matchesJsonSchemaInClasspath("user_data.json")).
            extract().path("companyId").equals(USER_COMPANY_ID);
    }
}
