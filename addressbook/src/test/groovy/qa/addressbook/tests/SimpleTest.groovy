package qa.addressbook.tests

import org.testng.annotations.Test

class SimpleTest extends TestBase {

    @Test
    void testGroup() throws Exception {
        app.goTo().groupPage()
    }
}
