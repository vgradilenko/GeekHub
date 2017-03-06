package ua.ck.geekhub.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ua.ck.geekhub.task1.source.SourceLoader;

import java.io.IOException;
import java.util.Scanner;

public class TranslatorController {

    public static void main(String[] args) throws IOException, TranslateException {

        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        SourceLoader loader = context.getBean(SourceLoader.class);
        Translator translator = context.getBean(Translator.class);

        Scanner scanner = new Scanner(System.in);
        String command = scanner.next();

        while (!"exit".equals(command)) {
            try {
                String source = loader.loadSource(command);
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
