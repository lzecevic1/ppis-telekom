package ba.unsa.etf.ppis.telekom.controllers.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ContractDTO {
    public Long supplierId;
    public String contractNumber;
    public String responsiblePerson;
    public Date startDate;
    public Date endDate;
    public BigDecimal price;
    public String deliveryAddress;
    public Date dueDatePayment;
    public Date dueDateDelivery;

    public ContractDTO(Long id, String contractNumber, String responsiblePerson, Date startDate, Date endDate, BigDecimal price, String deliveryAddress, Date dueDatePayment, Date dueDateDelivery) {
        this.supplierId = id;
        this.contractNumber = contractNumber;
        this.responsiblePerson = responsiblePerson;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.deliveryAddress = deliveryAddress;
        this.dueDatePayment = dueDatePayment;
        this.dueDateDelivery = dueDateDelivery;
    }

    public ContractDTO() {
    }
}
