package samples.validation;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@Controller
public class VArtistController {

    @PostMapping("/artists")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<VArtist>  createArtist(@RequestBody @Valid VArtist artist, BindingResult bindingResult) throws URISyntaxException {

        if (bindingResult.hasErrors()) {
            throw new MissingDataException(bindingResult.toString());
        }

        URI uri = new URI("/artist/" + artist.getId());
        return ResponseEntity.created(uri).body(artist);
    }

    /*@ExceptionHandler(value = { Exception.class })
    protected ResponseEntity<Object> handlePlainException(Exception exception, WebRequest request) {
        String bodyOfResponse = "{\"message\":\""+ "Exception: " + exception.getMessage() + "\"}";
        return handleExceptionInternal(exception, bodyOfResponse,
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }*/
}
