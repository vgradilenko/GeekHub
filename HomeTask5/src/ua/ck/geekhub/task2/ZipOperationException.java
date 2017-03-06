package ua.ck.geekhub.task2;

public class ZipOperationException extends Exception{
    public ZipOperationException() {
        super();
    }

    public ZipOperationException(String massage) {
        super(massage);
    }

    public ZipOperationException(String masage, Throwable e) {
        super(masage, e);
    }
}
