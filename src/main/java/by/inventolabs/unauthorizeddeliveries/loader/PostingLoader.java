package by.inventolabs.unauthorizeddeliveries.loader;

import by.inventolabs.unauthorizeddeliveries.model.Posting;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostingLoader implements Loader<Posting>{
    private static final String FIND_USER = "SELECT id FROM user where name = ? LIMIT 1";
    private static final String FIND_AUTHORIZED = "SELECT t.is_active, name FROM user INNER JOIN is_active as t ON user.is_active_id = t.id WHERE name = ?";
    private static final String FIND_PRODUCT = "SELECT id FROM product where material_description = ? LIMIT 1";
    private static final String FIND_CRCY = "SELECT id FROM crcy where name = ? LIMIT 1";
    private static final String FIND_BUN = "SELECT id FROM bun where name = ? LIMIT 1";
    private static final String INSERT_USER = "INSERT INTO user (name) VALUES (?)";
    private static final String INSERT_PRODUCT = "INSERT INTO product (material_description) VALUES (?)";
    private static final String INSERT_CRCY = "INSERT INTO crcy (name) VALUES (?)";
    private static final String INSERT_BUN = "INSERT INTO bun (name) VALUES (?)";
    private static final String INSERT_DELIVERY = "INSERT INTO delivery (mat_doc,item,doc_date,pstng_date,quantity,amount_lc,is_authorized,user_id,product_id,crcy_id,bun_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

    @Override
    public void load(Connection connection, Posting entity) {
        try {
            long userId;
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER);
            preparedStatement.setString(1, entity.getUserName());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                preparedStatement = connection.prepareStatement(INSERT_USER);
                preparedStatement.setString(1, entity.getUserName());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(FIND_USER);
                preparedStatement.setString(1, entity.getUserName());
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
            }
            userId = resultSet.getLong(1);
            preparedStatement = connection.prepareStatement(FIND_AUTHORIZED);
            preparedStatement.setString(1, entity.getUserName());
            resultSet = preparedStatement.executeQuery();
            String authorized = "False";
            if (resultSet.next()) {
                authorized = resultSet.getString(1);
            }

            long productId;
            preparedStatement = connection.prepareStatement(FIND_PRODUCT);
            preparedStatement.setString(1, entity.getMaterialDescription());
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                preparedStatement = connection.prepareStatement(INSERT_PRODUCT);
                preparedStatement.setString(1, entity.getMaterialDescription());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(FIND_PRODUCT);
                preparedStatement.setString(1, entity.getMaterialDescription());
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
            }
            productId = resultSet.getLong(1);

            long crcyId;
            preparedStatement = connection.prepareStatement(FIND_CRCY);
            preparedStatement.setString(1, entity.getCrcy());
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                preparedStatement = connection.prepareStatement(INSERT_CRCY);
                preparedStatement.setString(1, entity.getCrcy());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(FIND_CRCY);
                preparedStatement.setString(1, entity.getCrcy());
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
            }
            crcyId = resultSet.getLong(1);

            long bunId;
            preparedStatement = connection.prepareStatement(FIND_BUN);
            preparedStatement.setString(1, entity.getbUn());
            resultSet = preparedStatement.executeQuery();
            if (!resultSet.next()) {
                preparedStatement = connection.prepareStatement(INSERT_BUN);
                preparedStatement.setString(1, entity.getbUn());
                preparedStatement.executeUpdate();
                preparedStatement = connection.prepareStatement(FIND_BUN);
                preparedStatement.setString(1, entity.getbUn());
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
            }
            bunId = resultSet.getLong(1);

            preparedStatement = connection.prepareStatement(INSERT_DELIVERY);
            preparedStatement.setLong(1, entity.getMatDoc());
            preparedStatement.setInt(2, entity.getItem());
            preparedStatement.setDate(3, entity.getDocDate());
            preparedStatement.setDate(4, entity.getPstngDate());
            preparedStatement.setInt(5, entity.getQuantity());
            preparedStatement.setString(6, entity.getAmountLC());
            preparedStatement.setString(7, authorized);
            preparedStatement.setLong(8, userId);
            preparedStatement.setLong(9, productId);
            preparedStatement.setLong(10, crcyId);
            preparedStatement.setLong(11, bunId);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
