package hu.sprintform.gsomogyi.fizz.buzz.service.app;

import hu.sprintform.gsomogyi.fizz.buzz.dto.exception.ErrorCode;
import hu.sprintform.gsomogyi.fizz.buzz.dto.exception.FizzBuzzRuntimeException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FizzBuzzCalculationServiceImpl implements FizzBuzzCalculationService {

    @Override
    public List<String> calculateFizzBuzzElements(int numberOfElements) {
        return IntStream.rangeClosed(1, numberOfElements).mapToObj(this::calculateFizzBuzzFor).collect(Collectors.toList());
    }

    @Override
    public String calculateFizzBuzzFor(int number) {
        if (number < 0) {
            throw new FizzBuzzRuntimeException(ErrorCode.INVALID_VALUE_FOR_NUMBER);
        }
        StringBuilder result = new StringBuilder();
        result.append(convertNumberToFizzBuzzElement(number, 3, "Fizz"));
        result.append(convertNumberToFizzBuzzElement(number, 5, "Buzz"));
        return result.length() > 0 ? result.toString() : Integer.toString(number);
    }

    private String convertNumberToFizzBuzzElement(int number, int divider, String replaceText) {
        try {
            if (number % divider == 0) {
                return replaceText;
            }
            return "";
        } catch (ArithmeticException e) {
            throw new FizzBuzzRuntimeException(ErrorCode.INVALID_ZERO_DIVIDER, e);
        }
    }
}
