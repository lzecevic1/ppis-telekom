package ba.unsa.etf.ppis.telekom.repositories;

import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    List<Supplier> findAllByStatus(Supplier.SupplierStatus status);
    Supplier findSupplierByName(String name);
    List<Supplier> findAllByCategory(Supplier.SupplierCategory category);
    List<Supplier> findAllByCategoryAndStatus(Supplier.SupplierCategory category, Supplier.SupplierStatus status);

}
