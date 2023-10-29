package swati4star.createpdf.util;

import org.junit.Assert;
import org.junit.Test;

public class ResultUtilsTest {
    ResultUtils resultUtils = ResultUtils.getInstance();

    @Test
    public void testGetInstance() throws Exception {
        ResultUtils result = ResultUtils.getInstance();
        Assert.assertNotNull(result);
    }

    @Test
    public void testCheckResultValidity() throws Exception {
        boolean result = resultUtils.checkResultValidity(0, null);
        Assert.assertFalse(result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme