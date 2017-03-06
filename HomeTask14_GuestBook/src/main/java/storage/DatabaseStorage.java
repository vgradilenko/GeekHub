package storage;

import objects.Entity;
import objects.Ignore;
import org.apache.commons.dbcp.BasicDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class DatabaseStorage implements Storage {

    private BasicDataSource dataSource;

    public DatabaseStorage() {
        dataSource = new BasicDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost/spam");
        dataSource.setUsername("root");
        dataSource.setPassword("qwerty13");
    }

    @Override
    public <T extends Entity> T get(Class<T> clazz, Integer id) throws StorageException {
        String sql = "SELECT * FROM " + clazz.getSimpleName().toLowerCase() + " WHERE id = " + id;
        try (Statement statement = dataSource.getConnection().createStatement()) {
            List<T> result = extractResult(clazz, statement.executeQuery(sql));
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> List<T> list(Class<T> clazz) throws StorageException {
        String sql = "SELECT * FROM " + clazz.getSimpleName().toLowerCase();
        try (Statement statement = dataSource.getConnection().createStatement()) {
            return extractResult(clazz, statement.executeQuery(sql));
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> boolean delete(T entity) throws StorageException {
        if (entity.isNew()) {
            return false;
        }
        String sql = "DELETE FROM " + entity.getClass().getSimpleName().toLowerCase() + " WHERE id = " + entity.getId();
        try (Statement statement = dataSource.getConnection().createStatement()) {
            return statement.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> void save(T entity) throws StorageException {
        Map<String, Object> map = null;
        String sql;
        try {
            map = prepareEntity(entity);
        } catch (IllegalAccessException e) {
            throw new StorageException(e);
        }

        if (entity.isNew()) {
            sql = createInsertQuery(map, entity);
        } else {
            sql = createUpdateQuery(map, entity);
        }

        try (PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            int key = 1;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                preparedStatement.setObject(key++, entry.getValue());
            }

            preparedStatement.executeUpdate();

            if (entity.isNew()) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                if (resultSet.next()) {
                    entity.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw new StorageException(e);
        }

    }

    private <T extends Entity> Map<String, Object> prepareEntity(T entity) throws IllegalAccessException {
        Map<String, Object> preparedEntity = new HashMap<>();
        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            if (!field.isAnnotationPresent(Ignore.class)) {
                preparedEntity.put(field.getName(), field.get(entity));
            }
        }

        return preparedEntity;
    }

    private <T extends Entity> List<T> extractResult(Class<T> clazz, ResultSet resultSet) throws Exception {
        List<T> objects = new ArrayList<>();

        while (resultSet.next()) {
            T object = clazz.newInstance();
            object.setId(resultSet.getInt("id"));

            for (Field field : clazz.getDeclaredFields()) {
                field.setAccessible(true);

                if (!field.isAnnotationPresent(Ignore.class)) {
                    field.set(object, resultSet.getObject(field.getName()));
                }
            }

            objects.add(object);
        }

        return objects;
    }

    private <T extends Entity> String createInsertQuery(Map<String, Object> preparedEntity, T entity) {
        StringBuilder buildQuery = new StringBuilder();

        buildQuery.append("INSERT INTO ");
        buildQuery.append(entity.getClass().getSimpleName());
        buildQuery.append(" (");

        for (String key : preparedEntity.keySet()) {
            buildQuery.append(key);
            buildQuery.append(", ");
        }

        buildQuery.deleteCharAt(buildQuery.length() - 2);
        buildQuery.append(") VALUES (");

        for (int i = 0; i < preparedEntity.size(); i++) {
            if (i == 0) {
                buildQuery.append("?");
            } else {
                buildQuery.append(", ?");
            }
        }

        buildQuery.append(")");
        return buildQuery.toString();
    }

    private <T extends Entity> String createUpdateQuery(Map<String, Object> preparedEntity, T entity) {
        StringBuilder buildQuery = new StringBuilder();

        buildQuery.append("UPDATE ");
        buildQuery.append(entity.getClass().getSimpleName());
        buildQuery.append(" SET ");

        for (String key : preparedEntity.keySet()) {
            buildQuery.append(key);
            buildQuery.append("= ? , ");
        }

        buildQuery.deleteCharAt(buildQuery.length() - 2);
        buildQuery.append(" WHERE id=");
        buildQuery.append(entity.getId());

        return buildQuery.toString();
    }
}