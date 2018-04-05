package ba.unsa.etf.ppis.telekom.repositories;

import ba.unsa.etf.ppis.telekom.models.ServiceUnavailablityPeriod;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceUnavailabilityPeriodRepository extends JpaRepository<ServiceUnavailablityPeriod, Long> {
}
