package com.geekhub.gradilenko.grep.parser;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextContentParser implements ContentParser {

    @Override
    public String parseContent(List<String> content, String word) {
        StringBuilder builder = new StringBuilder();
        Pattern pattern = Pattern.compile(word, Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE);

        for (String line : content) {
            Matcher matcher = pattern.matcher(line);
            String preparedLine = "";

            while (matcher.find()) {
                preparedLine = line.replaceAll("((?i)" + word + ")", "#$1#");
            }

            builder.append(preparedLine);
            builder.append("\n");
        }

        return builder.toString();
    }
}
