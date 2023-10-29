package swati4star.createpdf.util;


import android.content.Context;
import android.net.Uri;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class FileUriUtilsTest {
    private final FileUriUtils mInstance = FileUriUtils.getInstance();

    @Mock
    private Context mContext;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetInstance() throws Exception {
        FileUriUtils result = FileUriUtils.getInstance();
        Assert.assertNotNull(result);
    }

    @Test
    public void testIsWhatsappImageInvalid() throws Exception {
        boolean result = mInstance.isWhatsappImage("content://com.whatsapp.provider.media/item/1234");
        Assert.assertFalse(result);
    }

    @Test
    public void testIsWhatsappImageValid() throws Exception {
        boolean result = mInstance.isWhatsappImage("com.whatsapp.provider.media");
        Assert.assertTrue(result);
    }

    @Test
    public void testGetUriRealPathAboveKitkat() throws Exception {
        Uri imageUri = Uri.parse("content://media/external/images/media/5678");
        String result = mInstance.getUriRealPathAboveKitkat(mContext, imageUri);
        Assert.assertNull(result);
    }

    @Test
    public void testGetFilePath() throws Exception {
        Uri fileUri = Uri.parse("file:///storage/emulated/0/Documents/example.txt");
        if (fileUri != null) {
            String result = mInstance.getFilePath(fileUri);
            Assert.assertEquals("/storage/emulated/0/Documents/example.txt", result);
        }
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
