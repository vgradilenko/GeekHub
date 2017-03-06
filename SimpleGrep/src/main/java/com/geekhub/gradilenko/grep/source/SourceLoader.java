package com.geekhub.gradilenko.grep.source;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SourceLoader {
    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader() {
        sourceProviders.add(new FileSourceProvider());
        sourceProviders.add(new URLSourceProvider());
    }

    public List<String> loadSource(String pathToSource) throws SourceLoadingException {
        for (SourceProvider provider : sourceProviders) {
            if (provider.isAllowed(pathToSource)) {
                try {
                    return provider.load(pathToSource);
                } catch (IOException e) {
                    throw new SourceLoadingException(e);
                }
            } else {
                throw new SourceLoadingException();
            }
        }

        return null;
    }
}
