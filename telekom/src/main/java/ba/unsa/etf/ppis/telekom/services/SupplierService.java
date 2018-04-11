package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.repositories.SupplierRepository;

import java.util.Optional;

public class SupplierService extends BaseService<Supplier, SupplierRepository> {
    public void saveSupplier(Supplier supplier) {
        repository.save(supplier);
    }

    public Supplier findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
