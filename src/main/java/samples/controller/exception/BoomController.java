package samples.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;
import samples.completeapp.bank.model.Customer;

@Controller
public class BoomController {

    @GetMapping("/boom")
    public Customer boom() {
        throw new BoomException("Boom!!!");
    }

    @GetMapping("/localBoom")
    public ResponseEntity<String> localBoom() {
        String errorMessage = "error came from localBoom";
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, errorMessage,
                    new RuntimeException(errorMessage));
    }
}
