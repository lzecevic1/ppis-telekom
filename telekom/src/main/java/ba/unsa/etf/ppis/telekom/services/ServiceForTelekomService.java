package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.controllers.dto.TelekomServiceDTO;
import ba.unsa.etf.ppis.telekom.controllers.dto.TelekomServiceUpdateDTO;
import ba.unsa.etf.ppis.telekom.models.TelekomService;
import ba.unsa.etf.ppis.telekom.repositories.TelekomServiceRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;


@Service
public class ServiceForTelekomService extends BaseService<TelekomService, TelekomServiceRepository> {

    public Collection<TelekomService> getAll() {
        return repository.findAll();
    }

    public TelekomService createService(TelekomServiceDTO telekomServiceDTO) {
        TelekomService telekomService = repository.save(new TelekomService(telekomServiceDTO.serviceId, telekomServiceDTO.type, telekomServiceDTO.description,
                telekomServiceDTO.price, telekomServiceDTO.priority, telekomServiceDTO.responsiblePerson, 0, 0, 0));
        return telekomService;

    }

    public void updateService(Long id, TelekomServiceUpdateDTO telekomServiceUpdateDTO) {
        TelekomService telekomService = repository.getOne(id);
        telekomService.setDescription(telekomServiceUpdateDTO.description);
        telekomService.setPrice(telekomServiceUpdateDTO.price);
        telekomService.setPriority(telekomServiceUpdateDTO.priority);
        telekomService.setResponsiblePerson(telekomServiceUpdateDTO.responsiblePerson);
        repository.save(telekomService);
    }
}
