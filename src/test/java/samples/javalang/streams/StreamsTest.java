package samples.javalang.streams;

import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class StreamsTest {

    @Test
    public void shouldFilterAList() {
        List<String> strings = Arrays   .asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        assertThat(filtered.size()).isEqualTo(5);
        assertThat(filtered).contains("abc", "bc", "efg", "abcd", "jkl");
    }

    @Test
    public void shouldSortAList() {
        List<String> strings = Arrays   .asList("abc", "", "bc", "jkl", "abcd","", "efg");
        List<String> filtered = strings.stream().sorted().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        assertThat(filtered.size()).isEqualTo(5);
        assertThat(filtered).containsExactly("abc", "abcd", "bc", "efg", "jkl");
    }

    @Test
    public void shouldSortWithParallelProcessing() {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        // able to share workload on multiple processors
        long count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        assertThat(count).isEqualTo(2);
    }

    @Test
    public void shouldGenerateRandomNumbers() throws Exception {
        Random random = new Random();
        StopWatch watch = new StopWatch();
        watch.start();
        IntStream stream = random.ints().limit(10000000); // fast operation. Numbers not yet generated.
        watch.stop();
        System.out.println(watch.getTotalTimeMillis());
        watch.start();
        stream.forEach(this::print); // numbers generated and processed on the flow
        watch.stop();
        System.out.println(watch.getTotalTimeMillis());
    }

    private void print(int number) {
        assertThat(number).isNotNull();
    }
}
