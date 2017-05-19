
package pdf.merge.application.BLL;

import java.io.File;
import java.io.FilenameFilter;

public class FileFinder {
    public static File[] find (String path) {
        File dir = new File(path);
        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".pdf");
            }
        } );
    }
}