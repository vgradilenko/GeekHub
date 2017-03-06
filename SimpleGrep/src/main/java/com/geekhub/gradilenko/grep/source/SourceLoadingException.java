package com.geekhub.gradilenko.grep.source;

import java.io.IOException;

public class SourceLoadingException extends IOException {

    public SourceLoadingException(Throwable cause) {
        super(cause);
    }

    public SourceLoadingException() {
        super();
    }

}
