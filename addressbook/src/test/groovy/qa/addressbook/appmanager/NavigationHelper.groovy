package qa.addressbook.appmanager

import org.openqa.selenium.By

class NavigationHelper extends HelperBase {

    NavigationHelper(ApplicationManager manager) {
        super(manager)
    }

    void groupPage() {
        if (isElementPresent(By.tagName("h1"))
                && wd.findElement(By.tagName("h1")).getText().equals("Groups")
                && isElementPresent(By.name("new"))) {
            return
        } else {
            click(By.linkText("groups"))
        }
    }

    void homePage() {
        if (isElementPresent(By.id("maintable"))) {
            return
        } else {
            click(By.linkText("home"))
        }
    }
}
