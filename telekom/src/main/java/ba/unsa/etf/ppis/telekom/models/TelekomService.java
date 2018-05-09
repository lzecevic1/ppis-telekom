package ba.unsa.etf.ppis.telekom.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "service")
public class TelekomService {

    public enum ServicePriority {MISSION_CRITICAL, BUSSINESS_CRITICAL, BUSSINESS_OPERATIONAL, ADMINISTRATIVE_SERVICES}
    public enum ServiceType {CABLE_TV, iNTERNET, DEVICE, TELEPHONY}
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String serviceId;
    private ServiceType type;
    private String description;
    private BigDecimal price;
    private ServicePriority priority; // = ServicePriority.BUSSINESS_CRITICAL;
    private String responsiblePerson;
    private Integer numRenewedContracts;
    private Integer numCancelledContracts;
    private Integer numActiveContracts;

    @JsonIgnore
    @ManyToMany(
            mappedBy = "telekomServices",
            targetEntity = Package.class
    )
    private Collection<Package> packages;

    @OneToMany(mappedBy = "telekomService")
    private Collection<Product> products;

    @OneToMany(mappedBy = "telekomService")
    private Collection<ServiceUnavailablityPeriod> unavailablityPeriods;

    @OneToMany(mappedBy = "telekomService")
    private Collection<News> news;

    public TelekomService() { }

    public TelekomService(String serviceId, ServiceType type, String description, BigDecimal price, ServicePriority priority,
                          String responsiblePerson, Integer numRenewedContracts, Integer numCancelledContracts, Integer numActiveContracts) {
        this.serviceId = serviceId;
        this.type = type;
        this.description = description;
        this.price = price;
        this.priority = priority;
        this.responsiblePerson = responsiblePerson;
        this.numRenewedContracts = numRenewedContracts;
        this.numCancelledContracts = numCancelledContracts;
        this.numActiveContracts = numActiveContracts;
    }

    public TelekomService(ServiceType serviceType, String description, String responsiblePerson, BigDecimal price,
                          ServicePriority servicePriority, String serviceId) {
        this.serviceId = "";
        this.type = serviceType;
        this.description = description;
        this.price = price;
        this.priority = servicePriority;
        this.responsiblePerson = responsiblePerson;
        this.serviceId = serviceId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public ServiceType getType() {
        return type;
    }

    public void setType(ServiceType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ServicePriority getPriority() {
        return priority;
    }

    public void setPriority(ServicePriority priority) {
        this.priority = priority;
    }

    public String getResponsiblePerson() {
        return responsiblePerson;
    }

    public void setResponsiblePerson(String responsiblePerson) {
        this.responsiblePerson = responsiblePerson;
    }

    public Integer getNumRenewedContracts() {
        return numRenewedContracts;
    }

    public void setNumRenewedContracts(Integer numRenewedContracts) {
        this.numRenewedContracts = numRenewedContracts;
    }

    public Integer getNumCancelledContracts() {
        return numCancelledContracts;
    }

    public void setNumCancelledContracts(Integer numCancelledContracts) {
        this.numCancelledContracts = numCancelledContracts;
    }

    public Integer getNumActiveContracts() {
        return numActiveContracts;
    }

    public void setNumActiveContracts(Integer numActiveContracts) {
        this.numActiveContracts = numActiveContracts;
    }

    public Collection<Package> getPackages() {
        return packages;
    }

    public void setPackages(Collection<Package> packages) {
        this.packages = packages;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public Collection<ServiceUnavailablityPeriod> getUnavailablityPeriods() {
        return unavailablityPeriods;
    }

    public void setUnavailablityPeriods(Collection<ServiceUnavailablityPeriod> unavailablityPeriods) {
        this.unavailablityPeriods = unavailablityPeriods;
    }

    public Collection<News> getNews() {
        return news;
    }

    public void setNews(Collection<News> news) {
        this.news = news;
    }

    @Override
    public String toString() {
        return "TelekomService{" +
                "id=" + id +
                ", serviceId='" + serviceId + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", priority=" + priority +
                ", responsiblePerson='" + responsiblePerson + '\'' +
                ", numRenewedContracts=" + numRenewedContracts +
                ", numCancelledContracts=" + numCancelledContracts +
                ", numActiveContracts=" + numActiveContracts +
                '}';
    }
}
