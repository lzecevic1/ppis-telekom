package ba.unsa.etf.ppis.telekom.controllers.dto;

import ba.unsa.etf.ppis.telekom.models.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ServiceUpdateDTO {
    @NotBlank
    @Size(max = 2000, message = "Description can't be longer than 2000 characters")
    public String description;

    @Positive(message = "Price can't be negative or zero")
    public BigDecimal price;

    @NotNull(message = "Priority of service must be specified")
    public Service.ServicePriority priority;

    @Size(max = 50, message = "Name of responsible person can't be longer than 50 characters")
    public String responsiblePerson;

    public ServiceUpdateDTO(String description, BigDecimal price, Service.ServicePriority priority, String responsiblePerson) {
        this.description = description;
        this.price = price;
        this.priority = priority;
        this.responsiblePerson = responsiblePerson;
    }
}
