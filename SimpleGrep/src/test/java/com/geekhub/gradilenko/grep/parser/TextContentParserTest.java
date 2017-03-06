package com.geekhub.gradilenko.grep.parser;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TextContentParserTest {
    private TextContentParser contentParser;
    List<String> strings;

    @Before
    public void setUp() throws Exception {
        contentParser = new TextContentParser();

        strings = new ArrayList<>();
        strings.add("test, Test, TEST, tESt, hello");

    }

    @After
    public void tearDown() throws Exception {
        contentParser = null;
        strings = null;
    }

    @Test
    public void parseContent() throws Exception {
        String str = "#test#, #Test#, #TEST#, #tESt#, hello"+ "\n";
        Assert.assertEquals(contentParser.parseContent(strings, "test"),  str);
    }

}