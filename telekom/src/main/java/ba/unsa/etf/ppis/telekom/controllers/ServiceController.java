package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.controllers.dto.ServiceDTO;
import ba.unsa.etf.ppis.telekom.controllers.dto.ServiceUpdateDTO;
import ba.unsa.etf.ppis.telekom.models.Service;
import ba.unsa.etf.ppis.telekom.services.ServiceForTelekomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@RestController
public class ServiceController extends BaseController<Service, ServiceForTelekomService> {

    public Collection<Service> getAll() {
        return service.getAll();
    }

    public Optional<Service> getServiceById(@PathVariable("id") Long id) {
        return service.getById(id);
    }

    public ResponseEntity createService(@RequestBody @Valid ServiceDTO serviceDTO) {
        Service createdService = service.createService(serviceDTO);
        return ResponseEntity.ok(createdService);
    }

    public ResponseEntity updateService(@PathVariable("id") Long id, @RequestBody @Valid ServiceUpdateDTO serviceUpdateDTO) {
        service.updateService(id, serviceUpdateDTO);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity deleteService(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
