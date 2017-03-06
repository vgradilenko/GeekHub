package com.geekhub.gradilenko.grep.source;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

public class FileSourceProvider implements SourceProvider {

    public boolean isAllowed(String pathToSource) {
        return new File(pathToSource).isFile();
    }

    public List<String> load(String pathToSource) throws SourceLoadingException {
        try {
            return IOUtils.readLines(new FileReader(pathToSource));
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
    }
}
