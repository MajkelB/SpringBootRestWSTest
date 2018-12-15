/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mb.test.restSpringBootTest.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author wsodev
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Product {
    
    private Long id;
    private String name;
    private BigDecimal price;
    private int quantity;
    
}
