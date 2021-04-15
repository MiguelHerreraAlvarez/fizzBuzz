import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FizzBuzzTest {

    private List<String> fizzBuzzValues;

    @BeforeEach
    public void setUp() {
        fizzBuzzValues = FizzBuzz.start();
    }

    @Test
    public void fizzBuzz_returnOneHundredElementsList() {
        fizzBuzzValues = FizzBuzz.start();

        assertEquals(fizzBuzzValues.size(), 100);
    }

    @Test
    public void given_nonMultipleThreeOrFiveNumber_returnSameNumber() {
        fizzBuzzValues = FizzBuzz.start();

        assertEquals(fizzBuzzValues.get(0), "1");
        assertEquals(fizzBuzzValues.get(1), "2");
    }

    @Test
    public void given_multipleOfThree_returnFizz() {
        fizzBuzzValues = FizzBuzz.start();

        assertEquals(fizzBuzzValues.get(2), FizzBuzz.FIZZ);
    }
}
