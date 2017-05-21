package pdf.merge.application.BLL;

import java.io.*;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFEdit {
	public static void Edit(File[] fileList) {
		Document document = new Document();
		try {
			for (int i = 0; i < fileList.length; i++) {
				System.out.println(fileList[i].getName());
				PdfWriter.getInstance(document, new FileOutputStream(fileList[i].getAbsolutePath()));
				document.open();
				document.add(new Paragraph("Hello World"));
			}
		} catch (DocumentException de) {
			de.printStackTrace();
		} catch (IOException de) {
			de.printStackTrace();
		}

		document.close();
	}
}
