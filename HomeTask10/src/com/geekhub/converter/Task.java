package com.geekhub.converter;

import java.io.IOException;
import java.net.URL;
import java.security.NoSuchAlgorithmException;

public class Task implements Runnable {

    private URL url;
    private String saveFolder;

    public Task(URL url, String saveFolder) {
        this.url = url;
        this.saveFolder = saveFolder;
    }

    @Override
    public void run() {
        try {
            IOUtils.appendContent(ConvertUtils.getHashMD5(IOUtils.toString(this.url.openStream())), saveFolder);
        } catch (IOException | NoSuchAlgorithmException e) {
            try {
                IOUtils.appendContent(ConvertUtils.getHashMD5(IOUtils.toString(this.url.openStream())), saveFolder);
            } catch (IOException | NoSuchAlgorithmException e1) {
                System.exit(0);
            }
        }
    }
}
