package qa.addressbook.appmanager

import org.openqa.selenium.By
import org.openqa.selenium.NoAlertPresentException
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver

class HelperBase {
    protected ApplicationManager manager
    protected WebDriver wd

    HelperBase(ApplicationManager manager) {
        this.manager = manager
        this.wd = manager.getWd()
    }

    void click(By locator) {
        wd.findElement(locator).click()
    }

    void type(By locator, String text) {
        click(locator)
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value")
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear()
                wd.findElement(locator).sendKeys(text)
            }
        }
    }

    void attach(By locator, File file) {
        if (file != null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath())
        }
    }

    boolean isAlertPresent() {
        try {
            wd.switchTo().alert()
            return true
        } catch (NoAlertPresentException e) {
            return false
        }
    }

    protected boolean isElementPresent(By locator) {
        try {
            wd.findElement(locator)
            return true
        } catch (NoSuchElementException ex) {
            return false
        }
    }
}
