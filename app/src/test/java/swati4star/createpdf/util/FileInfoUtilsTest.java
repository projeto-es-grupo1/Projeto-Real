package swati4star.createpdf.util;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class FileInfoUtilsTest {

    @Test
    public void testGetFormattedDate() {
        File file = new File("sample.pdf");
        long lastModifiedTimestamp = 1622534400000L;
        file.setLastModified(lastModifiedTimestamp);

        String expectedDate = "Wed, Dec 31 at 21:00";

        String formattedDate = FileInfoUtils.getFormattedDate(file);
        Assert.assertEquals(expectedDate, formattedDate);
    }

    @Test
    public void testGetFormattedSize() {
        File file;
        try {
            file = File.createTempFile("sample", ".pdf");
            File knownSizeFile = new File("path/to/known_size_file.pdf");
            Files.copy(knownSizeFile.toPath(), file.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String expectedSize = "5.00 MB";

        String formattedSize = FileInfoUtils.getFormattedSize(file);
        Assert.assertEquals(expectedSize, formattedSize);
    }

}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme
