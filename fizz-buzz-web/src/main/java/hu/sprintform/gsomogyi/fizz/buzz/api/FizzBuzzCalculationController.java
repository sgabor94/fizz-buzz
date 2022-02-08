package hu.sprintform.gsomogyi.fizz.buzz.api;

import hu.sprintform.gsomogyi.fizz.buzz.app.FizzBuzzCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(FizzBuzzCalculationController.BASE_URL)
public class FizzBuzzCalculationController {

    static final String BASE_URL = "/api/calculate-fizz-buzz";

    private final FizzBuzzCalculationService fizzBuzzCalculationService;

    @GetMapping
    public ResponseEntity<String> calculateFizzBuzzFor(@RequestParam int number) {
        return ResponseEntity.ok(fizzBuzzCalculationService.calculateFizzBuzzFor(number));
    }
}
