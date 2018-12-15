package mb.test.restSpringBootTest;

import java.util.List;
import mb.test.restSpringBootTest.model.Product;
import mb.test.restSpringBootTest.service.ProductNotFoundException;
import mb.test.restSpringBootTest.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

    public static final String GET_PRODUCT = "/{id}";
    public static final String GET_ALL_PRODUCTS = "/";
    public static final String ADD_PRODUCT = "/add";
    public static final String DELETE_PRODUCT = "/delete/{id}";
    public static final String UPDATE_PRODUCT = "/update/{id}";

    @Autowired
    private ProductsService prodService;

    @GetMapping( GET_ALL_PRODUCTS )
    public List<Product> getAll() {
        return prodService.getAll();
    }

    @GetMapping( GET_PRODUCT )
    public Product findOne( @RequestParam( name = "id", required = true, defaultValue = "1" ) Long id) throws ProductNotFoundException {
        Product p = prodService.getProduct(id);
        if( p == null ) throw new ProductNotFoundException( "Nie znaleziono produktu o id: " + id );
        return p;
    }

    @PostMapping( value = ADD_PRODUCT, consumes = MediaType.APPLICATION_JSON_VALUE )
    @ResponseStatus(HttpStatus.CREATED)
    public void create( @RequestBody Product p ) {
        prodService.addProduct(p);
    }

    @DeleteMapping( DELETE_PRODUCT )
    public void delete( @PathVariable("id") Long id ) throws ProductNotFoundException {
        if( !prodService.deleteProduct( id ) ) throw new ProductNotFoundException( "Nie znaleziono produktu o id: " + id );
    }

    @PutMapping( value = UPDATE_PRODUCT, consumes = MediaType.APPLICATION_JSON_VALUE  )
    public Product update( @RequestBody Product p, @PathVariable("id") Long id )  throws ProductNotFoundException {
        if( prodService.updateProduct( id, p )  == null ) throw new ProductNotFoundException( "Nie znaleziono produktu o id: " + id );
        return p;
    }

}
