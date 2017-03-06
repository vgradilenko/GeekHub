package com.geekhub.task1.translator;

import com.geekhub.task1.translator.core.Translation;
import com.geekhub.task1.translator.core.TranslationRequest;
import com.geekhub.task1.translator.core.Translator;
import com.geekhub.task1.translator.core.TranslatorException;
import com.geekhub.task1.translator.core.language.Language;
import com.geekhub.task1.translator.core.language.LanguageDetector;
import com.geekhub.task1.translator.core.language.UnknownLanguageException;
import java.io.IOException;
import java.util.Scanner;

public class TranslatorController {

    public static void main(String[] args) throws IOException {
        LanguageDetector languageDetector = new YandexLanguageDetector("trnsl.1.1.20161117T144542Z.1ae226c217cae6b7.32abe0e8d47fbdc2cca4c9cfe715b7b5a189b410");
        Translator translator = new YandexTranslator("trnsl.1.1.20161117T144542Z.1ae226c217cae6b7.32abe0e8d47fbdc2cca4c9cfe715b7b5a189b410", languageDetector);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String text = scanner.nextLine();
            if ("exit".equals(text)) {
                break;
            }

            try {
                String targetLanguage = scanner.nextLine();
                TranslationRequest translationRequest = new TranslationRequest(text, Language.find(targetLanguage));
                Translation translation = translator.translate(translationRequest);

                System.out.println("Original text: " + translation.getOriginalText());
                System.out.println("Original language: " + translation.getOriginalLanguage());

                System.out.println("Translated text: " + translation.getTranslatedText());
                System.out.println("Target language: " + translation.getTargetLanguage());
            } catch (UnknownLanguageException e) {
                System.out.println("Language '" + e.getUnknownLanguage() + "' is not supported yet");
                break;
            } catch (TranslatorException e) {
                System.out.println("Something went wrong during translating");
                break;
            }
        }
    }
}
