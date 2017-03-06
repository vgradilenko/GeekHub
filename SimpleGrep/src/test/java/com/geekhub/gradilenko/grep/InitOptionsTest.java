package com.geekhub.gradilenko.grep;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InitOptionsTest {
    private InitOptions options;
    @Before
    public void setUp() throws Exception {
        options = new InitOptions();
    }

    @After
    public void tearDown() throws Exception {
        options = null;
    }

    @Test
    public void getOptions() throws Exception {
        Assert.assertEquals(options.getOptions().hasOption("f"), true);
        Assert.assertEquals(options.getOptions().hasOption("w"), true);
        Assert.assertEquals(options.getOptions().hasOption("r"), true);
        Assert.assertEquals(options.getOptions().hasOption("u"), true);
        Assert.assertEquals(options.getOptions().hasOption("h"), true);
        Assert.assertEquals(options.getOptions().hasOption("g"), false);
    }

}