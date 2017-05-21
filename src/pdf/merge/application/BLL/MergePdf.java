package pdf.merge.application.BLL;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergePdf {

    static List<URL> files = new ArrayList<URL>(Arrays.asList(
            MergePdf.class.getResource("/example-001.pdf"),
            MergePdf.class.getResource("/example-002.pdf"),
            MergePdf.class.getResource("/example-003.pdf")
    ));

    public static void main(String... args) throws IOException, DocumentException {
        Document document = new Document();
        PdfCopy copy = new PdfCopy(document, new FileOutputStream("merge-pdf-result.pdf"));

        document.open();
        for (URL file : files){
            PdfReader reader = new PdfReader(file);
            copy.addDocument(reader);
            copy.freeReader(reader);
            reader.close();
        }
        document.close();
    }
}
