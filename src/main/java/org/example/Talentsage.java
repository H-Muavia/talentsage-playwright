package org.example;

import com.microsoft.playwright.*;

public class Talentsage {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;
    protected APIRequestContext apiRequest;


    protected final String BASE_UI_URL = "https://visiontact.com/upload";
    protected final String BASE_API_URL = "https://visiontact.com/";
    protected final String RESUME_PATH = "src/test/resources/files/resume.pdf";



    protected void startChrome() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false)
        );
        context = browser.newContext();
        page = context.newPage();
    }


    protected void startApiContext() {
        playwright = Playwright.create();
        apiRequest = playwright.request().newContext();
    }


    protected void tearDown() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }
}

