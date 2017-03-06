package ua.ck.geekhub.task2.util;

import ua.ck.geekhub.task2.types.TypeChecker;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSorter {
    private TypeChecker checker = new TypeChecker();

    public ArrayList<File> getAudio(List<File> listFiles) {
        ArrayList<File> audios = new ArrayList<>();

        for (File file: listFiles) {
            if (checker.isAudio(file)) {
                audios.add(file);
            }
        }

        return audios;
    }

    public ArrayList<File> getVideo(List<File> listFiles) {
        ArrayList<File> videos = new ArrayList<>();

        for (File file: listFiles) {
            if (checker.isVideo(file)) {
                videos.add(file);
            }
        }

        return videos;
    }

    public ArrayList<File> getImage(List<File> listFiles) {
        ArrayList<File> images = new ArrayList<>();

        for (File file: listFiles) {
            if (checker.isImage(file)) {
                images.add(file);
            }
        }

        return images;
    }





}
