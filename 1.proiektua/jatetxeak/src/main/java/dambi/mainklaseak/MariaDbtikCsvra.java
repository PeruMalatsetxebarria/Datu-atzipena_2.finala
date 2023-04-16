package dambi.mainklaseak;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opencsv.CSVWriter;

public class MariaDbtikCsvra {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/jatetxeak";
        String username = "";
        String password = "";
        String[] header = { "_id", "URL", "address", "address_line_2", "name", "outcode", "postcode", "rating", "type_of_food" };

        try (Connection conn = DriverManager.getConnection(jdbcUrl, username, password);
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM mytable");
                CSVWriter writer = new CSVWriter(new FileWriter("data/JatetxeakMariaDBtik.csv"))) {

            writer.writeNext(header);

            while (rs.next()) {
                String[] row = { rs.getString("_id"), rs.getString("URL"), rs.getString("address"),
                        rs.getString("address_line_2"), rs.getString("name"), rs.getString("outcode"),
                        rs.getString("postcode"), rs.getString("rating"), rs.getString("type_of_food") };
                writer.writeNext(row);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}