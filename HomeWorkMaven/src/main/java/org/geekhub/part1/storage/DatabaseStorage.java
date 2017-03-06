package org.geekhub.part1.storage;

import org.geekhub.part1.objects.Entity;
import org.geekhub.part1.objects.Ignore;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.*;

/**
 * Implementation of {@link Storage} that uses database as a storage for objects.
 * It uses simple object type names to define target table to save the object.
 * It uses reflection to access objects fields and retrieve data to map to database tables.
 * As an identifier it uses field id of {@link Entity} class.
 * Could be created only with {@link Connection} specified.
 */
public class DatabaseStorage implements Storage {

    private Connection connection;

    public DatabaseStorage(Connection connection) {
        this.connection = connection;
    }

    @Override
    public <T extends Entity> T get(Class<T> clazz, Integer id) throws StorageException {
        String sql = "SELECT * FROM " + clazz.getSimpleName().toLowerCase() + " WHERE id = " + id;
        try (Statement statement = connection.createStatement()) {
            List<T> result = extractResult(clazz, statement.executeQuery(sql));
            return result.isEmpty() ? null : result.get(0);
        } catch (Exception e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> List<T> list(Class<T> clazz) throws StorageException {
        String sql = "SELECT * FROM " + clazz.getSimpleName().toLowerCase();
        try (Statement statement = connection.createStatement()) {
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
        try (Statement statement = connection.createStatement()) {
            return statement.executeUpdate(sql) > 0;
        } catch (SQLException e) {
            throw new StorageException(e);
        }
    }

    @Override
    public <T extends Entity> int delete(Class<T> clazz) throws StorageException {
        List<T> list = this.list(clazz);
        if (list.isEmpty()) {
            return 0;
        }

        int count = 0;

        for (T object : list) {
            this.delete(object);
            count++;
        }

        return count;
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

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
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
        buildQuery.append(entity.getClass().getSimpleName().toLowerCase());
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
        buildQuery.append(entity.getClass().getSimpleName().toLowerCase());
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