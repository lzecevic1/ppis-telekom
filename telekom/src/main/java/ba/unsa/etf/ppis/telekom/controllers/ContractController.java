package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.controllers.dto.ContractDTO;
import ba.unsa.etf.ppis.telekom.models.Contract;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.services.ContractService;
import ba.unsa.etf.ppis.telekom.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class ContractController extends BaseController<Contract, ContractService> {

    @Autowired
    SupplierService supplierService;

    @Autowired
    ContractService contractService;

    public ResponseEntity create(@RequestBody ContractDTO contractDTO) {
        Optional<Supplier> supplier = supplierService.getById(contractDTO.supplierId);
        Contract contract = new Contract(contractDTO.startDate, contractDTO.endDate, contractDTO.price,
                contractDTO.deliveryAddress, contractDTO.dueDatePayment, contractDTO.dueDateDelivery,contractDTO.responsiblePerson, supplier.get(), true);
        contractService.save(contract);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity deactivate(@PathVariable Long id) {
        Optional<Contract> contract = contractService.getById(id);
        contract.get().setActive(false);
        contractService.save(contract.get());
        return ResponseEntity.ok().build();
    }

}
