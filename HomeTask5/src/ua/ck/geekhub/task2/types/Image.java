package ua.ck.geekhub.task2.types;

class Image implements FileType {
    private static final String JPEG = ".jpeg";
    private static final String JPG = ".jpg";
    private static final String GIF = ".gif";
    private static final String PNG = ".png";

    @Override
    public boolean accept(java.io.File pathname) {
        if (pathname.isFile()) {
            if (pathname.getName().endsWith(JPEG)
                    || pathname.getName().endsWith(JPG)
                    || pathname.getName().endsWith(GIF)
                    || pathname.getName().endsWith(PNG)) {
                return true;
            }
        }

        return false;
    }
}
