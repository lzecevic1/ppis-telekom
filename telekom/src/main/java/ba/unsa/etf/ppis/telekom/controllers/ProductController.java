package ba.unsa.etf.ppis.telekom.controllers;

import ba.unsa.etf.ppis.telekom.controllers.dto.ProductDTO;
import ba.unsa.etf.ppis.telekom.models.Product;
import ba.unsa.etf.ppis.telekom.models.ProductCategory;
import ba.unsa.etf.ppis.telekom.models.Rating;
import ba.unsa.etf.ppis.telekom.services.ProductCategoryService;
import ba.unsa.etf.ppis.telekom.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.util.Locale;
import java.util.Optional;

@RestController
public class ProductController extends BaseController<Product, ProductService>  {

    @Autowired
    ProductCategoryService categoryService;

    public ResponseEntity create(@RequestBody @Valid ProductDTO product) {
        Optional<ProductCategory> category = categoryService.getById(product.categoryId);
        if (!category.isPresent())
            return ResponseEntity.badRequest().build();
        service.save(new Product(product.name, product.price, category.get()));
        return ResponseEntity.ok().build();
    }


}
