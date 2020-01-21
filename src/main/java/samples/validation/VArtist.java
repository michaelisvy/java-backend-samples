package samples.validation;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity @Data
public class VArtist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "first name can't be empty!")
    private String firstName;

    @NotBlank(message = "last name can't be empty!")
    private String lastName;

    public VArtist(String firstName) {
        this.firstName = firstName;
    }

    public VArtist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
