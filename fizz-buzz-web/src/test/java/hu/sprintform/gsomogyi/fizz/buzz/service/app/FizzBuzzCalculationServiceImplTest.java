package hu.sprintform.gsomogyi.fizz.buzz.service.app;

import hu.sprintform.gsomogyi.fizz.buzz.FizzBuzzApplication;
import hu.sprintform.gsomogyi.fizz.buzz.dto.exception.FizzBuzzRuntimeException;
import hu.sprintform.gsomogyi.fizz.buzz.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FizzBuzzApplication.class)
class FizzBuzzCalculationServiceImplTest {

    @Autowired
    private FizzBuzzCalculationService fizzBuzzCalculationService;

    @Test
    void calculateFizzBuzzForValidNumbers() {
        // given

        // when
        String fizzBuzzElement3 = fizzBuzzCalculationService.calculateFizzBuzzFor(3);
        String fizzBuzzElement5 = fizzBuzzCalculationService.calculateFizzBuzzFor(5);
        String fizzBuzzElement15 = fizzBuzzCalculationService.calculateFizzBuzzFor(15);
        String fizzBuzzElement2 = fizzBuzzCalculationService.calculateFizzBuzzFor(2);
        String fizzBuzzElement8 = fizzBuzzCalculationService.calculateFizzBuzzFor(8);

        // then
        assertEquals("Fizz", fizzBuzzElement3);
        assertEquals("Buzz", fizzBuzzElement5);
        assertEquals("FizzBuzz", fizzBuzzElement15);
        assertEquals("2", fizzBuzzElement2);
        assertEquals("8", fizzBuzzElement8);
    }

    @Test
    void calculateFizzBuzzForNegativeNumber() {
        // given

        // when
        FizzBuzzRuntimeException e = assertThrows(FizzBuzzRuntimeException.class, () -> {
            fizzBuzzCalculationService.calculateFizzBuzzFor(-10);
        });

        // then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, e.getErrorCode().getHttpStatus());
        assertEquals("INVALID_VALUE_FOR_NUMBER", e.getErrorCode().name());
        assertEquals("Number must be greater than 0", e.getErrorCode().getDescription());
    }

    @Test
    void calculateFizzBuzzFirst100Elements() {
        // given

        // when
        List<String> fizzBuzzElements = fizzBuzzCalculationService.calculateFizzBuzzElements(100);

        // then
        List<String> expected = Arrays.asList(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz", "16", "17", "Fizz", "19", "Buzz",
                "Fizz", "22", "23", "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz", "31", "32", "Fizz", "34", "Buzz", "Fizz", "37", "38", "Fizz", "Buzz",
                "41", "Fizz", "43", "44", "FizzBuzz", "46", "47", "Fizz", "49", "Buzz", "Fizz", "52", "53", "Fizz", "Buzz", "56", "Fizz", "58", "59", "FizzBuzz",
                "61", "62", "Fizz", "64", "Buzz", "Fizz", "67", "68", "Fizz", "Buzz", "71", "Fizz", "73", "74", "FizzBuzz", "76", "77", "Fizz", "79", "Buzz",
                "Fizz", "82", "83", "Fizz", "Buzz", "86", "Fizz", "88", "89", "FizzBuzz", "91", "92", "Fizz", "94", "Buzz", "Fizz", "97", "98", "Fizz", "Buzz"
        );
        assertFalse(fizzBuzzElements.isEmpty());
        assertEquals(expected.size(), fizzBuzzElements.size());
        assertEquals(expected, fizzBuzzElements);
    }

    @Test
    void calculateFizzBuzzFirst1000Elements() {
        // given

        // when
        List<String> fizzBuzzElements = fizzBuzzCalculationService.calculateFizzBuzzElements(1000);

        // then
        String[] fizzBuzzElementsArray = new String[fizzBuzzElements.size()];
        fizzBuzzElementsArray = fizzBuzzElements.toArray(fizzBuzzElementsArray);
        String[] expected = TestUtil.getObjectFromJson("src/test/resources/fizz-buzz-elements.json", String[].class);
        TestUtil.assertResult(fizzBuzzElementsArray, expected);
    }
}
