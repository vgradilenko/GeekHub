package com.geekhub.loader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Utils class that contains useful method to interact with URLConnection
 */
public class ConnectionUtils {

    /**
     * Downloads content for specified URL and returns it as a byte array.
     * Should be used for small files only. Don't use it to download big files it's dangerous.
     *
     * @param url
     * @return
     * @throws java.io.IOException
     */
    public static byte[] getData(URL url) throws IOException {
        URLConnection connection = url.openConnection();

        try (InputStream in = connection.getInputStream();
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
            byte[] buff = new byte[512];

            int block;
            while ((block = in.read(buff)) != -1) {
                byteArray.write(buff, 0, block);
            }

            byteArray.flush();
            return byteArray.toByteArray();
        }
    }
}
