package com.geekhub.gradilenko.grep.source;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.ArrayList;
import java.util.StringJoiner;

import static org.junit.Assert.*;

/**
 * Created by grava on 06.02.2017.
 */
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

    @Test
    public void load() throws Exception {
        folder.create();
        File file = folder.newFile("file");
        assertEquals(new ArrayList<String>(), fileSourceProvider.load(file.getPath()));
    }

    @Test(expected = SourceLoadingException.class)
    public void testToThrowSourceLoadingException() throws Exception {
        fileSourceProvider.load("");
    }

}