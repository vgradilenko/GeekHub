package ua.ck.geekhub.task2;

import ua.ck.geekhub.task2.util.FileSorter;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ZipFileMaker {
    private FileSorter sorter = new FileSorter();

    private String dir;
    private List<File> videos = sorter.getVideo(listf(this.dir));
    private List<File> images = sorter.getImage(listf(this.dir));
    private List<File> audios = sorter.getAudio(listf(this.dir));

    public ZipFileMaker(String dir) {
        this.dir = dir;
    }

    private List<File> listf(String directoryName) {
        File directory = new File(directoryName);

        List<File> resultList = new ArrayList<>();

        File[] fList = directory.listFiles();
        resultList.addAll(Arrays.asList(fList));
        for (File file : fList) {
            if (file.isDirectory()) {
                resultList.addAll(listf(file.getAbsolutePath()));
            }
        }

        return resultList;
    }

    public List<File> getVideos() {
        return videos;
    }

    public List<File> getImages() {
        return images;
    }

    public List<File> getAudios() {
        return audios;
    }
}
