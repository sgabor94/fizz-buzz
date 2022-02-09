package hu.sprintform.gsomogyi.fizz.buzz.api;

import hu.sprintform.gsomogyi.fizz.buzz.dto.exception.ErrorCode;
import hu.sprintform.gsomogyi.fizz.buzz.dto.exception.ResponseExceptionDTO;
import hu.sprintform.gsomogyi.fizz.buzz.util.TestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FizzBuzzCalculationControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void calculateFizzBuzzForValidNumbers() {
        // given

        // when
        ResponseEntity<String> fizzBuzzElement3 = restTemplate.exchange(FizzBuzzCalculationController.BASE_URL + "/?number=3",
                HttpMethod.GET, new HttpEntity<>(null), String.class);

        ResponseEntity<String> fizzBuzzElement5 = restTemplate.exchange(FizzBuzzCalculationController.BASE_URL + "/?number=5",
                HttpMethod.GET, new HttpEntity<>(null), String.class);

        ResponseEntity<String> fizzBuzzElement15 = restTemplate.exchange(FizzBuzzCalculationController.BASE_URL + "/?number=15",
                HttpMethod.GET, new HttpEntity<>(null), String.class);

        ResponseEntity<String> fizzBuzzElement2 = restTemplate.exchange(FizzBuzzCalculationController.BASE_URL + "/?number=2",
                HttpMethod.GET, new HttpEntity<>(null), String.class);

        ResponseEntity<String> fizzBuzzElement8 = restTemplate.exchange(FizzBuzzCalculationController.BASE_URL + "/?number=8",
                HttpMethod.GET, new HttpEntity<>(null), String.class);

        // then
        assertEquals(HttpStatus.OK, fizzBuzzElement3.getStatusCode());
        assertNotNull(fizzBuzzElement3.getBody());
        assertEquals("Fizz", fizzBuzzElement3.getBody());

        assertEquals(HttpStatus.OK, fizzBuzzElement5.getStatusCode());
        assertNotNull(fizzBuzzElement5.getBody());
        assertEquals("Buzz", fizzBuzzElement5.getBody());

        assertEquals(HttpStatus.OK, fizzBuzzElement15.getStatusCode());
        assertNotNull(fizzBuzzElement15.getBody());
        assertEquals("FizzBuzz", fizzBuzzElement15.getBody());

        assertEquals(HttpStatus.OK, fizzBuzzElement2.getStatusCode());
        assertNotNull(fizzBuzzElement2.getBody());
        assertEquals("2", fizzBuzzElement2.getBody());

        assertEquals(HttpStatus.OK, fizzBuzzElement8.getStatusCode());
        assertNotNull(fizzBuzzElement8.getBody());
        assertEquals("8", fizzBuzzElement8.getBody());
    }

    @Test
    void calculateFizzBuzzForNegativeNumber() {
        // given

        // when
        ResponseEntity<ResponseExceptionDTO> response = restTemplate.exchange(FizzBuzzCalculationController.BASE_URL + "/?number=-2", HttpMethod.GET, new HttpEntity<>(null), ResponseExceptionDTO.class);

        // then
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(ErrorCode.INVALID_VALUE_FOR_NUMBER.name(), response.getBody().getErrorCode());
        assertEquals("Number must be greater than 0", response.getBody().getDescription());
    }

    @Test
    void calculateFizzBuzzFirst15And1000Elements() {
        // given

        // when
        ResponseEntity<String[]> fizzBuzzElements15 = restTemplate.exchange(FizzBuzzCalculationController.BASE_URL + "/first-n-element?n=15",
                HttpMethod.GET, new HttpEntity<>(null), String[].class);

        ResponseEntity<String[]> fizzBuzzElements1000 = restTemplate.exchange(FizzBuzzCalculationController.BASE_URL + "/first-n-element?n=1000",
                HttpMethod.GET, new HttpEntity<>(null), String[].class);

        // then
        assertEquals(HttpStatus.OK, fizzBuzzElements15.getStatusCode());
        assertNotNull(fizzBuzzElements15.getBody());
        List<String> expected = Arrays.asList(
                "1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz");
        assertEquals(expected, Arrays.asList(fizzBuzzElements15.getBody()));

        assertEquals(HttpStatus.OK, fizzBuzzElements1000.getStatusCode());
        assertNotNull(fizzBuzzElements1000.getBody());
        String[] expected2 = TestUtil.getObjectFromJson("src/test/resources/fizz-buzz-elements.json", String[].class);
        TestUtil.assertResult(fizzBuzzElements1000.getBody(), expected2);
    }
}
