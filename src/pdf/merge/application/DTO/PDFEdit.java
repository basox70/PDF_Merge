package pdf.merge.application.DTO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class PDFEdit {
	public static void Edit(String absolutePath) throws IOException, DocumentException {

		/* example inspired from "iText in action" (2006), chapter 2 */

		PdfReader reader = new PdfReader(absolutePath); // input PDF
		PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(absolutePath + "_modified.pdf")); // output
																											// PDF
		BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED); // set
																										// font

		// loop on pages (1-based)
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {

			// get object for writing over the existing content;
			// you can also use getUnderContent for writing in the bottom layer
			PdfContentByte over = stamper.getOverContent(i);

			String timeStamp = new SimpleDateFormat("dd/MM/YYYY").format(Calendar.getInstance().getTime());
			// write text
			over.beginText();
			over.setFontAndSize(bf, 10);
			over.setTextMatrix(10, 20);
			over.showText(timeStamp);
			over.setTextMatrix(10, 10);
			over.showText("Page : " + i);
			over.endText();
		}

		stamper.close();

	}
}
