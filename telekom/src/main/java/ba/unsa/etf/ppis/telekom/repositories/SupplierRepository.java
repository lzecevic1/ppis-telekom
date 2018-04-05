package ba.unsa.etf.ppis.telekom.repositories;

import ba.unsa.etf.ppis.telekom.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
