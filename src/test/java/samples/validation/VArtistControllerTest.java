package samples.validation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import samples.annotation.OPControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@OPControllerTest
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
    public void shouldValidateSuccessfully() throws Exception {
        VArtist artist = new VArtist("Alicia", "Jones");
        this.mockMvc.perform(
                post("/artists")
                .content(asJsonString(artist))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldHaveValidationError() throws Exception {
        VArtist artist = new VArtist("Alicia"); // Lastname is missing
        this.mockMvc.perform(
                post("/artists")
                        .content(asJsonString(artist))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}
