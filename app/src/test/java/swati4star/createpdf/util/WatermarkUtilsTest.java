package swati4star.createpdf.util;

import static org.junit.Assert.assertEquals;
import com.itextpdf.text.Font;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;


public class WatermarkUtilsTest {

    @InjectMocks
    WatermarkUtils watermarkUtils;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetStyleValueFromName() throws Exception {
        int result = WatermarkUtils.getStyleValueFromName("name");
        assertEquals(0, result);
    }

    @Test
    public void testGetStyleNameFromFontBold() {
        int font = Font.BOLD;
        String expectedStyle = "BOLD";
        String actualStyle = watermarkUtils.getStyleNameFromFont(font);
        assertEquals(expectedStyle, actualStyle);
    }

    @Test
    public void testGetStyleNameFromFontItalic() {
        int font = Font.ITALIC;
        String expectedStyle = "ITALIC";
        String actualStyle = watermarkUtils.getStyleNameFromFont(font);
        assertEquals(expectedStyle, actualStyle);
    }

    @Test
    public void testGetStyleNameFromFontUnderline() {
        int font = Font.UNDERLINE;
        String expectedStyle = "UNDERLINE";
        String actualStyle = watermarkUtils.getStyleNameFromFont(font);
        assertEquals(expectedStyle, actualStyle);
    }

    @Test
    public void testGetStyleNameFromFontStrikethru() {
        int font = Font.STRIKETHRU;
        String expectedStyle = "STRIKETHRU";
        String actualStyle = watermarkUtils.getStyleNameFromFont(font);
        assertEquals(expectedStyle, actualStyle);
    }

    @Test
    public void testGetStyleNameFromFontBoldItalic() {
        int font = Font.BOLDITALIC;
        String expectedStyle = "BOLDITALIC";
        String actualStyle = watermarkUtils.getStyleNameFromFont(font);
        assertEquals(expectedStyle, actualStyle);
    }

    @Test
    public void testGetStyleNameFromFontDefault() {
        int font = Font.NORMAL; // Qualquer valor diferente dos anteriores
        String expectedStyle = "NORMAL";
        String actualStyle = watermarkUtils.getStyleNameFromFont(font);
        assertEquals(expectedStyle, actualStyle);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme