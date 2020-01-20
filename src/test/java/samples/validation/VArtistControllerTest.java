package samples.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class VArtistControllerTest {
    @Autowired
    private MockMvc mockMvc;

    private String asJsonString(VArtist artist) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        String jsonContent = mapper.writeValueAsString(artist);
        System.out.println(jsonContent);
        return jsonContent;
    }

    @Test
    public void shouldValidateBeforeEnteringMethod() throws Exception {
        VArtist artist = new VArtist("Alicia", "Jones");
        this.mockMvc.perform(MockMvcRequestBuilders
                .post("/artists")
                .content(asJsonString(artist))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());


    }
}
