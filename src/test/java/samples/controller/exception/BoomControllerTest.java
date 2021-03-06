package samples.controller.exception;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import samples.annotation.OPControllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@OPControllerTest
public class BoomControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldThrowBoomException() throws Exception {
        this.mockMvc.perform(
                        get("/boom1"))
                        .andExpect(status().isBadRequest())
                        .andExpect(jsonPath("$.message", is("BoomException: Boom!!!"))
                    );
    }

    @Test
    public void shouldThrowExceptionUsingResponseStatusException() throws Exception {
        this.mockMvc.perform(
                get("/boom2"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("ResponseStatusException: error came from localBoom")));
    }

}
