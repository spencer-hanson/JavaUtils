package spencer.hanson;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by spencerh on 1/5/2016.
 */
public class MassRenamer extends UtilModule {

    @Override
    public void run() {
        String appendStr = "";
        String prependStr = "";
        String renameFolder = "testPath";
        /////
        //println("Enter in a path for files to be renamed");
        //String input = getStr();
        String input = renameFolder;

        try {
            println("Renaming..");
            File folder = new File(input);
            for(File file : folder.listFiles()) {
                Path source = Paths.get(file.getAbsolutePath());
                if(!file.isDirectory()) {
                    String[] filenameArray = source.getFileName().toString().split("\\.");
                    String filename = filenameArray[0];
                    String extension = "";
                    if(filenameArray.length > 1) {
                        extension = filenameArray[1];
                    }

                    String name = prependStr + filename + appendStr + "." + extension;
                    Files.move(source, source.resolveSibling(name));
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
