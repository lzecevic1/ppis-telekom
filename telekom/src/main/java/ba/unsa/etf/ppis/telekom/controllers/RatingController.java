package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.services.RatingService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RatingController extends BaseController<Rating, RatingService>  {
}
