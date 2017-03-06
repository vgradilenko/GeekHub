package com.geekhub.converter;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MD5Generator {
    private final int NUMBER_OF_THREADS = Runtime.getRuntime().availableProcessors() * 2;
    private ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    private String folder;

    public MD5Generator(String folder) {
        this.folder = folder;
    }

    public List<URL> getUrl(String byFile) throws IOException {
        ArrayList<URL> urls = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(byFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                urls.add(new URL(line));
            }
        }

        return urls;
    }

    public void convertContentToMD5(List<URL> tasks) {
        for (URL url : tasks) {
            executorService.submit(new Task(url, folder));
        }
    }

    public void stop() {
        executorService.shutdown();
    }
}
