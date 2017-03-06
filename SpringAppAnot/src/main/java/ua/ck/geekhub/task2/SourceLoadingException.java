package ua.ck.geekhub.task2;

import java.io.IOException;

/**
 * Created by grava on 18.11.16.
 */
public class SourceLoadingException extends IOException {
    public SourceLoadingException() {
        super();
    }

    public SourceLoadingException(String massage) {
        super(massage);
    }

    public SourceLoadingException(String massage, Throwable cause) {
        super(massage, cause);
    }
}
