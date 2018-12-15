/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb.test.restSpringBootTest.service;

public class ProductNotFoundException extends Exception {
    String comm;

    public ProductNotFoundException( String comm ) {
        super(comm);
        this.comm = comm;
    }

    public ProductNotFoundException() {
        super();
    }
    
    
    
}
