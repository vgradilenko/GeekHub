package ua.ck.geekhub.task2.types;

class Video implements FileType {
    private static final String AVI = ".avi";
    private static final String MP4 = ".mp4";
    private static final String FLV = "flv";

    @Override
    public boolean accept(java.io.File pathname) {
        if (pathname.isFile()) {
            if (pathname.getName().endsWith(AVI)
                    || pathname.getName().endsWith(MP4)
                    || pathname.getName().endsWith(FLV))
                return true;
        }

        return false;
    }
}
