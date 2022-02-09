package hu.sprintform.gsomogyi.fizz.buzz.service.app;

import java.util.List;

public interface FizzBuzzCalculationService {

    List<String> calculateFizzBuzzElements(int numberOfElements);

    String calculateFizzBuzzFor(int number);
}
