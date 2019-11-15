package samples.completeapp.bank.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import samples.completeapp.bank.model.Customer;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    public static String asJsonString(Customer customer) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonContent = mapper.writeValueAsString(customer);
        return jsonContent;
    }

    @Test
    public void shouldRetrieveCustomer() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .get("/customers/{lastName}", "Bauer")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Jack"));
    }

    @Test
    public void shouldCreateCustomer() throws Exception {

        Customer customer = new Customer("Alicia", "Isvy");
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/customers")
                .content(asJsonString(customer))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName").value("Alicia"));
    }

}
