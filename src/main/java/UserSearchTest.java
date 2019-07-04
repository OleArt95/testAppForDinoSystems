import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;

public class UserSearchTest {

    @Test
    public void searchUserTest(String idCompany, String name) {
        given().
            param(idCompany, 777).
            param(name, "Izergil").
        when().
            get("http://some_domain.com/company/" + idCompany + "/users?name=" + name).
        then().
            body()



    }
}
