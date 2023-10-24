package swati4star.createpdf.util;

import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PrintDocumentAdapterHelper extends PrintDocumentAdapter {

    private File mFile;

    PrintDocumentAdapterHelper(File mFile) {
        this.mFile = mFile;
    }

    @Override
    public void onWrite(PageRange[] pages,
                        ParcelFileDescriptor destination,
                        CancellationSignal cancellationSignal,
                        WriteResultCallback callback) {
        try {
            InputStream input = new FileInputStream(mFile.getName());
            OutputStream output = new FileOutputStream(destination.getFileDescriptor());

            byte[] buf = new byte[1024];
            int bytesRead;

            while ((bytesRead = input.read(buf)) > 0)
                try {
                    output.write(buf, 0, bytesRead);
                } catch (IOException e) {
                    System.out.println("Error writing to destination file: " + e.getMessage());
                }

            callback.onWriteFinished(new PageRange[]{PageRange.ALL_PAGES});

            try {
                input.close();
            } catch (IOException e) {
                System.out.println("Error closing the InputStream: " + e.getMessage());
            }

            try {
                output.close();
            } catch (IOException e) {
                System.out.println("Error closing the OutputStream: " + e.getMessage());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("Security error: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("Null pointer error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void onLayout(PrintAttributes oldAttributes,
                         PrintAttributes newAttributes,
                         CancellationSignal cancellationSignal,
                         LayoutResultCallback callback,
                         Bundle extras) {

        if (cancellationSignal.isCanceled()) {
            callback.onLayoutCancelled();
            return;
        }

        PrintDocumentInfo pdi = new PrintDocumentInfo.Builder("myFile")
                .setContentType(PrintDocumentInfo.CONTENT_TYPE_DOCUMENT)
                .build();

        callback.onLayoutFinished(pdi, true);
    }

}
