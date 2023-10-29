package swati4star.createpdf.util;

import android.content.Context;
import android.net.Uri;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

public class RealPathUtilTest {

    @Mock
    Context mContext;

    RealPathUtil realPathUtil = new RealPathUtil();

    @Test
    public void testGetInstance() throws Exception {
        RealPathUtil result = RealPathUtil.getInstance();
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetRealPath() throws Exception {
        Uri fileUri = Uri.parse("");
        String result = null;
        if (fileUri != null) {
            result = realPathUtil.getRealPath(mContext, fileUri);
        }
        Assert.assertNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme