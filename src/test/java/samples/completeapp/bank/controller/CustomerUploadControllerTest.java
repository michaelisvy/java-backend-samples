package samples.completeapp.bank.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import samples.annotation.OPControllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@OPControllerTest
public class CustomerUploadControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldUploadCustomers() throws Exception {
        this.mockMvc.perform(multipart("/customers/upload")
                .file(this.buildMockMultipartFile())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private MockMultipartFile buildMockMultipartFile() throws Exception {
        String name = "data";
        String contentType = "text/plain";
        String fileContent =    "Joe,Satriani\n" +
                                "Jimi, Hendrix\n" +
                                "Mateus,Asato\n" +
                                "Jimmy,Page";
        return new MockMultipartFile(name, name, contentType, fileContent.getBytes());
    }



}
