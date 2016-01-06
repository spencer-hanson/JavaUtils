package spencer.hanson.modules;

import spencer.hanson.UtilModule;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by spencerh on 1/5/2016.
 */
public class UnZipper extends UtilModule {


        public final static void unpack(File zipFile, File rootDir)
                throws IOException {
            ZipFile zip = new ZipFile(zipFile);
            @SuppressWarnings("unchecked")
            Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>) zip.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                java.io.File f = new java.io.File(rootDir, entry.getName());
                if (entry.isDirectory()) { // if its a directory, create it
                    continue;
                }

                if (!f.exists()) {
                    f.getParentFile().mkdirs();
                    f.createNewFile();
                }

                InputStream is = zip.getInputStream(entry); // get the input stream
                OutputStream os = new java.io.FileOutputStream(f);
                byte[] buf = new byte[4096];
                int r;
                while ((r = is.read(buf)) != -1) {
                    os.write(buf, 0, r);
                }
                os.close();
                is.close();
            }
        }


    @Override
    public void run() {
        String sourceDir = "testPath/test.zip";
        String destDir = "testPath/";
        //////////

        //System.out.println("Enter a zipfile");
        //String dir = getStr();
        try {
            unpack(new File(sourceDir), new File(System.getProperty("user.dir") + "\\" + destDir));
        } catch(Exception e) { e.printStackTrace(); }
    }
}
