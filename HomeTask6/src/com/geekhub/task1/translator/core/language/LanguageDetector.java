package com.geekhub.task1.translator.core.language;

import java.io.IOException;

public interface LanguageDetector {

    Language detect(String text) throws LanguageDetectorException, IOException;
}
