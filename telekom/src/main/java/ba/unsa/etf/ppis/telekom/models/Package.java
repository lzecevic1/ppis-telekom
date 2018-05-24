package ba.unsa.etf.ppis.telekom.models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
public class Package {

    public PackageStatus getStatus() {
        return status;
    }

    public void setStatus(PackageStatus status) {
        this.status = status;
    }

    public enum PackageStatus {Aktivan, Neaktivan};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private PackageStatus status;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "package_service",
            joinColumns = @JoinColumn(name = "package_id"),
            inverseJoinColumns = @JoinColumn(name = "service_id")
    )
    private Collection<TelekomService> telekomServices;

    public Package() {
    }

    public Package(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = PackageStatus.Aktivan;

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

    public Collection<TelekomService> getTelekomServices() {
        return telekomServices;
    }

    public void setTelekomServices(Collection<TelekomService> telekomServices) {
        this.telekomServices = telekomServices;
    }

    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
