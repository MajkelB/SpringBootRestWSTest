/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb.test.restSpringBootTest.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mb.test.restSpringBootTest.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductsService {
    private long seq = 0;
    private Map<Long, Product> products = new HashMap<>();

    public ProductsService() {
        init();
    }
    
    public final void init() {
        products.put( getNextId(), new Product( getCurrentId(), "Banan", new BigDecimal( "20.33" ), 15 ) ); 
        products.put( getNextId(), new Product( getCurrentId(), "Piwo", new BigDecimal( "12.5" ), 33 ) ); 
        products.put( getNextId(), new Product( getCurrentId(), "Kawa", new BigDecimal( "15" ), 5 ) ); 
        products.put( getNextId(), new Product( getCurrentId(), "Miód", new BigDecimal( "77.12" ), 3 ) ); 
    }
 
    private Long getNextId() {
        return ++seq;
    }
    
    private Long getCurrentId() {
        return seq;
    }    
    
    public Product getProduct( Long id ) {
        return products.get( id );
    }
    
    public List<Product> getAll() {
        return new ArrayList<Product>( products.values() );
    }
    public List<Long> getAllId() {
        return new ArrayList<Long>( products.keySet() );
    }
    
    public Product addProduct( Product p ) {
        p.setId( getNextId() );
        products.put( p.getId(), p );
        return p;
    }
    
    public boolean deleteProduct( Long id ) {
        if( products.containsKey( id ) ) {
            products.remove( id );
            return true;
        } else {
            return false;
        }
    }
    
    public Product updateProduct( Long id, Product p ) {
        if( products.containsKey( id ) ) {
            p.setId( id );
            products.put( id, p );
            return p;
        } else {
            return null;
        }
    }    

}
