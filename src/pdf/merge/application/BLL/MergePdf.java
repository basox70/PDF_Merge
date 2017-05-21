package pdf.merge.application.BLL;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.*;

import java.io.*;
import java.net.URL;
import java.util.*;

import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.tools.PDFMerger;

public class MergePdf {

    public static void Merge(File[] fileList, String Destination) throws IOException{
        PDFMergerUtility ut = new PDFMergerUtility();
        
//        int totalPages = 0;
//
//        // Create writer for the outputStream
//        PdfWriter writer = PdfWriter.getInstance(document, outputStream);
//
//        //Open document.
//        document.open();
//
//        //Contain the pdf data.
//        PdfContentByte pageContentByte = writer.getDirectContent();
//
//        PdfImportedPage pdfImportedPage;
//        int currentPdfReaderPage = 1;
//        java.util.Iterator<PdfReader> iteratorPDFReader = readers.iterator();

        // Iterate and process the reader list.
        for (int i = 0; i < fileList.length; i++) {
        	
        	ut.addSource(fileList[i].getPath());
        	
        }
        ut.setDestinationFileName(Destination);
    	ut.mergeDocuments();;

        System.out.println("Les fichiers ont bien étés fusionnés.");
    }
    
}
