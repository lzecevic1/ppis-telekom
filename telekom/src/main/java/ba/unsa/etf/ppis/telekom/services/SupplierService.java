package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.repositories.ContractRepository;
import ba.unsa.etf.ppis.telekom.repositories.SupplierRepository;
import ba.unsa.etf.ppis.telekom.utils.ReportHelper;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.*;

@Service
public class SupplierService extends BaseService<Supplier, SupplierRepository> {

    @Autowired
    RatingService ratingService;

    @Autowired
    ContractRepository contractRepository;

    private final String REPORT_FILENAME = "dobavljaci";
    private final String REPORT_FILE_EXTENSION = ".pdf";
    private final String REPORT_TITLE = "DOBAVLJACI";
    private final String REPORT_CREATOR = "HVC";
    private final Integer SUPPLIER_TABLE_NUM_COLUMNS = 8;

    @Transactional
    public void addRatingForSupplier(Rating rating, Long supplierId) {
        Optional<Supplier> supplier = repository.findById(supplierId);
        if(!supplier.isPresent()) {
            throw new RuntimeException("Supplier with given id doesn't exist");
        }
        rating.setSupplier(supplier.get());
        ratingService.save(rating);
    }

    public Float averageRatingForSupplier(Long id, int i) {
        Optional<Supplier> supplier = repository.findById(id);
        if(!supplier.isPresent()) {
            throw new RuntimeException("Supplier with given id doesn't exist");
        }
        Float avgRating = 0f;
        Collection<Rating> ratings = supplier.get().getRatings();
        Integer size = 0;
        for (Rating r: ratings) {
            if(i == 3){
                avgRating += r.getRating();
                size++;}
            else {
                if(r.getRatingType().ordinal() == i) {
                    avgRating += r.getRating();
                    size++;
                }
            }
        }
        if(size == 0) {
            return 0f;
        }
        else
            avgRating /= size;
        return avgRating;
    }

    public Supplier findSupplierByName(String name) {
        Supplier supplier = repository.findSupplierByName(name);
        return  supplier;
    }

    public List<Supplier> filter(Supplier.SupplierStatus status) {
        return repository.findAllByStatus(status);
    }

    public List<Supplier> sortByRating(Integer ratingType, Integer supplierCategory, boolean filterActive) {
        List<Supplier> allSuppliers;
        if ((supplierCategory == null || supplierCategory == 4) && !filterActive)
            allSuppliers = repository.findAll();
        else if (!filterActive)
            allSuppliers = repository.findAllByCategory(integerToSupplierCategory(supplierCategory));
        else
            allSuppliers = repository.findAllByCategoryAndStatus(integerToSupplierCategory(supplierCategory),
                    Supplier.SupplierStatus.Aktivan);
        Collections.sort(allSuppliers, new SortByRating(integerToRatingType(ratingType)));
        return allSuppliers;
    }

    private Rating.RatingType integerToRatingType(int i) {
        Rating.RatingType ratingType = null;
        switch (i){
            case 0: ratingType = Rating.RatingType.QUALITY; break;
            case 1: ratingType = Rating.RatingType.DELIVERY_SPEED; break;
            case 2: ratingType = Rating.RatingType.COMMUNICATION; break;
            case 3: ratingType = Rating.RatingType.OVERALL_RATING;
        }
        return ratingType;
    }

    private Supplier.SupplierCategory integerToSupplierCategory(int i) {
        Supplier.SupplierCategory category= null;
        switch (i){
            case 0: category = Supplier.SupplierCategory.Telefonija; break;
            case 1: category = Supplier.SupplierCategory.Mobilni_uredjaji; break;
            case 2: category = Supplier.SupplierCategory.Mrezna_oprema; break;
            case 3: category = Supplier.SupplierCategory.Ostalo;
        }
        return category;
    }

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
            addSupplierTable(document, true);
            document.close();
            file.close();
            return reportFilename;
        } catch (Exception e) {
            return null;
        }
    }

    private void addSupplierTable(Document document, boolean isActive) throws DocumentException {
        List<Supplier> suppliers = repository.findAll();
        suppliers.sort(new SortByRating(Rating.RatingType.OVERALL_RATING));
        PdfPTable pdfTable = new PdfPTable(SUPPLIER_TABLE_NUM_COLUMNS);
        ReportHelper.setTableHeaders(pdfTable, Arrays.asList("Naziv", "Adresa", "Status", "Kategorija",
                "Ocjena kvaliteta","Ocjena brzine isporuke", "Ocjena komukacije", "Prosjecna ocjena"));
        for (Supplier s : suppliers) {
           // Integer numContracts = contractRepository.countBySupplierAndIsActive(s, isActive);
            Float avgRating = averageRatingForSupplier(s.getId(), 3);
            avgRating = round(avgRating, 2);
            Float qualityRating = averageRatingForSupplier(s.getId(), 0);
            Float speedRating = averageRatingForSupplier(s.getId(), 1);
            Float commRating = averageRatingForSupplier(s.getId(), 2);
            String category = getFormattedCategory(s.getCategory());
            ReportHelper.addRowToTable(pdfTable, Arrays.asList(s.getName(), s.getAddress(), s.getStatus().toString(),
                    category, qualityRating.toString(), speedRating.toString(),
                    commRating.toString(), avgRating.toString()));
        }
        document.add(pdfTable);
    }



    private String getFormattedCategory(Supplier.SupplierCategory category) {
        String strCat;
        switch (category) {
            case Mobilni_uredjaji: strCat = "Mobilni uredjaji"; break;
            case Mrezna_oprema: strCat = "Mrezna oprema"; break;
            default: strCat = category.toString();
        }
        return strCat;
    }

    public static float round(float d, int decimalPlace) {
        BigDecimal bd = new BigDecimal(Float.toString(d));
        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
        return bd.floatValue();
    }

}

class SortByRating implements Comparator<Supplier> {

    private Rating.RatingType ratingType;

    SortByRating(Rating.RatingType ratingType) {
        this.ratingType = ratingType;
    }

    @Override
    public int compare(Supplier s1, Supplier s2) {
        return averageRating(s2).compareTo(averageRating(s1));
    }

    private Float averageRating(Supplier s) {
        Float avgRating = 0f;
        Integer counter = 0;
        for (Rating r : s.getRatings()) {
            if (ratingType == Rating.RatingType.OVERALL_RATING || r.getRatingType() == ratingType) {
                avgRating += r.getRating();
                counter++;
            }
        }
        if (counter > 0)
            return avgRating / counter;
        else return 0f;
    }

}


