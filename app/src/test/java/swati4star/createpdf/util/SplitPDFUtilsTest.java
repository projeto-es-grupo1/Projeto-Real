package swati4star.createpdf.util;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SplitPDFUtilsTest {

    @Test
    public void testCheckRangeValidityWithValidRange() {
        int numOfPages = 10;
        String[] ranges = {"2", "4-7"};
        int result = SplitPDFUtils.checkRangeValidity(numOfPages, ranges);
        assertEquals(0, result);
    }

    @Test
    public void testCheckRangeValidityWithInvalidRange() {
        int numOfPages = 10;
        String[] ranges = {"0", "11", "3-2"};
        int result = SplitPDFUtils.checkRangeValidity(numOfPages, ranges);
        assertEquals(1, result);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
