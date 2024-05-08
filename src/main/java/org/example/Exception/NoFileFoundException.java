package org.example.Exception;

import java.nio.file.NoSuchFileException;

public class NoFileFoundException extends NoSuchFileException {
    public NoFileFoundException(String message) {
        super(message);
    }
}
