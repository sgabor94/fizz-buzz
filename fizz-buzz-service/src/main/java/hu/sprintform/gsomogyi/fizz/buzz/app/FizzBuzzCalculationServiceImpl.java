package hu.sprintform.gsomogyi.fizz.buzz.app;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FizzBuzzCalculationServiceImpl implements FizzBuzzCalculationService {

    @Override
    public List<Integer> calculateFizzBuzzElements(int n) {
        return null;
    }

    @Override
    public String calculateFizzBuzzFor(int number) {
        Optional<String> resultOpt = Optional.of(number).map(n -> (n % 3 == 0 ? "Fizz" : "") + (n % 5 == 0 ? "Buzz" : ""));
        String result = resultOpt.orElse("");
        return result.isEmpty() ? Integer.toString(number) : result;
    }
}
