package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

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
}
