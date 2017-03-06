package com.geekhub.task1.translator;

import com.geekhub.task1.translator.core.Translation;
import com.geekhub.task1.translator.core.TranslationRequest;
import com.geekhub.task1.translator.core.Translator;
import com.geekhub.task1.translator.core.language.Language;
import com.geekhub.task1.translator.core.language.LanguageDetector;
import com.geekhub.task1.translator.core.language.LanguageDetectorException;
import com.geekhub.task1.translator.util.EncodingUtils;
import com.geekhub.task1.translator.util.IOUtils;
import org.json.JSONObject;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;

public class YandexTranslator implements Translator {

    private static final String YANDEX_TRANSLATOR_API_URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?key=%s&text=%s&lang=%s";

    private final String apiKey;
    private final LanguageDetector languageDetector;


    public YandexTranslator(String apiKey, LanguageDetector languageDetector) {
        this.apiKey = apiKey;
        this.languageDetector = languageDetector;
    }

    @Override
    public Translation translate(TranslationRequest translationRequest) throws IOException {
        try {
            String preparedUrl = String.format(YANDEX_TRANSLATOR_API_URL, this.apiKey, translationRequest.getText(),
                    prepareLanguageDirection(languageDetector.detect(translationRequest.getText()),
                            translationRequest.getTargetLanguage()));

            if (languageDetector.detect(translationRequest.getText()).equals(translationRequest.getTargetLanguage())) {
                return new Translation(translationRequest.getText(),
                        translationRequest.getTargetLanguage(),
                        translationRequest.getText(),
                        translationRequest.getTargetLanguage());
            } else {
                return new Translation(translationRequest.getText(),
                        languageDetector.detect(translationRequest.getText()),
                        getTranslationText(preparedUrl),
                        translationRequest.getTargetLanguage());
            }
        } catch (LanguageDetectorException e) {
            System.out.println("Language is not support");
        }

        return null;
    }

    private String prepareLanguageDirection(Language from, Language to) {
        return from.getCode() + "-" + to.getCode();
    }

    private String getTranslationText(String content) {
        try {
            return getTextFromJson(IOUtils.toString(new URL(content).openStream()));
        } catch (IOException e) {
            System.out.println("Check your internet connection");
        }

        return null;
    }

    private String getTextFromJson(String content) {
        try {
            EncodingUtils.encode(content, "UTF-8");
            JSONObject object = new JSONObject(content);
            return prepareContent(String.valueOf(object.getJSONArray("text")));
        } catch (UnsupportedEncodingException e) {
            System.out.println("problems wish encoding content");
        }

        return null;
    }

    private String prepareContent(String content) {
        return content.replace("[\"", "").replace("\"]", "");
    }
}
