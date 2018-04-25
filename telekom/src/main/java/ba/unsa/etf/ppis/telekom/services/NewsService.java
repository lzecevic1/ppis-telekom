package ba.unsa.etf.ppis.telekom.services;

import ba.unsa.etf.ppis.telekom.models.News;
import ba.unsa.etf.ppis.telekom.repositories.NewsRepository;
import org.springframework.stereotype.Service;

@Service
public class NewsService extends BaseService<News, NewsRepository> {
}
