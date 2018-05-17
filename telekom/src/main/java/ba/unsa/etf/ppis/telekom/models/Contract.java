package ba.unsa.etf.ppis.telekom.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

@Entity
public class Contract {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date startDate;
    private String startDateString;
    private Date endDate;
    private String endDateString;
    private String responsiblePerson;
    private boolean isActive;

    @ManyToMany(targetEntity = Product.class)
    @JoinTable(
            name = "contract_product",
            joinColumns = @JoinColumn(name = "contract_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Collection<Product> products;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    public Contract() { }

    public Contract(Date startDate, Date endDate, String responsiblePerson, Supplier supplier, boolean isActive) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.responsiblePerson = responsiblePerson;
        this.supplier = supplier;
        this.isActive = isActive;
        this.startDateString = new SimpleDateFormat("dd.MM.yyyy").format(this.startDate);
        this.endDateString = new SimpleDateFormat("dd.MM.yyyy").format(this.endDate);

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getStartDateString() {
        return startDateString;
    }

    public void setStartDateString(String startDateString) {
        this.startDateString = startDateString;
    }

    public String getEndDateString() {
        return endDateString;
    }

    public void setEndDateString(String endDateString) {
        this.endDateString = endDateString;
    }
}
