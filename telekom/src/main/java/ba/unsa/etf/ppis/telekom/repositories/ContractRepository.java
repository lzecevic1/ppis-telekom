package ba.unsa.etf.ppis.telekom.repositories;

import ba.unsa.etf.ppis.telekom.models.Contract;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract, Long>{
    List<Contract> findAllBySupplier(Supplier supplier);
}
