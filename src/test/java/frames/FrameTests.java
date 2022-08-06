package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.WysiwygEditorPage;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg() {
        WysiwygEditorPage wysiwygEditorPage = homePage.clickWysiwygEditorPage();
        wysiwygEditorPage.clearTextArea();

        String text1 = "hello ";
        String text2 = "world";

        wysiwygEditorPage.setTextArea(text1);
        wysiwygEditorPage.increaseIndent();
        wysiwygEditorPage.setTextArea(text2);

        assertEquals(wysiwygEditorPage.getTextFromEditor(), text1 + text2, "Text from editor is incorrect");
    }
}
