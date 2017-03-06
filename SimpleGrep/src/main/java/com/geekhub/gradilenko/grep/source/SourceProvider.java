package com.geekhub.gradilenko.grep.source;

import java.util.List;

public interface SourceProvider {

    boolean isAllowed(String pathToSource);

    List<String> load(String pathToSource) throws SourceLoadingException;
}
