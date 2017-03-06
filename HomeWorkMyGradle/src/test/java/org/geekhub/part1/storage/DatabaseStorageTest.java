package org.geekhub.part1.storage;

import org.geekhub.part1.objects.Cat;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class DatabaseStorageTest {
    private Connection connection;
    private DatabaseStorage storage;
    private Cat cat;
    private String insert;

    @Before
    public void setUp() throws Exception {
        connection = createConnection("sa", "");
        storage = new DatabaseStorage(connection);

        cat = new Cat();
        cat.setAge(12);
        cat.setName("bob");

        String createTable = "CREATE TABLE CAT\n" +
                "(\n" +
                "    ID INTEGER DEFAULT 1 AUTO_INCREMENT PRIMARY KEY NOT NULL,\n" +
                "    NAME VARCHAR(45),\n" +
                "    AGE INTEGER\n" +
                ")";

        insert = "INSERT INTO TESTDB.PUBLIC.CAT(name, age) VALUES (?,?)";

        PreparedStatement statement = connection.prepareStatement(createTable);
        statement.executeUpdate();
    }

    @After
    public void tearDown() throws Exception {
        connection.close();
        storage = null;
        cat = null;
    }

    @Test
    public void testGetToIdentityDataById() throws Exception {
        PreparedStatement statement = connection.prepareStatement(insert);

        statement.setString(1, cat.getName());
        statement.setInt(2, cat.getAge());
        statement.executeUpdate();

        Assert.assertEquals(storage.get(cat.getClass(), 1).getName(), cat.getName());
        Assert.assertEquals(storage.get(cat.getClass(), 1).getAge(), cat.getAge());
    }

    @Test
    public void testGetToNull() throws Exception {
        PreparedStatement statement = connection.prepareStatement(insert);

        statement.setString(1, cat.getName());
        statement.setInt(2, cat.getAge());
        statement.executeUpdate();

        Assert.assertNull(storage.get(cat.getClass(), 2));
    }

    @Test
    public void checkListToTwoInsert() throws Exception {
        PreparedStatement statement = connection.prepareStatement(insert);

        statement.setString(1, "bob");
        statement.setString(2, "10");
        statement.execute();
        statement.setString(1, "bib");
        statement.setString(2, "2");
        statement.executeUpdate();

        List<Cat> tmp = new ArrayList<>();
        tmp.add(new Cat("bob", 10));
        tmp.add(new Cat("bib", 2));

        Assert.assertEquals(storage.list(cat.getClass()).get(0), tmp.get(0));
        Assert.assertEquals(storage.list(cat.getClass()).get(1), tmp.get(1));
    }

    @Test
    public void checkListSize() throws Exception {
        PreparedStatement statement = connection.prepareStatement(insert);

        for (int i = 0; i < 5; i++) {
            statement.setString(1, "bob" + i);
            statement.setInt(2, i);
            statement.execute();
        }

        Assert.assertEquals(storage.list(cat.getClass()).size(), 5);
    }

    @Test
    public void emptyListMustReturnedEmptyList() throws Exception {
        Assert.assertEquals(storage.list(cat.getClass()).size(), 0);
    }


    @Test
    public void checkDeleteAllClazzFromDBMustReturnedCount() throws Exception {
        PreparedStatement statement = connection.prepareStatement(insert);

        for (int i = 0; i < 5; i++) {
            statement.setString(1, "bob" + i);
            statement.setInt(2, i);
            statement.execute();
        }

        Assert.assertEquals(storage.delete(cat.getClass()), 5);
        Assert.assertEquals(storage.delete(cat.getClass()), 0);
    }

    @Test
    public void checkBooleanDeleteMustBeThree() throws Exception {
        PreparedStatement statement = connection.prepareStatement(insert);

        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("bob", 3));
        cats.add(new Cat("bib", 1));
        cats.add(new Cat("bub", 2));

        for (int i = 0; i < cats.size(); i++) {
            statement.setString(1, cats.get(i).getName());
            statement.setInt(2, cats.get(i).getAge());
            statement.executeUpdate();
        }

        Assert.assertEquals(storage.delete(cat.getClass()), cats.size());
        Assert.assertEquals(storage.list(cat.getClass()), new ArrayList<Cat>());
    }

    @Test
    public void checkSaveToDb() throws Exception {
        cat = new Cat("dark", 7);
        storage.save(cat);

        Assert.assertTrue(storage.list(cat.getClass()).contains(cat));
    }

    @Test
    public void checkUpdateDataInDb() throws Exception {
        PreparedStatement statement = connection.prepareStatement(insert);
        statement.setString(1, "bib");
        statement.setInt(2, 1);
        statement.execute();

        cat = new Cat("bob", 10);
        cat.setId(storage.list(cat.getClass()).get(0).getId());

        storage.save(cat);

        Assert.assertEquals(storage.get(cat.getClass(), 1).getName(), cat.getName());
        Assert.assertEquals(storage.get(cat.getClass(), 1).getAge(), cat.getAge());
    }

    private Connection createConnection(String login, String password) throws Exception {
        Class.forName("org.h2.Driver").newInstance();
        Connection connection = DriverManager.getConnection("jdbc:h2:mem:testdb", login, password);
        return connection;
    }
}