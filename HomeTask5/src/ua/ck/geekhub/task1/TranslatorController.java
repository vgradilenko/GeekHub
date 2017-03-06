package ua.ck.geekhub.task1;

import ua.ck.geekhub.task1.source.SourceLoader;
import ua.ck.geekhub.task1.source.URLSourceProvider;

import java.io.IOException;
import java.util.Scanner;

public class TranslatorController {

    public static void main(String[] args) throws IOException, TranslateException {
        SourceLoader sourceLoader = new SourceLoader();
        Translator translator = new Translator(new URLSourceProvider());

        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();
        while (!"exit".equals(command)) {
            try {
                String source = sourceLoader.loadSource(command);
                String translation = translator.translate(source);

                System.out.println("Original: " + source);
                System.out.println("Translation: " + translation);
            } catch (Exception e) {
                System.err.println("Enter valid path to file or url");
            } finally {
                command = scanner.next();
            }
        }
    }
}
