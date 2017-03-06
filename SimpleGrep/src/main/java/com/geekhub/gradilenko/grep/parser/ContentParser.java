package com.geekhub.gradilenko.grep.parser;

import java.util.List;

public interface ContentParser {
    String parseContent(List<String> content, String word);
}
