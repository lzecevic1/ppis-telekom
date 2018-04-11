package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.News;
import ba.unsa.etf.ppis.telekom.services.NewsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsController extends BaseController<News, NewsService>  {

    public ResponseEntity test() {
        return ResponseEntity.ok().body("Selam");
    }
}
