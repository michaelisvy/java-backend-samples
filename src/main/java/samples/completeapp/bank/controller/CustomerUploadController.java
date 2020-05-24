package samples.completeapp.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import samples.completeapp.bank.model.Customer;
import samples.completeapp.bank.service.CustomerService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Controller
public class CustomerUploadController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/customers/upload")
    public ResponseEntity<?> upload(@RequestParam(value = "data") MultipartFile multipartFile) {
        String message = "";
        try {
            List<Customer> customerList =new ArrayList<>();
            Scanner sc = new Scanner(multipartFile.getInputStream());
            sc.useDelimiter("\n");   //sets the delimiter pattern
            while (sc.hasNext())  //returns a boolean value
            {
                customerList.add(buildCustomerFromCsvRow(sc.next()));
            }
            sc.close();
            customerService.saveAll(customerList);
            return ResponseEntity.status(HttpStatus.OK).body(customerList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("failed" + e.getMessage());
        }
    }

    private Customer buildCustomerFromCsvRow(String row) {
        String[] fields = row.split(",");
        String firstName = fields[0];
        String lastName = fields[1];
        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        return customer;
    }
}
