package ua.ck.geekhub.task2.types;

class Audio implements FileType {
    private static final String MP3 = ".mp3";
    private static final String WAV = ".wav";
    private static final String WMA = ".wma";

    public boolean accept(java.io.File pathname) {
        if (pathname.isFile()) {
            if (pathname.getName().endsWith(MP3)
                    || pathname.getName().endsWith(WAV)
                    || pathname.getName().endsWith(WMA)) {
                return true;
            }
        }

        return false;
    }
}
