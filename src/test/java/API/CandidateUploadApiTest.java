package API;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.example.Talentsage;
import org.testng.Assert;
import org.testng.annotations.*;

public class CandidateUploadApiTest extends Talentsage {

    @BeforeMethod
    public void setUpApi() {
        startApiContext();
    }

    @Test
    public void candidateUploadApiShouldReturn201() {

        String payload = "{ \"name\": \"Hasnain\", \"job\": \"QA Engineer\" }";

        APIResponse response = apiRequest.post(
                BASE_API_URL + "/api/users",
                RequestOptions.create().setData(payload)
        );

        Assert.assertEquals(
                response.status(),
                201,
                "Status code should be 201 Created"
        );

        Assert.assertTrue(
                response.text().contains("Hasnain"),
                "Response should contain candidate name"
        );
    }

    @AfterMethod
    public void tearDownApi() {
        tearDown();
    }
}
