package by.inventolabs.unauthorizeddeliveries.reader;

import by.inventolabs.unauthorizeddeliveries.ConnectionMySQL;
import by.inventolabs.unauthorizeddeliveries.loader.LoginLoader;
import by.inventolabs.unauthorizeddeliveries.model.Login;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

public class LoginReader {
    public static void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/logins.csv"));

            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Login.class)
                    .withSeparator(',')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();


            ConnectionMySQL connectionMySQL = new ConnectionMySQL();
            LoginLoader loginLoader = new LoginLoader();

            for (Login login : (Iterable<Login>) csvToBean) {
                loginLoader.load(connectionMySQL.getConnection(),login);
                System.out.print("   " + login.getApplication());
                System.out.print("   " + login.getAppAccountName());
                System.out.print("   " + login.getIsActive());
                System.out.print("   " + login.getJobTitle());
                System.out.print("   " + login.getDepartment() + "\n");

            }
            reader.close();
            connectionMySQL.getConnection().close();
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
