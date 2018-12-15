package mb.test.restSpringBootTest;

import java.util.Date;
import mb.test.restSpringBootTest.model.Greeting;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/RestWS")
public class GreetingController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting hello(@RequestParam( name = "name", defaultValue = "Stranger") String name ) {
        Greeting g = new Greeting(); 
        g.setId((new Date()).getTime());
        g.setName( "Hello: " + name );
        return g;
    }
    
    @RequestMapping(value = "/helloText", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
    public String helloText(@RequestParam( name = "name", defaultValue = "Stranger") String name ) {
        return "Hello: " + name;
    }    

    @RequestMapping(value = "/JSONTest", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Greeting jsonTest() {
        Greeting g = new Greeting();
        g.setId((new Date()).getTime());
        g.setName("Stranger");
        return g;
    }

    @RequestMapping(value = "/Test", method = RequestMethod.GET)
    public String strinTest() {
        return "Test OK!";
    }

}
