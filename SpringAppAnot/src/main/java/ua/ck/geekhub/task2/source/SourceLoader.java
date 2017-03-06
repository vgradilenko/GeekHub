package ua.ck.geekhub.task2.source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.ck.geekhub.task2.SourceLoadingException;

import java.util.List;

/**
 * SourceLoader should contains all implementations of SourceProviders to be able to load different sources.
 */
@Component
public class SourceLoader {

    @Autowired
    private final List<SourceProvider> sourceProviders;

    public SourceLoader(List<SourceProvider> sourceProviders) {
        this.sourceProviders = sourceProviders;
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
