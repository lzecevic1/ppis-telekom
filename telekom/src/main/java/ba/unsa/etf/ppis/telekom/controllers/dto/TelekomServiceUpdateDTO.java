package ba.unsa.etf.ppis.telekom.controllers.dto;

import ba.unsa.etf.ppis.telekom.models.TelekomService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class TelekomServiceUpdateDTO {
    @NotBlank
    @Size(max = 2000, message = "Description can't be longer than 2000 characters")
    public String description;

    @Positive(message = "Price can't be negative or zero")
    public BigDecimal price;

    @NotNull(message = "Priority of service must be specified")
    public TelekomService.ServicePriority priority;

    @Size(max = 50, message = "Name of responsible person can't be longer than 50 characters")
    public String responsiblePerson;

    public TelekomServiceUpdateDTO(String description, BigDecimal price, TelekomService.ServicePriority priority, String responsiblePerson) {
        this.description = description;
        this.price = price;
        this.priority = priority;
        this.responsiblePerson = responsiblePerson;
    }
}
