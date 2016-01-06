package spencer.hanson.modules;

import spencer.hanson.UtilModule;

import java.io.*;

/**
 * Created by spencerh on 1/5/2016.
 */
public class LineCounter extends UtilModule {

    private int lineCount;


    private static String[] extensions = {".java"};

    public int countFile(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }

    public void scanDirectory(String dir) throws IOException {
        File folder = new File(dir);
        File[] list = folder.listFiles();
        for(int i = 0;i<list.length;i++) {
            if(list[i].isFile()) {
                for(int j = 0;j<extensions.length;j++) {
                    if(list[i].getName().endsWith(extensions[j])) {
                        int tmp = countFile(dir + "\\" + list[i].getName());
                        System.out.println(list[i].getName() + " " + tmp);
                        lineCount += tmp;
                    }
                }
            } else if(list[i].isDirectory()) {
                scanDirectory(dir + "\\" + list[i].getName());
            }
        }
    }

    @Override
    public void run() {
        String dir = ".";
        //////////
        lineCount = 0;
        println("Enter in a project directory");
        //dir = getStr();
        try {
            scanDirectory(System.getProperty("user.dir") + "\\" + dir);
        } catch(Exception e) { e.printStackTrace(); }

        println(lineCount);
    }
}
