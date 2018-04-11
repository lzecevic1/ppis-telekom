package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/new")
    public void createSupplier(@RequestBody Supplier supplier) {
        supplierService.createSupplier(supplier);
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
    public void deleteSupplier(@PathVariable("id") Long id) {
        Supplier supplier = supplierService.findById(id);
        if(supplier != null) {
            supplierService.delete(supplier);
        }
    }
}
