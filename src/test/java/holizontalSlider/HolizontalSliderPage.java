package holizontalSlider;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;

public class HolizontalSliderPage extends BaseTests {

    @Test
    public void testIncreaseSliderValue() {
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSliderPage();

        horizontalSliderPage.setSliderValue(2.0);
        assertEquals(horizontalSliderPage.getSliderValue(), 2.0);

        horizontalSliderPage.setSliderValue(5.0);
        assertEquals(horizontalSliderPage.getSliderValue(), 5.0);

        horizontalSliderPage.setSliderValue(0.0);
        assertEquals(horizontalSliderPage.getSliderValue(), 0.0);


    }
}
