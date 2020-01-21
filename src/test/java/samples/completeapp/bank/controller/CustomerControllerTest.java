package samples.completeapp.bank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import samples.completeapp.bank.model.Customer;

import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private String asJsonString(Customer customer) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonContent = mapper.writeValueAsString(customer);
        System.out.println(jsonContent);
        return jsonContent;
    }

    @Test
    public void shouldRetrieveCustomer() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/customers/{lastName}", "Bauer")
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
            ],
            "version": 1
        }
         */
    }

    @Test
    public void shouldCreateCustomer() throws Exception {
        Customer customer = new Customer("Alicia", "Jones", UUID.randomUUID());
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/customers")
                .content(asJsonString(customer))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.lastName").value("Jones"))
                // expected `location` header
                .andExpect(header().string("location", "/customers/3"));
        /*
        Expected sample response (shortened):
        {
            "id": 3,
            "firstName": "Alicia",
            "lastName": "Jones",
            "accounts": []
        }
         */

    }

    @Test
    public void shouldRefuseInvalidCustomer() throws Exception {

        Customer customer = new Customer("Alicia", "", UUID.randomUUID());
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/customers")
                .content(asJsonString(customer))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldFindByLastName() throws Exception {

        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/customers/Bauer"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName", is("Jack")))
                .andReturn();
    }

}
