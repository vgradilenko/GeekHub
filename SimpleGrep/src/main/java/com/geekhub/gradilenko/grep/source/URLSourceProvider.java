package com.geekhub.gradilenko.grep.source;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

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
    public List<String> load(String pathToSource) throws SourceLoadingException {
        try {
            return IOUtils.readLines(new InputStreamReader(new URL(pathToSource).openStream()));
        } catch (IOException e) {
            throw new SourceLoadingException(e);
        }
    }
}
