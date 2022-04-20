package by.inventolabs.unauthorizeddeliveries;

import by.inventolabs.unauthorizeddeliveries.model.Posting;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {
    private static final String FIND_ALL_POSTINGS = """
            SELECT mat_doc, item, doc_date, pstng_date, quantity, amount_lc, is_authorized, user.name, 
            product.material_description, crcy.name, bun.name 
            FROM delivery 
            JOIN user ON user_id=user.id 
            JOIN product ON product_id=product.id 
            JOIN crcy ON crcy_id=crcy.id 
            JOIN bun ON bun_id=bun.id;
            """;
    private static final String FIND_ALL_AUTHORIZED_POSTINGS = """
            SELECT mat_doc, item, doc_date, pstng_date, quantity, amount_lc, is_authorized, user.name, 
            product.material_description, crcy.name, bun.name 
            FROM delivery 
            JOIN user ON user_id=user.id 
            JOIN product ON product_id=product.id 
            JOIN crcy ON crcy_id=crcy.id 
            JOIN bun ON bun_id=bun.id
            WHERE is_authorized = 'True';
            """;
    private static final String FIND_ALL_POSTINGS_BY_DAY = """
            SELECT mat_doc, item, doc_date, pstng_date, quantity, amount_lc, is_authorized, user.name, 
            product.material_description, crcy.name, bun.name 
            FROM delivery 
            JOIN user ON user_id=user.id 
            JOIN product ON product_id=product.id 
            JOIN crcy ON crcy_id=crcy.id 
            JOIN bun ON bun_id=bun.id
            WHERE pstng_date >= current_date();
            """;
    private static final String FIND_ALL_POSTINGS_BY_MONTH = """
            SELECT mat_doc, item, doc_date, pstng_date, quantity, amount_lc, is_authorized, user.name, 
            product.material_description, crcy.name, bun.name 
            FROM delivery 
            JOIN user ON user_id=user.id 
            JOIN product ON product_id=product.id 
            JOIN crcy ON crcy_id=crcy.id 
            JOIN bun ON bun_id=bun.id
            WHERE pstng_date >= current_date() - INTERVAL 1 MONTH;
            """;
    private static final String FIND_ALL_POSTINGS_BY_QUARTER = """
            SELECT mat_doc, item, doc_date, pstng_date, quantity, amount_lc, is_authorized, user.name, 
            product.material_description, crcy.name, bun.name 
            FROM delivery 
            JOIN user ON user_id=user.id 
            JOIN product ON product_id=product.id 
            JOIN crcy ON crcy_id=crcy.id 
            JOIN bun ON bun_id=bun.id
            WHERE pstng_date >= current_date() - INTERVAL 4 MONTH;
            """;
    private static final String FIND_ALL_POSTINGS_BY_YEAR = """
            SELECT mat_doc, item, doc_date, pstng_date, quantity, amount_lc, is_authorized, user.name, 
            product.material_description, crcy.name, bun.name 
            FROM delivery 
            JOIN user ON user_id=user.id 
            JOIN product ON product_id=product.id 
            JOIN crcy ON crcy_id=crcy.id 
            JOIN bun ON bun_id=bun.id
            WHERE pstng_date >= current_date() - INTERVAL 1 YEAR;
            """;


    public void init() {
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ConnectionMySQL connectionMySQL = new ConnectionMySQL();
        Connection connection = connectionMySQL.getConnection();
        String type = request.getParameter("time");
        String query;
        switch (type){
            case ("day"):
                query = FIND_ALL_POSTINGS_BY_DAY;
                break;
            case ("month"):
                query = FIND_ALL_POSTINGS_BY_MONTH;
                break;
            case ("quarter"):
                query = FIND_ALL_POSTINGS_BY_QUARTER;
                break;
            case ("year"):
                query = FIND_ALL_POSTINGS_BY_YEAR;
                break;
            case ("authorized"):
                query = FIND_ALL_AUTHORIZED_POSTINGS;
                break;
            default:
                query = FIND_ALL_POSTINGS;
                break;
        }

        List<Posting> postings = new ArrayList<>();


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Posting posting = readPosting(resultSet);
                    postings.add(posting);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("postings", postings);
        String path = "/table.jsp";
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
        requestDispatcher.forward(request, response);
    }

    public void destroy() {
    }

    private Posting readPosting(ResultSet resultSet) throws SQLException {
        Posting posting = new Posting();
        posting.setMatDoc(resultSet.getLong(1));
        posting.setItem(resultSet.getInt(2));
        posting.setDocDate(resultSet.getDate(3));
        posting.setPstngDate(resultSet.getDate(4));
        posting.setQuantity(resultSet.getInt(5));
        posting.setAmountLC(resultSet.getString(6));
        posting.setIsAuthorized(resultSet.getString(7));
        posting.setUserName(resultSet.getString(8));
        posting.setMaterialDescription(resultSet.getString(9));
        posting.setCrcy(resultSet.getString(10));
        posting.setbUn(resultSet.getString(11));
        return posting;
    }
}