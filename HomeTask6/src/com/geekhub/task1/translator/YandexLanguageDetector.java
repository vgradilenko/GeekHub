package com.geekhub.task1.translator;

import com.geekhub.task1.translator.core.language.Language;
import com.geekhub.task1.translator.core.language.LanguageDetector;
import com.geekhub.task1.translator.util.IOUtils;
import org.json.JSONObject;
import java.io.IOException;
import java.net.URL;

public class YandexLanguageDetector implements LanguageDetector {

    private static final String YANDEX_LANGUAGE_DETECTOR_API_URL = "https://translate.yandex.net/api/v1.5/tr.json/detect?key=%s&text=%s";

    private final String apiKey;

    public YandexLanguageDetector(String apiKey) {
        this.apiKey = apiKey;
    }

    // FIXME: 27.11.16 Language.find()
    @Override
    public Language detect(String text) {
        if (getLangFromJson(text).equals("en")) {
            return Language.ENGLISH;
        } else if (getLangFromJson(text).equals("ru")) {
            return Language.RUSSIAN;
        } else if (getLangFromJson(text).equals("ua")) {
            return Language.UKRAINIAN;
        }

        return null;
    }

    private String getLangFromJson(String content) {
        try {
            String request = toYandexServer(content);
            JSONObject jObj = new JSONObject(request);
            return jObj.getString("lang");
        } catch (IOException e) {
            System.out.println("some problems wish pursing content ");
        }
        return null;
    }

    private String toYandexServer(String content) throws IOException {
        return IOUtils.toString(new URL(String.format(YANDEX_LANGUAGE_DETECTOR_API_URL, this.apiKey, content)).openStream());
    }
}
