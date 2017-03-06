package ua.ck.geekhub.task1;

public class TranslateException extends Exception {
    public TranslateException() {
        super();
    }

    public TranslateException(String massage) {
        super(massage);
    }

    public TranslateException(String massage, Throwable cause) {
        super(massage, cause);
    }
}
