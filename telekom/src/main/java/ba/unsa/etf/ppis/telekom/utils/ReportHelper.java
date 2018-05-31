package ba.unsa.etf.ppis.telekom.utils;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportHelper {

    private final static String DATE_FORMAT = "dd-MM-YYYY HH:mm";
    private final static Integer FONT_SIZE = 18;
    private final static Integer NUM_HEADER_ROWS = 1;

    public static void initializeDocument (Document document, String documentTitle, String documentCreator) throws DocumentException {
        document.addTitle(documentTitle);
        document.addCreationDate();
        document.addCreator(documentCreator);
    }

    public static void addGeneralInfo(Document document, String title) throws DocumentException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Date now = new Date();
        String dateString = dateFormat.format(now);
        Paragraph paragraph = new Paragraph(dateString);
        paragraph.add(new Paragraph(title, new Font(Font.FontFamily.HELVETICA, FONT_SIZE, Font.BOLD)));
        paragraph.add(new Paragraph(" "));
        document.add(paragraph);
    }

    public static void setTableHeaders(PdfPTable table, List<String> headers) {
        for(String h : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(h));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            table.addCell(cell);
        }
        table.setHeaderRows(NUM_HEADER_ROWS);
    }

    public static void addRowToTable(PdfPTable table, List<String> values) {
        for(String v : values) {
            PdfPCell cell = new PdfPCell(new Phrase(v));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
    }

    public static void addEmptyRow(Document document) throws DocumentException {
        Paragraph paragraph = new Paragraph();
        paragraph.add(new Paragraph(" "));
        document.add(paragraph);
    }

    // remove temporary file from filesystem
    public static void deleteReportFile(String filepath) {
        File file = new File(filepath);
        if (file != null) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    file.delete();
                }
            }).start();
        }
    }

    public static ResponseEntity<byte[]> createResponse(String filepath) {
        FileInputStream fileStream;
        try {
            fileStream = new FileInputStream(new File(filepath));
            byte[] contents = IOUtils.toByteArray(fileStream);
            fileStream.close();
            ReportHelper.deleteReportFile(filepath);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
            return response;
        }
        catch (Exception e) {
            return error(e);
        }
    }

    @ResponseBody
    public static ResponseEntity error(Exception e) {
        Map<String, Map<String, String>> responseBody = new HashMap<>();
        Map<String, String> error = new HashMap<>();
        error.put("message", e.getMessage());
        responseBody.put("error", error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}