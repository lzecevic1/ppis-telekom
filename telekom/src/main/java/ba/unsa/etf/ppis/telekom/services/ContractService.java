package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.Contract;
import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.repositories.ContractRepository;
import ba.unsa.etf.ppis.telekom.utils.ReportHelper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class ContractService extends BaseService<Contract, ContractRepository> {

    static final long ONE_MINUTE_IN_MILLIS=60000;
    private final String REPORT_FILENAME = "ugovorii";
    private final String REPORT_FILE_EXTENSION = ".pdf";
    private final String REPORT_TITLE = "UGOVORI";
    private final String REPORT_CREATOR = "HVC";
    private final Integer CONTRACT_TABLE_NUM_COLUMNS = 6;

    public String generateReport() {
        try {
            String reportFilename = REPORT_FILENAME + Math.random() + REPORT_FILE_EXTENSION;
            OutputStream file = new FileOutputStream(new File(reportFilename));
            Document document = new Document(PageSize.A4.rotate());
            PdfWriter.getInstance(document, file);
            document.open();
            ReportHelper.initializeDocument(document, REPORT_TITLE, REPORT_CREATOR);
            ReportHelper.addGeneralInfo(document, REPORT_TITLE);
            ReportHelper.addEmptyRow(document);
            addContractsTable(document);
            document.close();
            file.close();
            return reportFilename;
        } catch (Exception e) {
            return null;
        }
    }

    private void addContractsTable(Document document) throws DocumentException{
        List<Contract> contracts = repository.findAll();
        // contracts.sort(new SortByRating(Rating.RatingType.OVERALL_RATING));
        PdfPTable pdfTable = new PdfPTable(CONTRACT_TABLE_NUM_COLUMNS);
        ReportHelper.setTableHeaders(pdfTable, Arrays.asList("Dobavljac", "Pocetak ugovora", "Kraj ugovora", "Cijena",
                "Odgovorna osoba","Status"));
        for (Contract c : contracts) {
            ReportHelper.addRowToTable(pdfTable, Arrays.asList(c.getSupplier().getName(), c.getStartDateString(),
                    c.getEndDateString(), c.getPrice().toString(), c.getResponsiblePerson(), c.isActive() ? "Aktivan" : "Neaktivan"));
        }
        document.add(pdfTable);
    }

    private String getFormattedDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM");
        return dateFormat.format(date);
    }

    private String getFormattedTime(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("hh:mm");
        return dateFormat.format(date);
    }

    private String getDayFromDate(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("EEEE");
        return dateFormat.format(date);
    }

}
