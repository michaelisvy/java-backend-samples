package samples.completeapp.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import samples.completeapp.bank.model.Customer;
import samples.completeapp.bank.service.CustomerService;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{lastName}")
    public Customer findByLastName(@PathVariable String lastName) {
        return this.customerService.findByLastName(lastName);
    }

    @PostMapping("/customers")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<?> createCustomer(@RequestBody Customer customer, Errors errors) throws URISyntaxException {
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(errors.getAllErrors());
        } else {
            this.customerService.save(customer);
            URI uri = new URI("/customers/" + customer.getId());
            return ResponseEntity.created(uri).build();
        }
    }
}
