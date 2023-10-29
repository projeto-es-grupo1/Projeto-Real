package swati4star.createpdf.util;


import org.junit.Assert;
import org.junit.Test;

public class PermissionsUtilsTest {

    PermissionsUtils permissionsUtils = new PermissionsUtils();

    @Test
    public void testGetInstance() throws Exception {
        PermissionsUtils result = PermissionsUtils.getInstance();
        Assert.assertNotNull(result);
    }

    @Test
    public void testCheckRuntimePermissions() throws Exception {
        boolean result = permissionsUtils.checkRuntimePermissions("context", new String[]{"permissions"});
        Assert.assertEquals(true, result);
    }

    @Test
    public void testRequestRuntimePermissions() throws Exception {
        permissionsUtils.requestRuntimePermissions("context", new String[]{"permissions"}, 0);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme