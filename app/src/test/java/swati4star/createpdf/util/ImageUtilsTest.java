package swati4star.createpdf.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import android.graphics.Bitmap;
import com.afollestad.materialdialogs.MaterialDialog;
import com.itextpdf.text.Rectangle;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


public class ImageUtilsTest {
    @InjectMocks
    private ImageUtils mUtils;

    @Mock
    private MaterialDialog.Builder mBuilder;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetInstance() {
        ImageUtils instance1 = ImageUtils.getInstance();
        ImageUtils instance2 = ImageUtils.getInstance();
        assertSame(instance1, instance2);
    }

    @Test
    public void testCalculateFitSize() {
        Rectangle fitSize = ImageUtils.calculateFitSize(800, 600, new Rectangle(400, 300));
        assertEquals(400f, fitSize.getWidth(), 0.01);
        assertEquals(300f, fitSize.getHeight(), 0.01);
    }

    @Test
    public void testGetRoundBitmapNull() {
        Bitmap inputBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        Bitmap roundBitmap = null;
        if (inputBitmap != null) {
            roundBitmap = mUtils.getRoundBitmap(inputBitmap);
        }
        assertNull(roundBitmap);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme