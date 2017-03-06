package translator.source;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import translator.SourceLoadingException;

import java.io.*;

import static org.junit.Assert.*;

public class FileSourceProviderTest {
    private FileSourceProvider fileSourceProvider;

    @Before
    public void init() {
        fileSourceProvider = new FileSourceProvider();
    }

    @After
    public void destroy() {
        fileSourceProvider = null;
    }

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void isAllowed() throws Exception {
        folder.create();
        File file = folder.newFile("file");
        folder.delete();

        assertFalse(fileSourceProvider.isAllowed(file.getCanonicalPath()));
        assertFalse(folder.getRoot().exists());
    }

    @Test(expected = SourceLoadingException.class)
    public void testToThrowSourceLoadingException() throws Exception {
        fileSourceProvider.load("");
    }
}