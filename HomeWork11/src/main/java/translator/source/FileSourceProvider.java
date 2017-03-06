package translator.source;

import translator.IOUtils;
import translator.SourceLoadingException;
import java.io.*;

/**
 * Implementation for loading content from local file system.
 * This implementation supports absolute paths to local file system without specifying file:// protocol.
 * Examples c:/1.txt or d:/pathToFile/file.txt
 */
public class FileSourceProvider implements SourceProvider {

    @Override
    public boolean isAllowed(String pathToSource) {
        if (new File(pathToSource).isFile()) {
            return true;
        }

        return false;
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
