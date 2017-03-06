package storage;

import objects.Entity;

import java.util.List;

public interface Storage {

    <T extends Entity> T get(Class<T> clazz, Integer id) throws StorageException;

    <T extends Entity> List<T> list(Class<T> clazz) throws StorageException;

    <T extends Entity> boolean delete(T entity) throws StorageException;

    <T extends Entity> void save(T entity) throws StorageException;
}
