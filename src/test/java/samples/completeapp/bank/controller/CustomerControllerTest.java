package samples.completeapp.bank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import samples.annotation.OPControllerTest;
import samples.completeapp.bank.model.Customer;
import samples.completeapp.bank.repository.CustomerRepository;

import javax.persistence.EntityManager;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@OPControllerTest
public class CustomerControllerTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private MockMvc mockMvc;

    private String asJsonString(Customer customer) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonContent = mapper.writeValueAsString(customer);
        return jsonContent;
    }

    @Test
    public void shouldRetrieveCustomer() throws Exception {
        this.mockMvc.perform(get("/customers/{lastName}", "Bauer")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Jack"))
                .andExpect(jsonPath("$.accounts[0].amount").value("50.0"));
        /*
        Expected sample response (shortened):
        {
            "id": 1,
            "firstName": "Jack",
            "lastName": "Bauer",
            "accounts": [
                {
                    "amount": 50.0
                }
            ]
        }
         */
    }

    @Test
    public void shouldCreateCustomer() throws Exception {
        /*
        Expected sample response (shortened):
        {
            "id": 3,
            "firstName": "Alicia",
            "lastName": "Jones"
        }
         */
        Customer customer = new Customer("Alicia", "Jones", UUID.randomUUID());
        this.mockMvc.perform(post("/customers")
                .content(asJsonString(customer))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful()) // if I need to be generic
                .andExpect(status().isCreated()) // if I need to be specific
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.lastName").value("Jones"))
                // expected `location` header
                .andExpect(header().string("location", "/customers/3"));

    }

    @Test
    public void shouldUpdateExistingCustomer() throws Exception {
        Customer customer = new Customer("Alicia", "Jones", UUID.randomUUID());
        this.customerRepository.save(customer);
        this.entityManager.detach(customer);

        customer.setFirstName("Melina");
        String url = "/customers/" + customer.getId();
        this.mockMvc.perform(
                put(url)
                .content(asJsonString(customer))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldRefuseInvalidCustomer() throws Exception {

        Customer customer = new Customer("Alicia", "", UUID.randomUUID());
        this.mockMvc.perform(
                post("/customers")
                    .content(asJsonString(customer))
                    .contentType(MediaType.APPLICATION_JSON)
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldFindByLastName() throws Exception {

        this.mockMvc.perform(
                get("/customers/Bauer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Jack")))
                .andReturn();
    }

}
