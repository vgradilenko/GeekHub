package com.geekhub.task1.translator.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOUtils {

    private IOUtils() {
    }

    public static String toString(InputStream in) throws IOException {
        StringBuilder content = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append("\n");
            }
        }

        return content.toString();
    }
}
