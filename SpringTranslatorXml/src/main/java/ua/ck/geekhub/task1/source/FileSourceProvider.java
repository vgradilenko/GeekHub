package ua.ck.geekhub.task1.source;

import ua.ck.geekhub.task1.IOUtils;
import ua.ck.geekhub.task1.SourceLoadingException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Implementation for loading content from local file system.
 * This implementation supports absolute paths to local file system without specifying file:// protocol.
 * Examples c:/1.txt or d:/pathToFile/file.txt
 */

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
