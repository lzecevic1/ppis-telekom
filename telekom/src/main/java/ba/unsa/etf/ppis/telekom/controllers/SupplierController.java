package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.controllers.dto.SupplierDTO;
import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.services.SupplierService;
import ba.unsa.etf.ppis.telekom.utils.ReportHelper;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.File;
import java.io.FileInputStream;
import java.util.*;

@RestController
public class SupplierController extends BaseController<Supplier, SupplierService>  {

    public void update(@RequestBody Supplier supplier) {
        Optional<Supplier> supplierForUpdate = service.getById(supplier.getId());
        if(supplierForUpdate.isPresent()) {
            updateSupplier(supplier, supplierForUpdate.get());
            service.save(supplierForUpdate.get());
        }
    }

    private void updateSupplier(@RequestBody Supplier supplier, Supplier supplierForUpdate) {
        supplierForUpdate.setAddress(supplier.getAddress());
        supplierForUpdate.setCategory(supplier.getCategory());
        supplierForUpdate.setContracts(supplier.getContracts());
        supplierForUpdate.setName(supplier.getName());
        supplierForUpdate.setRatings(supplier.getRatings());
        supplierForUpdate.setStatus(supplier.getStatus());
    }

    public ResponseEntity addRating(@PathVariable Long id, @RequestBody @Valid Rating rating) {
        service.addRatingForSupplier(rating, id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity averageRating(@PathVariable Long id,@PathVariable Integer ratingType) {
        Float avgRating = service.averageRatingForSupplier(id,ratingType);
        return ResponseEntity.ok(avgRating);
    }

    public ResponseEntity filter(@RequestParam Supplier.SupplierStatus status) {
        List<Supplier> activeSuppliers = service.filter(status);
        List<SupplierDTO> supplierDTOList = new ArrayList<>();
        for (Supplier s : activeSuppliers)
            supplierDTOList.add(new SupplierDTO(s));
        return ResponseEntity.ok(supplierDTOList);
    }

    public ResponseEntity sortByRating(@RequestParam Integer ratingType) {
        List<Supplier> sortedSuppliers = service.sortByRating(ratingType);
        List<SupplierDTO> supplierDTOList = new ArrayList<>();
        for (Supplier s : sortedSuppliers)
            supplierDTOList.add(new SupplierDTO(s));
        return ResponseEntity.ok(supplierDTOList);
    }

    @Override
    public ResponseEntity all() {
        Collection<Supplier> suppliers = service.all();
        List<SupplierDTO> supplierDTOList = new ArrayList<>();
        for (Supplier s : suppliers)
            supplierDTOList.add(new SupplierDTO(s));
        return ResponseEntity.ok(supplierDTOList);

    }


    public void deactivate(@PathVariable("id") Long id) {
        Optional<Supplier> supplierForUpdate = service.getById(id);
        if(supplierForUpdate.isPresent()) {
            supplierForUpdate.get().setStatus(Supplier.SupplierStatus.Neaktivan);
            service.save(supplierForUpdate.get());
        }
    }

    public ResponseEntity<byte[]> generateReport() {
        try {
            String filepath = service.generateReport();
            return ReportHelper.createResponse(filepath);
        } catch (Exception e) {
            return ReportHelper.error(e);
        }
    }

}
