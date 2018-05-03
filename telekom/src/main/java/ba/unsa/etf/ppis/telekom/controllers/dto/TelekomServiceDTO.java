package ba.unsa.etf.ppis.telekom.controllers.dto;

import ba.unsa.etf.ppis.telekom.models.TelekomService;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class TelekomServiceDTO {

    @NotBlank
    @Size(max = 255, message = "ServiceId can't be longer than 255 characters")
    public String serviceId;

    @NotNull
    public TelekomService.ServiceType type;

    @NotBlank
    @Size(max = 2000, message = "Description can't be longer than 2000 characters")
    public String description;

    @Positive(message = "Price can't be negative or zero")
    public BigDecimal price;

    @NotNull(message = "Priority of service must be specified")
    public TelekomService.ServicePriority priority;

    @Size(max = 50, message = "Name of responsible person can't be longer than 50 characters")
    public String responsiblePerson;

    public TelekomServiceDTO() {
    }

    public TelekomServiceDTO(String serviceId, TelekomService.ServiceType type, String description, BigDecimal price,
                             TelekomService.ServicePriority priority, String responsiblePerson) {
        this.serviceId = serviceId;
        this.type = type;
        this.description = description;
        this.price = price;
        this.priority = priority;
        this.responsiblePerson = responsiblePerson;
    }


}
