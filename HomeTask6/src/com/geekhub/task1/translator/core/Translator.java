package com.geekhub.task1.translator.core;

import java.io.IOException;

public interface Translator {

    Translation translate(TranslationRequest translationRequest) throws TranslatorException, IOException;
}
