package ba.unsa.etf.ppis.telekom.repositories;

import ba.unsa.etf.ppis.telekom.models.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long> {
}
