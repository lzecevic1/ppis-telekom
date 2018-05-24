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

    public SupplierDTO (Supplier s,int i) {
        this.address = s.getAddress();
        this.id = s.getId();
        this.name = s.getName();
        this.status = s.getStatus();
        this.category = s.getCategory();
        this.averageRating = averageRating(s,i);
    }
    public SupplierDTO (Supplier s) {
        this.address = s.getAddress();
        this.id = s.getId();
        this.name = s.getName();
        this.status = s.getStatus();
        this.category = s.getCategory();
        this.averageRating = averageRating(s,3);
    }

    private Float averageRating(Supplier s, int i) {
        Float avgRating = 0f;
        Integer size = 0;
        for (Rating r : s.getRatings()) {
            if(i == 3){
                avgRating += r.getRating();
                size++;}
            else {
                if(r.getRatingType().ordinal() == i) {
                    avgRating += r.getRating();
                    size++;
                }
            }
        }
        if (size > 0)
            return avgRating / size;
        else return 0f;
    }

}
