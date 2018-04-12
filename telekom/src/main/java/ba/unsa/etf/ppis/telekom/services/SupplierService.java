package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.models.Supplier;
import ba.unsa.etf.ppis.telekom.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
