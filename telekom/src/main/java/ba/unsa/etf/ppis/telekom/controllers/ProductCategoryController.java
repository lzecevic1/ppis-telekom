package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.models.ProductCategory;
import ba.unsa.etf.ppis.telekom.services.ProductCategoryService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductCategoryController extends BaseController<ProductCategory, ProductCategoryService>  {
}
