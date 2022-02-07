package hu.sprintform.gsomogyi.fizz.buzz.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(FizzBuzzCalculationController.BASE_URL)
public class FizzBuzzCalculationController {

    static final String BASE_URL = "/api/calculate-fizz-buzz";

    @GetMapping()
    public ResponseEntity<String> getWelcomeMessage() {
        return ResponseEntity.ok("Hello Fizz Buzz");
    }
}
