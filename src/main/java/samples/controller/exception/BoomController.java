package samples.controller.exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import samples.completeapp.bank.model.Customer;

@Controller
public class BoomController {

    @GetMapping("/boom")
    public Customer boom() {
        throw new BoomException("Boom!!!");
    }
}
