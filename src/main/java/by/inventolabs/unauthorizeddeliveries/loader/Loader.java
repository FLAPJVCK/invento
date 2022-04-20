package by.inventolabs.unauthorizeddeliveries.loader;

import java.sql.Connection;

public interface Loader<T> {
    void load(Connection connection, T entity);
}
