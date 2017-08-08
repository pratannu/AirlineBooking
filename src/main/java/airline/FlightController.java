package airline;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by rajashrk on 8/8/17.
 */
@Controller
@SpringBootApplication
public class FlightController {

    public static void main(String []args) {
        SpringApplication.run(FlightController.class,args);
    }

    @RequestMapping("/")
    public String welcomeMessage() {
        return "flightSearch";
    }


}
