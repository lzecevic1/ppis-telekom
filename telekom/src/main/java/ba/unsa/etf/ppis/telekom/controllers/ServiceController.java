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

    public Collection<Service> all() {
        return service.getAll();
    }

    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Service> s = service.getById(id);
        if (!s.isPresent())
            return ResponseEntity.notFound().build();
        else
            return ResponseEntity.ok(s);
    }

    public ResponseEntity create(@RequestBody @Valid ServiceDTO serviceDTO) {
        Service createdService = service.createService(serviceDTO);
        if (createdService == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(createdService);
    }

    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Valid ServiceUpdateDTO serviceUpdateDTO) {
        service.updateService(id, serviceUpdateDTO);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
