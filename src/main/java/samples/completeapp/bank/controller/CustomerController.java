package samples.completeapp.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import samples.completeapp.bank.model.Customer;
import samples.completeapp.bank.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customers/{lastName}")
    public Customer findByLastName(@PathVariable String lastName) {
        return this.customerService.findByLastName(lastName);
    }

    @PostMapping("/customers")
    public Customer createCustomer(@RequestBody Customer customer) {
        this.customerService.save(customer);
        return customer;
    }
}
