package com.geekhub.converter;

import java.io.*;

public class IOUtils {
    public static String toString(InputStream data) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(data))) {

            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append("\n");
            }
        }

        return content.toString();
    }

    public static synchronized void appendContent(String md5, String file) throws IOException {
        BufferedWriter writer;
        File hashes = new File(file);

        if (!hashes.exists()) {
            hashes.createNewFile();
        }

        if (hashes.canWrite()) {
            writer = new BufferedWriter(new FileWriter(hashes, true));
            writer.write(md5 + "\r\n");
            writer.flush();
            writer.close();
        }
    }
}
