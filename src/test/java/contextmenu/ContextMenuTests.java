package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextMenuRightClickPrompt() {
        ContextMenuPage contextMenuPage = homePage.clickContextMenuPage();
        contextMenuPage.rightClickContextMenu();
        assertEquals(contextMenuPage.getAlertText(), "You selected a context menu", "Context menu text does not match");
        contextMenuPage.dismissAlert();
    }
}
