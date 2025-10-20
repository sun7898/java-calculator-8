package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITERS = ",|:";

    public static int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        String[] numbers = split(input);
        int sum = 0;

        for (String num : numbers) {
            int number = toInt(num);
            Validator.validatePositive(number);
            sum += number;
        }
        return sum;
    }

    private static String[] split(String input) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (matcher.matches()) {
            String customDelimiter = matcher.group(1);
            String numbers = matcher.group(2);
            return numbers.split(customDelimiter);
        }
        return input.split(DEFAULT_DELIMITERS);
    }

    private static int toInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다: " + str);
        }
    }
}
