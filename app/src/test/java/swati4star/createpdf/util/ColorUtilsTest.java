package swati4star.createpdf.util;

import android.graphics.Color;

import org.junit.Assert;
import org.junit.Test;

public class ColorUtilsTest {
    ColorUtils colorUtils = ColorUtils.getInstance();

    @Test
    public void testGetInstance() throws Exception {
        ColorUtils result = ColorUtils.getInstance();
        Assert.assertNotNull(result);
    }

    @Test
    public void testColorSimilarCheck_SameColor() {
        int color1 = Color.rgb(100, 100, 100);
        int color2 = Color.rgb(100, 100, 100);
        boolean result = colorUtils.colorSimilarCheck(color1, color2);
        Assert.assertTrue(result);
    }

    @Test
    public void testColorSimilarCheck_DifferentColor() {
        int color1 = Color.rgb(100, 100, 100);
        int color2 = Color.rgb(255, 0, 0);
        boolean result = colorUtils.colorSimilarCheck(color1, color2);
        Assert.assertFalse(result);
    }

    @Test
    public void testColorSimilarCheck_SimilarColor() {
        int color1 = Color.rgb(100, 100, 100);
        int color2 = Color.rgb(110, 110, 110);
        boolean result = colorUtils.colorSimilarCheck(color1, color2);
        Assert.assertTrue(result);
    }

    @Test
    public void testColorSimilarCheck_DissimilarColor() {
        int color1 = Color.rgb(100, 100, 100);
        int color2 = Color.rgb(100, 200, 200);
        boolean result = colorUtils.colorSimilarCheck(color1, color2);
        Assert.assertFalse(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme