package ba.unsa.etf.ppis.telekom.controllers.dto;

import ba.unsa.etf.ppis.telekom.models.Product;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class ProductDTO {

    @NotBlank
    public String name;

    public BigDecimal price;

    @NotNull
    public Product.ProductCategory category;

    public ProductDTO() { }

    public ProductDTO(String name, BigDecimal price, Product.ProductCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

}
