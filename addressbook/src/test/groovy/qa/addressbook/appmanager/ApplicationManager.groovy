package qa.addressbook.appmanager

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.BrowserType

import java.util.concurrent.TimeUnit

class ApplicationManager {
    private final Properties properties
    WebDriver wd
    private String browser
    private SessionHelper sessionHelper
    private NavigationHelper navigationHelper

    ApplicationManager(String browser) {
        this.browser = browser
        properties = new Properties()
    }

    void init() throws IOException {
        String target = System.getProperty("target", "local")
        properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))))

        if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver()
        } else if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver()
        }

        wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS)
        wd.get(properties.getProperty("web.baseURL"))
        sessionHelper = new SessionHelper(this)
        sessionHelper.login(properties.getProperty("web.login"), properties.getProperty("web.password"))
    }

    void stop() {
        sessionHelper.logout()
        wd.quit()
    }

    NavigationHelper goTo() {
        navigationHelper ?: (navigationHelper = new NavigationHelper(this))
    }
}
