package ua.ck.geekhub.task2.source;

import ua.ck.geekhub.task2.IOUtils;
import org.springframework.stereotype.Component;
import ua.ck.geekhub.task2.SourceLoadingException;

import java.io.*;

/**
 * Implementation for loading content from local file system.
 * This implementation supports absolute paths to local file system without specifying file:// protocol.
 * Examples c:/1.txt or d:/pathToFile/file.txt
 */
@Component
public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        return new File(pathToSource).isFile();

    }

    @Override
    public String load(String pathToSource) throws SourceLoadingException {
        try {
            return IOUtils.toString(new FileInputStream(pathToSource));
        } catch (IOException e) {
            throw new SourceLoadingException("File not available", e);
        }
    }
}
