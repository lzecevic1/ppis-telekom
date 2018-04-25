package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.Contract;
import ba.unsa.etf.ppis.telekom.services.ContractService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContractController extends BaseController<Contract, ContractService> {
}
