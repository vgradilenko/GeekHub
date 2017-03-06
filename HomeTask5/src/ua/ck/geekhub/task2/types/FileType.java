package ua.ck.geekhub.task2.types;

import java.io.File;
import java.io.FileFilter;

interface FileType extends FileFilter {
    @Override
    boolean accept(File pathname);
}
