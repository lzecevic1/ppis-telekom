package ba.unsa.etf.ppis.telekom.controllers.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductDTO {

    @NotBlank
    public String name;

    public BigDecimal price;

    @NotNull
    public Long categoryId;

    public ProductDTO() { }

    public ProductDTO(String name, BigDecimal price, Long categoryId) {
        this.name = name;
        this.price = price;
        this.categoryId = categoryId;
    }

}
