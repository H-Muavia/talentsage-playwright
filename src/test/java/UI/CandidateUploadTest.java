package UI;

import org.example.Talentsage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.nio.file.Paths;

public class CandidateUploadTest extends Talentsage {

    @BeforeMethod
    public void setUp() {
        startChrome();
        page.navigate(BASE_UI_URL);
    }

    @Test
    public void candidateShouldUploadCVSuccessfully() {


        page.setInputFiles("#cvUpload",
                Paths.get(RESUME_PATH));

        page.click("#submitBtn");


        boolean isSuccessVisible =
                page.locator("#successMessage").isVisible();

        Assert.assertTrue(
                isSuccessVisible,
                "CV upload success message should be visible"
        );
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}

