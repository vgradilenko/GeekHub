package ua.ck.geekhub.task2.types;

import java.io.File;

public class TypeChecker {
    private FileType type = null;

    public TypeChecker() {
    }

    public boolean isAudio(File file) {
        type = new Audio();

        return type.accept(file);

    }

    public boolean isVideo(File file) {
        type = new Video();

        return type.accept(file);

    }

    public boolean isImage(File file) {
        type = new Image();

        return type.accept(file);
    }
}
