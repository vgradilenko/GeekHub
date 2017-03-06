package ua.ck.geekhub.task1.source;

import ua.ck.geekhub.task1.SourceLoadingException;

import java.util.ArrayList;
import java.util.List;

/**
 * SourceLoader should contains all implementations of SourceProviders to be able to load different sources.
 */

public class SourceLoader {
    private List<SourceProvider> sourceProviders = new ArrayList<>();

    public SourceLoader(String s) {
    }

    public List<SourceProvider> getSourceProviders() {
        return sourceProviders;
    }

    public void setSourceProviders(List<SourceProvider> sourceProviders) {
        this.sourceProviders = sourceProviders;
    }

    public SourceLoader() {
    }

    public String loadSource(String pathToSource) throws SourceLoadingException {
        for (SourceProvider provider : sourceProviders) {
            if (provider.isAllowed(pathToSource)) {
                return provider.load(pathToSource);
            }
        }

        return null;
    }
}
