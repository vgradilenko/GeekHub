package ua.ck.geekhub.task2;

import ua.ck.geekhub.task2.util.ZipUtils;

import java.util.Scanner;

public class ZipFileMakerController {

    public static void main(String[] args) throws ZipOperationException {
        Scanner scanner = new Scanner(System.in);
        String dir = scanner.next();
        ZipFileMaker fileMaker = new ZipFileMaker(dir);

        ZipUtils.zipFiles(fileMaker.getAudios(), "/home/grava/java/tmpFolder/audio.zip");
        ZipUtils.zipFiles(fileMaker.getImages(), "/home/grava/java/tmpFolder/image.zip");
        ZipUtils.zipFiles(fileMaker.getVideos(), "/home/grava/java/tmpFolder/video.zip");

        System.out.println("check zip archive");
    }
}
