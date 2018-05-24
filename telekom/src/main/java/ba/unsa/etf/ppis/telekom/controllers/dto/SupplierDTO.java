package ba.unsa.etf.ppis.telekom.controllers.dto;

import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.models.Supplier;


public class SupplierDTO {

    public Long id;
    public String name;
    public String address;
    public Supplier.SupplierStatus status;
    public Supplier.SupplierCategory category;
    public Float averageRating;

    public SupplierDTO (Supplier s) {
        this.address = s.getAddress();
        this.id = s.getId();
        this.name = s.getName();
        this.status = s.getStatus();
        this.category = s.getCategory();
        this.averageRating = averageRating(s);
    }

    private Float averageRating(Supplier s) {
        Float avgRating = 0f;
        Integer counter = 0;
        for (Rating r : s.getRatings()) {
            avgRating += r.getRating();
            counter++;
        }
        if (counter > 0)
            return avgRating / counter;
        else return 0f;
    }

}
