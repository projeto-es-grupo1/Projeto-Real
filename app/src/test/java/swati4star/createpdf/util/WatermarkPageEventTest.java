package swati4star.createpdf.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;
import com.itextpdf.text.Font;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import swati4star.createpdf.model.Watermark;


public class WatermarkPageEventTest {
    @Mock
    Watermark mWatermark;

    @InjectMocks
    WatermarkPageEvent watermarkPageEvent;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSetWatermark() throws Exception {
        when(mWatermark.getWatermarkText()).thenReturn("getWatermarkTextResponse");
        when(mWatermark.getTextColor()).thenReturn(null);
        when(mWatermark.getTextSize()).thenReturn(0);
        when(mWatermark.getFontFamily()).thenReturn(Font.FontFamily.COURIER);
        when(mWatermark.getFontStyle()).thenReturn(2);

        watermarkPageEvent.setWatermark(new Watermark());

        Watermark storedWatermark = watermarkPageEvent.getWatermark();
        assertNotNull(storedWatermark);
        assertEquals(0, storedWatermark.getTextSize());
        assertNull(storedWatermark.getTextColor());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme