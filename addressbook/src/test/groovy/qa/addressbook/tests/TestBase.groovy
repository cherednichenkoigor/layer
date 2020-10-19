package qa.addressbook.tests

import org.openqa.selenium.remote.BrowserType
import org.testng.annotations.AfterSuite
import org.testng.annotations.BeforeSuite
import qa.addressbook.appmanager.ApplicationManager

class TestBase {
    protected static final ApplicationManager app = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME))

    @BeforeSuite(alwaysRun = true)
    void setUp() throws Exception {
        app.init()
    }

    @AfterSuite(alwaysRun = true)
    void tearDown() throws Exception {
        app.stop()
    }
}
