package ua.ck.geekhub.task2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ua.ck.geekhub.task2.source.FileSourceProvider;
import ua.ck.geekhub.task2.source.SourceLoader;
import ua.ck.geekhub.task2.source.URLSourceProvider;

import java.util.Arrays;

@Configuration
@PropertySource("classpath:translator.properties")
public class Config {

    @Value("${translator.apiKey}")
    public String apiKey;

    @Bean
    FileSourceProvider fileSourceProvider () {
        return new FileSourceProvider();
    }

    @Bean
    public URLSourceProvider urlSourceProvider() {
        return new URLSourceProvider();
    }

    @Bean
    public Translator translator() {
        return new Translator(urlSourceProvider(), apiKey);
    }
    @Bean
    public SourceLoader sourceLoader() {
        return new SourceLoader(Arrays.asList(
                fileSourceProvider(), urlSourceProvider()
        ));
    }



}
