package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class SupplierController extends BaseController<Supplier, SupplierService>  {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/new")
    public void createSupplier(@RequestBody Supplier supplier) {
        supplierService.saveSupplier(supplier);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void deleteSupplier(@PathVariable("id") Long id) {
        Supplier supplier = supplierService.findById(id);
        if(supplier != null) {
            supplierService.delete(supplier);
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void updateSupplier(@RequestBody Supplier supplier) {
        Supplier supplierForUpdate = supplierService.findById(supplier.getId());
        if(supplierForUpdate != null) {
            updateSupplier(supplier, supplierForUpdate);
            supplierService.saveSupplier(supplierForUpdate);
        }
    }

    @GetMapping(value = "/find/{id}")
    public Supplier getSupplierById(@PathVariable("id") Long id) {
        return supplierService.findById(id);
    }

    private void updateSupplier(@RequestBody Supplier supplier, Supplier supplierForUpdate) {
        supplierForUpdate.setAddress(supplier.getAddress());
        supplierForUpdate.setCategory(supplier.getCategory());
        supplierForUpdate.setContracts(supplier.getContracts());
        supplierForUpdate.setName(supplier.getName());
        supplierForUpdate.setRatings(supplier.getRatings());
        supplierForUpdate.setStatus(supplier.getStatus());
    }
}
