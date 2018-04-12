package ba.unsa.etf.ppis.telekom.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private ProductCategory category;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @JsonIgnore
    @ManyToMany(
            mappedBy = "products"
    )
    private Collection<Contract> contracts;

    public Product() { }

    public Product(String name, BigDecimal price, ProductCategory category, Service service, Collection<Contract> contracts) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.service = service;
        this.contracts = contracts;
    }

    public Product(String name, BigDecimal price, ProductCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public Collection<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Collection<Contract> contracts) {
        this.contracts = contracts;
    }

}
