package hu.sprintform.gsomogyi.fizz.buzz.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import hu.sprintform.gsomogyi.fizz.buzz.dto.exception.FizzBuzzRuntimeException;
import org.assertj.core.api.Assertions;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class TestUtil {

    private static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private static final ObjectMapper objectMapper = new ObjectMapper();

    private static String readResource(final String path) {
        try {
            final URL fileUrl = ResourceUtils.getURL(path);
            return Files.lines(Paths.get(fileUrl.toURI()), StandardCharsets.UTF_8)
                    .collect(Collectors.joining(LINE_SEPARATOR));
        } catch (URISyntaxException | IOException e) {
            throw new FizzBuzzRuntimeException(e.getMessage(), e);
        }
    }

    public static <T> T getObjectFromJson(final String jsonClassPath, final Class<T> type) {
        try {
            final String fileContent = readResource(jsonClassPath);
            return objectMapper.readValue(fileContent, type);
        } catch (final JsonProcessingException e) {
            throw new FizzBuzzRuntimeException(e.getMessage(), e);
        }
    }

    public static void assertResult(final Object result, final Object expected) {
        Assertions.assertThat(result).isEqualTo(expected);
    }
}
