package hu.sprintform.gsomogyi.fizz.buzz.app;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzCalculationServiceImpl implements FizzBuzzCalculationService {

    @Override
    public List<String> calculateFizzBuzzElements(int n) {
        return IntStream.rangeClosed(1, n).mapToObj(this::calculateFizzBuzzFor).collect(Collectors.toList());
    }

    @Override
    public String calculateFizzBuzzFor(int number) {
        StringBuilder result = new StringBuilder();
        result.append(convertNumberToFizzBuzzElement(number, 3, "Fizz"));
        result.append(convertNumberToFizzBuzzElement(number, 5, "Buzz"));
        return result.length() > 0 ? result.toString() : Integer.toString(number);
    }

    private String convertNumberToFizzBuzzElement(int number, int divider, String replaceText) {
        if (number % divider == 0) {
            return replaceText;
        }
        return "";
    }
}
