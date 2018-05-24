package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.Package;
import ba.unsa.etf.ppis.telekom.services.PackageService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class PackageController extends BaseController<Package, PackageService> {
    public void deactivate(@PathVariable("id") Long id) {
        Optional<Package> packageOptional = service.getById(id);
        if(packageOptional.isPresent()) {
            packageOptional.get().setStatus(Package.PackageStatus.Neaktivan);
            service.save(packageOptional.get());
        }
    }

}
