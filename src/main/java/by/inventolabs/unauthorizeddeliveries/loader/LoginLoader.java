package by.inventolabs.unauthorizeddeliveries.loader;

import by.inventolabs.unauthorizeddeliveries.model.Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginLoader implements Loader<Login> {
    private static final String FIND_APPLICATION = "SELECT id FROM application where name = ? LIMIT 1";
    private static final String FIND_DEPARTMENT = "SELECT id FROM department where name = ? LIMIT 1";
    private static final String FIND_IS_ACTIVE = "SELECT id FROM is_active where is_active = ? LIMIT 1";
    private static final String FIND_JOB_TITLE = "SELECT id FROM job_title where name = ? LIMIT 1";
    private static final String INSERT_APPLICATION = "INSERT INTO application (name) VALUES (?)";
    private static final String INSERT_DEPARTMENT = "INSERT INTO department (name) VALUES (?)";
    private static final String INSERT_IS_ACTIVE = "INSERT INTO is_active (is_active) VALUES (?)";
    private static final String INSERT_JOB_TITLE = "INSERT INTO job_title (name) VALUES (?)";
    private static final String INSERT_USER = "INSERT INTO user  (name,job_title_id,is_active_id,department_id,application_id) VALUES (?,?,?,?,?)";

    @Override
    public void load(Connection connection, Login entity) {
        try {
            long applicationId;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_APPLICATION);
            preparedStatement.setString(1, entity.getApplication());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                preparedStatement = connection.prepareStatement(INSERT_APPLICATION);
                preparedStatement.setString(1, entity.getApplication());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(FIND_APPLICATION);
                preparedStatement.setString(1, entity.getApplication());
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
            }
            applicationId = resultSet.getLong(1);

            long departmentId;
            preparedStatement = connection.prepareStatement(FIND_DEPARTMENT);
            preparedStatement.setString(1, entity.getDepartment());
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                preparedStatement = connection.prepareStatement(INSERT_DEPARTMENT);
                preparedStatement.setString(1, entity.getDepartment());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(FIND_DEPARTMENT);
                preparedStatement.setString(1, entity.getDepartment());
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
            }
            departmentId = resultSet.getLong(1);

            long isActiveId;
            preparedStatement = connection.prepareStatement(FIND_IS_ACTIVE);
            preparedStatement.setString(1, entity.getIsActive());
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                preparedStatement = connection.prepareStatement(INSERT_IS_ACTIVE);
                preparedStatement.setString(1, entity.getIsActive());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(FIND_IS_ACTIVE);
                preparedStatement.setString(1, entity.getIsActive());
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
            }
            isActiveId = resultSet.getLong(1);

            long jobTitleId;
            preparedStatement = connection.prepareStatement(FIND_JOB_TITLE);
            preparedStatement.setString(1, entity.getJobTitle());
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                preparedStatement = connection.prepareStatement(INSERT_JOB_TITLE);
                preparedStatement.setString(1, entity.getJobTitle());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(FIND_JOB_TITLE);
                preparedStatement.setString(1, entity.getJobTitle());
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
            }
            jobTitleId = resultSet.getLong(1);

            preparedStatement = connection.prepareStatement(INSERT_USER);
            preparedStatement.setString(1, entity.getAppAccountName());
            preparedStatement.setLong(2, jobTitleId);
            preparedStatement.setLong(3, isActiveId);
            preparedStatement.setLong(4, departmentId);
            preparedStatement.setLong(5, applicationId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
