package translator;

import java.io.IOException;

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
