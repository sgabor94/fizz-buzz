package hu.sprintform.gsomogyi.fizz.buzz.api;

import hu.sprintform.gsomogyi.fizz.buzz.service.app.FizzBuzzCalculationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/first-n-element")
    public ResponseEntity<List<String>> calculateFizzBuzzElements(@RequestParam(defaultValue = "100") int n) {
        return ResponseEntity.ok(fizzBuzzCalculationService.calculateFizzBuzzElements(n));
    }
}
