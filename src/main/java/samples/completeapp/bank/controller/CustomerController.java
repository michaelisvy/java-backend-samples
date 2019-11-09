package samples.completeapp.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import samples.completeapp.bank.model.Customer;
import samples.completeapp.bank.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/{lastName}")
    public Customer findByLastName(@PathVariable String lastName) {
        return this.customerService.findByLastName(lastName);
    }
}
