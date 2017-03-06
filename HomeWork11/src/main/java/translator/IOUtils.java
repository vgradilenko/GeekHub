package translator;

import java.io.*;

public class IOUtils {
    public static String toString(InputStream data) throws IOException {
        StringBuilder content = new StringBuilder();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(data))) {

            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append("\n");
            }

        }

        return content.toString();
    }
}
