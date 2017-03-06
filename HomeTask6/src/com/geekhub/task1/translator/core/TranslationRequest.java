package com.geekhub.task1.translator.core;

import com.geekhub.task1.translator.core.language.Language;

public class TranslationRequest {

    private final String text;
    private final Language targetLanguage;

    public TranslationRequest(String text, Language targetLanguage) {
        this.text = text;
        this.targetLanguage = targetLanguage;
    }

    public String getText() {
        return text;
    }

    public Language getTargetLanguage() {
        return targetLanguage;
    }
}
