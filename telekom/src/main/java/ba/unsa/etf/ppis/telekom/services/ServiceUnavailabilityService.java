package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.ServiceUnavailablityPeriod;
import ba.unsa.etf.ppis.telekom.repositories.ServiceUnavailabilityPeriodRepository;
import org.springframework.stereotype.Service;

@Service
public class ServiceUnavailabilityService extends BaseService<ServiceUnavailablityPeriod, ServiceUnavailabilityPeriodRepository> {
}
