package com.geekhub.userapp.web.pagination;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PaginationUtilsTest {
    private List<String> users;
    private PageRequest pageRequest;
    @Before
    public void setUp() throws Exception {
        pageRequest = new PageRequest(1, 3);
        users = new ArrayList<>();
    }

    @After
    public void tearDown() throws Exception {
      //  users = null;
        pageRequest = null;
    }

    @Test
    public void getPage() throws Exception {
        users.add("name1");
        users.add("name2");
        users.add("name3");
        users.add("name4");

        Page<String> page = PaginationUtils.getPage(users, pageRequest);
        Assert.assertEquals("get size", page.getItems().size(), 3);
        Assert.assertEquals("get user name1", page.getItems().get(0), "name1");
        Assert.assertEquals("get user name2", page.getItems().get(1), "name2");
        Assert.assertTrue(page.getItems().size() < users.size());
    }

}