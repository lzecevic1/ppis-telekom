package ba.unsa.etf.ppis.telekom.repositories;

import ba.unsa.etf.ppis.telekom.models.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Long> {
}
