package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.Service;
import ba.unsa.etf.ppis.telekom.services.ServiceForTelekomService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController extends BaseController<Service, ServiceForTelekomService>  {
}
