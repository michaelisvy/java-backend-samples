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
            return ResponseEntity.created(uri).body(customer);
        }
    }

    @PutMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer) throws URISyntaxException {
        this.customerService.save(customer);
        URI uri = new URI("/customers/" + customer.getId());
        return ResponseEntity.ok().body(customer);
    }

    @DeleteMapping("/customers/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteCustomer(@PathVariable Long id) throws URISyntaxException {
        this.customerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
