package exception;

import java.io.FileNotFoundException;
import java.io.IOException;

public class FileException extends IOException {
    public FileException(String message) {
        super(message);
    }
}
