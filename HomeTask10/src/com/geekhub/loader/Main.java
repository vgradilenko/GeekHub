package com.geekhub.loader;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static final String FOLDER_TO_DOWNLOAD = "C:\\java\\projects\\tmp";

    public static void main(String[] args) throws IOException {
        ImageCrawler imageCrawler = new ImageCrawler(FOLDER_TO_DOWNLOAD);
        imageCrawler.downloadImages("http://chto-takoe-lyubov.net/kartinki-pro-lyubov");

        System.out.println("While it's loading you can enter another url to start download images:");

        Scanner scanner = new Scanner(System.in);
        String command;
        while (!"exit".equals(command = scanner.next())) {
            imageCrawler.downloadImages(command);
            System.out.println("...and another url:");
        }
        imageCrawler.stop();
    }
}
