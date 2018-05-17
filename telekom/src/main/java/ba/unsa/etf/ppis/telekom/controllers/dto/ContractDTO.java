package ba.unsa.etf.ppis.telekom.controllers.dto;

import java.util.Date;

public class ContractDTO {
    public Long supplierId;
    public String responsiblePerson;
    public Date startDate;
    public Date endDate;

    public ContractDTO(Long id, String responsiblePerson, Date startDate, Date endDate) {
        this.supplierId = id;
        this.responsiblePerson = responsiblePerson;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public ContractDTO() {
    }
}
