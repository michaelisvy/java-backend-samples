package samples.javalang;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.*;

class Person {
    private String firstName;

    public Person(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}

public class CollectionsTest {

    @Test
    public void shouldPerformSimpleLoop() {
        Collection<Person> personsCollection = asList(new Person("Joe"), new Person("Jack"), new Person("John"));

        for (Person person : personsCollection) {
            assertThat(person.getFirstName()).startsWith("J");
        }
    }

    @Test
    public void shouldPopulateACollectionWithLambdasDoubleLoop() {
        Collection<Person> personsCollection = asList(new Person("Joe"), new Person("Sam"), new Person("John"));

        Predicate<Person> startWithJPredicate = p -> p.getFirstName().startsWith("J");
        Stream<Person> stream = personsCollection.stream().filter(startWithJPredicate);

        // convert stream back to collection (this is optional, should only be used if list needs to be returned)
        List<Person> filteredList = stream.collect(Collectors.toList());

        filteredList.forEach(p -> assertThat(p.getFirstName()).startsWith("J"));
    }


}
