package ua.ck.geekhub.task2.util;

import ua.ck.geekhub.task2.ZipOperationException;

import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipUtils {

    public static void zipFiles(List<File> files, String zipName) throws ZipOperationException{
        FileOutputStream fos = null;
        ZipOutputStream zipOut = null;
        FileInputStream fis = null;

        try {
            fos = new FileOutputStream(zipName);
            zipOut = new ZipOutputStream(new BufferedOutputStream(fos));

            for(File file:files){

                fis = new FileInputStream(file);
                ZipEntry ze = new ZipEntry(file.getParentFile() + file.getName());
                System.out.println("Zipping the file: "+file.getName());
                zipOut.putNextEntry(ze);
                byte[] tmp = new byte[4*1024];
                int size = 0;
                while((size = fis.read(tmp)) != -1){
                    zipOut.write(tmp, 0, size);
                }

                zipOut.flush();
                fis.close();
            }
            zipOut.close();
            System.out.println("Done... Zipped the files...");
        } catch (FileNotFoundException e) {
            throw new ZipOperationException("File not found", e);
        } catch (IOException e) {
            throw new ZipOperationException("some problems with archiving", e);
        } finally{
            try{
                if(fos != null) fos.close();
            } catch(Exception e){
                throw new ZipOperationException("Stream not clause " + e);
            }
        }
    }
}
