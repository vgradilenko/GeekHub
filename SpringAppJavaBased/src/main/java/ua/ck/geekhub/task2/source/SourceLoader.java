package ua.ck.geekhub.task2.source;

import org.springframework.context.annotation.Bean;
import ua.ck.geekhub.task2.SourceLoadingException;

import java.util.Arrays;
import java.util.List;

/**
 * SourceLoader should contains all implementations of SourceProviders to be able to load different sources.
 */

public class SourceLoader {

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

    @Bean
    public SourceLoader sourceLoader() {
        return new SourceLoader(Arrays.asList(
                new FileSourceProvider(), new URLSourceProvider()
        ));
    }
}
