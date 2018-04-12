package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.controllers.dto.ServiceDTO;
import ba.unsa.etf.ppis.telekom.controllers.dto.ServiceUpdateDTO;
import ba.unsa.etf.ppis.telekom.models.Service;
import ba.unsa.etf.ppis.telekom.repositories.ServiceRepository;

import java.util.Collection;


@org.springframework.stereotype.Service
public class ServiceForTelekomService extends BaseService<Service, ServiceRepository> {

    public Collection<Service> getAll() {
        return repository.findAll();
    }

    public Service createService(ServiceDTO serviceDTO) {
        Service service = repository.save(new Service(serviceDTO.serviceId, serviceDTO.type, serviceDTO.description,
                serviceDTO.price, serviceDTO.priority, serviceDTO.responsiblePerson, 0, 0, 0));
        return service;

    }

    public void updateService(Long id, ServiceUpdateDTO serviceUpdateDTO) {
        Service service = repository.getOne(id);
        service.setDescription(serviceUpdateDTO.description);
        service.setPrice(serviceUpdateDTO.price);
        service.setPriority(serviceUpdateDTO.priority);
        service.setResponsiblePerson(serviceUpdateDTO.responsiblePerson);
        repository.save(service);
    }
}
