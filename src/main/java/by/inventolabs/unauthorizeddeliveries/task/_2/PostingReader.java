package by.inventolabs.unauthorizeddeliveries.task._2;

import au.com.bytecode.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class PostingReader {
    public static void main(String[] args) throws IOException {
        CSVReader reader = new CSVReader(new FileReader("target\\classes\\postings.csv"),';','"',2);
        List<String[]> allRows = reader.readAll();
        for(String[] row : allRows){
            System.out.println(Arrays.toString(row));
        }
    }
}
