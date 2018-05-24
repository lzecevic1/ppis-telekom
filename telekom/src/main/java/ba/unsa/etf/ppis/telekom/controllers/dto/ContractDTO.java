package ba.unsa.etf.ppis.telekom.controllers.dto;

import java.math.BigDecimal;
import java.util.Date;

public class ContractDTO {
    public Long supplierId;
    public String responsiblePerson;
    public Date startDate;
    public Date endDate;
    public BigDecimal price;
    public String deliveryAddress;
    public Date dueDatePayment;
    public Integer dueDateDelivery;

    public ContractDTO(Long id, String responsiblePerson, Date startDate, Date endDate, BigDecimal price, String deliveryAddress, Date dueDatePayment, Integer dueDateDelivery) {
        this.supplierId = id;
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
