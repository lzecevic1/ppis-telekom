package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.services.SupplierService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

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

    public ResponseEntity averageRating(@PathVariable Long id) {
        Float avgRating = service.averageRatingForSupplier(id);
        return ResponseEntity.ok(avgRating);
    }

    public void deactivate(@PathVariable("id") Long id) {
        Optional<Supplier> supplierForUpdate = service.getById(id);
        if(supplierForUpdate.isPresent()) {
            supplierForUpdate.get().setStatus(Supplier.SupplierStatus.Neaktivan);
            service.save(supplierForUpdate.get());
        }
    }
}
