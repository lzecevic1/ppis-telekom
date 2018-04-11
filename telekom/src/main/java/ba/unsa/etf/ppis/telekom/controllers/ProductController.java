package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.Product;
import ba.unsa.etf.ppis.telekom.services.ProductService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController extends BaseController<Product, ProductService>  {
}
