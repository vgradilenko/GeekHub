package com.geekhub.converter;

import java.io.IOException;

public class Main {
    private static final String saveFolder = "C:\\java\\projects\\folder.txt";
    private static final String urlsFolder = "C:\\java\\projects\\GeekHub\\HomeTask10\\src\\com\\geekhub\\converter\\taskFile";

    public static void main(String[] args) throws IOException {
        MD5Generator generator = new MD5Generator(saveFolder);
        generator.convertContentToMD5(generator.getUrl(urlsFolder));
        generator.stop();
    }
}