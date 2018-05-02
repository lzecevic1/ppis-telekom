package ba.unsa.etf.ppis.telekom.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Supplier {

    public enum SupplierStatus{ACTIVE, UNACTIVE};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private SupplierStatus status;
    private String category;

    @OneToMany(mappedBy = "supplier")
    private Collection<Rating> ratings;

    @JsonIgnore
    @OneToMany(mappedBy = "supplier")
    private Collection<Contract> contracts;

    public Supplier() { }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SupplierStatus getStatus() {
        return status;
    }

    public void setStatus(SupplierStatus status) {
        this.status = status;
    }

    public void setRatings(Collection<Rating> ratings) {
        this.ratings = ratings;
    }

    public Collection<Rating> getRatings() {
        return ratings;
    }

    public String  getCategory() {
        return category;
    }

    public void setCategory(String  category) {
        this.category = category;
    }

    public Collection<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Collection<Contract> contracts) {
        this.contracts = contracts;
    }
}
