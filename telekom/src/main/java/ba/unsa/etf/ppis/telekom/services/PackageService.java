package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.controllers.dto.TelekomServiceDTO;
import ba.unsa.etf.ppis.telekom.models.Package;
import ba.unsa.etf.ppis.telekom.models.TelekomService;
import ba.unsa.etf.ppis.telekom.repositories.PackageRepository;
import org.springframework.stereotype.Service;

@Service
public class PackageService extends BaseService<Package, PackageRepository> {

	public Package createService(Package p) {
		return repository.save(new Package(p.getName(),p.getDescription(),p.getPrice()));
	}
}
