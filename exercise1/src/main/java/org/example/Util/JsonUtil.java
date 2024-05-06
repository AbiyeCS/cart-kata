package org.example.Util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.file.Path;

public class JsonUtil {
    public static final Path JSON_FILE_ROOT =
            Path.of("exercise1/src/test/resources");

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T readJSONString(String jsonString, Class<T> clazz)
            throws JsonProcessingException {
        return objectMapper.readValue(jsonString, clazz);
    }
}
