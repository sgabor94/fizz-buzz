package hu.sprintform.gsomogyi.fizz.buzz.app;

import java.util.List;

public interface FizzBuzzCalculationService {

    List<String> calculateFizzBuzzElements(int n);

    String calculateFizzBuzzFor(int number);
}
