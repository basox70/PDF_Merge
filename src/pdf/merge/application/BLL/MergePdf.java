package pdf.merge.application.BLL;


import java.io.*;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class MergePdf {

	@SuppressWarnings("deprecation")
	public static void Merge(File[] fileList, String Destination) throws IOException{
        PDFMergerUtility ut = new PDFMergerUtility();
        
        // adding files from fileList
        for (int i = 0; i < fileList.length; i++) {
        	ut.addSource(fileList[i].getPath());
        }
        
        ut.setDestinationFileName(Destination);
    	ut.mergeDocuments();

        System.out.println("Les fichiers ont bien étés fusionnés.");
    }
    
}
