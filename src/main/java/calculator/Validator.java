package calculator;

public class Validator {

    public static void validatePositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
        }
    }
}
