package qa.addressbook.appmanager

import org.openqa.selenium.By

class SessionHelper extends HelperBase {

    SessionHelper(ApplicationManager manager) {
        super(manager)
    }

    void login(String username, String password) {
        type(By.name("user"), username)
        type(By.name("pass"), password)
        click(By.xpath("//input[@value='Login']"))
    }

    void logout() {
        click(By.linkText("Logout"))
    }
}
