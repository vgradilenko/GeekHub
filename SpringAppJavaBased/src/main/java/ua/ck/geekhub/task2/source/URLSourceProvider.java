package ua.ck.geekhub.task2.source;

import org.springframework.context.annotation.Bean;
import ua.ck.geekhub.task2.IOUtils;
import ua.ck.geekhub.task2.SourceLoadingException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Implementation for loading content from specified URL.<br/>
 * Valid paths to load are http://someurl.com, https://secureurl.com, ftp://frpurl.com etc.
 */
public class URLSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        try {
            new URL(pathToSource);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        try {
            return IOUtils.toString(new URL(pathToSource).openStream());
        } catch (IOException e) {
            throw new SourceLoadingException("server is not available", e);
        }
    }
    @Bean
    public URLSourceProvider urlSourceProvider() {
        return new URLSourceProvider();
    }
}
