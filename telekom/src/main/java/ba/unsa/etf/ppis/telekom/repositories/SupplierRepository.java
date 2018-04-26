package ba.unsa.etf.ppis.telekom.repositories;

import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
