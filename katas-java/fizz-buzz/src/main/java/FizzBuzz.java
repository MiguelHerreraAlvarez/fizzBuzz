import java.util.*;

public class FizzBuzz {

    public static final String FIZZ = "Fizz";

    public static List<String> start() {
        final List<String> fizzBuzzValue = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            String currentValue;
            if (i % 3 == 0) {
                currentValue = FIZZ;
            } else {
                currentValue = String.valueOf(i);
            }

            fizzBuzzValue.add(currentValue);
        }

        return fizzBuzzValue;
    }
}
