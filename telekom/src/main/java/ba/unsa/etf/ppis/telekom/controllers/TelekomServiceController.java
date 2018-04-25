package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.controllers.dto.TelekomServiceDTO;
import ba.unsa.etf.ppis.telekom.controllers.dto.TelekomServiceUpdateDTO;
import ba.unsa.etf.ppis.telekom.models.TelekomService;
import ba.unsa.etf.ppis.telekom.services.ServiceForTelekomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TelekomServiceController extends BaseController<TelekomService, ServiceForTelekomService> {

    public ResponseEntity create(@RequestBody @Valid TelekomServiceDTO telekomServiceDTO) {
        TelekomService createdTelekomService = service.createService(telekomServiceDTO);
        if (createdTelekomService == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(createdTelekomService);
    }

    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody @Valid TelekomServiceUpdateDTO telekomServiceUpdateDTO) {
        service.updateService(id, telekomServiceUpdateDTO);
        return ResponseEntity.ok().build();
    }

}
