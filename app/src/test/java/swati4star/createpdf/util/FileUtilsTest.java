package swati4star.createpdf.util;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;

public class FileUtilsTest {
    @Mock
    Activity mContext;
    @Mock
    SharedPreferences mSharedPreferences;
    @InjectMocks
    FileUtils fileUtils;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetFileName() throws Exception {
        String result = FileUtils.getFileName("/path/to/your/file.txt");
        Assert.assertEquals("file.txt", result);
    }

    @Test
    public void testGetFileNameWithoutExtension() throws Exception {
        String result = FileUtils.getFileNameWithoutExtension("/path/to/your/file.pdf");
        Assert.assertEquals("file", result);
    }

    @Test
    public void testGetFileDirectoryPath() throws Exception {
        String result = FileUtils.getFileDirectoryPath("/path/to/your/file.txt");
        Assert.assertEquals("/path/to/your/", result);
    }

    @Test
    public void testGetUriRealPath() throws Exception {
        String result = fileUtils.getUriRealPath(null);
        Assert.assertEquals(null, result);
    }


    @Test
    public void testGetLastFileName() throws Exception {
        String result = fileUtils.getLastFileName(new ArrayList<String>(Arrays.asList("/file1.pdf",
                "/file2.pdf", "/file3.pdf"))).replace("null", "");;
        Assert.assertEquals("file3", result);
    }

    @Test
    public void testStripExtension() throws Exception {
        String result = fileUtils.stripExtension("fileNameWithExt.txt");
        Assert.assertEquals("fileNameWithExt", result);
    }

    @Test
    public void testGetFileChooser() throws Exception {
        Intent result = fileUtils.getFileChooser();
        Assert.assertNull(result);
    }

    @Test
    public void testGetMultipleFileChooser() throws Exception {
        Intent result = fileUtils.getMultipleFileChooser();
        Assert.assertNull(result);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme