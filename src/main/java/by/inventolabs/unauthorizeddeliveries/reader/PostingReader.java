package by.inventolabs.unauthorizeddeliveries.reader;

import by.inventolabs.unauthorizeddeliveries.ConnectionMySQL;
import by.inventolabs.unauthorizeddeliveries.loader.PostingLoader;
import by.inventolabs.unauthorizeddeliveries.model.Posting;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

public class PostingReader {
    public static void main(String[] args) {
        try {

            Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/postings.csv"));

            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(Posting.class)
                    .withSeparator(';')
                    .withIgnoreLeadingWhiteSpace(true)
                    .withIgnoreEmptyLine(true)
                    .build();

            ConnectionMySQL connectionMySQL = new ConnectionMySQL();
            PostingLoader postingLoader = new PostingLoader();

            for (Posting posting : (Iterable<Posting>) csvToBean) {
                postingLoader.load(connectionMySQL.getConnection(),posting);
            }
            reader.close();
            connectionMySQL.getConnection().close();
        } catch (IOException | SQLException ex) {
            ex.printStackTrace();
        }
    }
}
