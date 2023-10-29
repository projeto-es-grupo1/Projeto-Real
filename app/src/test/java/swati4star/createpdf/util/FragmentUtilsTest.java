package swati4star.createpdf.util;

import android.content.Context;

import androidx.fragment.app.Fragment;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import swati4star.createpdf.R;
import swati4star.createpdf.fragment.texttopdf.TextToPdfFragment;

public class FragmentUtilsTest {
    @Mock
    Context mContext;
    @InjectMocks
    FragmentUtils fragmentUtils;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFragmentName_Default() {
        Fragment fragment = new TextToPdfFragment();
        String result = fragmentUtils.getFragmentName(fragment);
        Assert.assertEquals(mContext.getString(R.string.app_name), result);
    }

    @Test
    public void testGetFragmentName_Null() {
        TextToPdfFragment fragment = new TextToPdfFragment();
        String result = fragmentUtils.getFragmentName(fragment);
        Assert.assertNull(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme