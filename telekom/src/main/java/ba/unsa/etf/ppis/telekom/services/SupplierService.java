package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.ToDoubleFunction;

@Service
public class SupplierService extends BaseService<Supplier, SupplierRepository> {

    @Autowired
    RatingService ratingService;

    @Transactional
    public void addRatingForSupplier(Rating rating, Long supplierId) {
        Optional<Supplier> supplier = repository.findById(supplierId);
        if(!supplier.isPresent()) {
            throw new RuntimeException("Supplier with given id doesn't exist");
        }
        rating.setSupplier(supplier.get());
        ratingService.save(rating);
    }

    public Float averageRatingForSupplier(Long id) {
        Optional<Supplier> supplier = repository.findById(id);
        if(!supplier.isPresent()) {
            throw new RuntimeException("Supplier with give nid doesn't exist");
        }
        Float avgRating = 0f;
        Collection<Rating> ratings = supplier.get().getRatings();
        for (Rating r: ratings)
        {
               avgRating += r.getRating();
        }
        avgRating /= ratings.size();
        return avgRating;
    }
    public Supplier findSupplierByName(String name) {
        Supplier supplier = repository.findSupplierByName(name);
        return  supplier;
    }

    public List<Supplier> filter(Supplier.SupplierStatus status) {
        return repository.findAllByStatus(status);
    }

    public List<Supplier> sortByRating(Integer ratingType) {
        List<Supplier> allSuppliers = repository.findAll();
        Collections.sort(allSuppliers, new SortByRating(integerToRatingType(ratingType)));
        return allSuppliers;
    }

    private Rating.RatingType integerToRatingType(int i) {
        Rating.RatingType ratingType = null;
        switch (i){
            case 0: ratingType = Rating.RatingType.QUALITY; break;
            case 1: ratingType = Rating.RatingType.DELIVERY_SPEED; break;
            case 2: ratingType = Rating.RatingType.COMMUNICATION; break;
            case 3: ratingType = Rating.RatingType.OVERALL_RATING;
        }
        return ratingType;
    }

}

class SortByRating implements Comparator<Supplier> {

    private Rating.RatingType ratingType;

    SortByRating(Rating.RatingType ratingType) {
        this.ratingType = ratingType;
    }

    @Override
    public int compare(Supplier s1, Supplier s2) {
        return averageRating(s2).compareTo(averageRating(s1));
    }

    private Float averageRating(Supplier s) {
        Float avgRating = 0f;
        Integer counter = 0;
        for (Rating r : s.getRatings()) {
            if (ratingType == Rating.RatingType.OVERALL_RATING || r.getRatingType() == ratingType) {
                avgRating += r.getRating();
                counter++;
            }
        }
        if (counter > 0)
            return avgRating / counter;
        else return 0f;
    }

}


