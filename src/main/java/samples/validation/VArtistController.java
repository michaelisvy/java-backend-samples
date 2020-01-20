package samples.validation;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller
public class VArtistController {

    @PostMapping("/artists")
    public void createArtist(@RequestBody @Valid VArtist artist) {
        System.out.println("inside createArtist");
    }
}
