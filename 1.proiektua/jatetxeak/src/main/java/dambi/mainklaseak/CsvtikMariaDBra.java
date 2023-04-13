package dambi.mainklaseak;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.opencsv.CSVReader;

public class CsvtikMariaDBra {
    public static void main(String[] args) throws Exception {
        String csvFile = "/path/to/your/csv/file.csv";
        String jdbcURL = "jdbc:mariadb://localhost:3306/jatetxeak";
        String username = "your-username";
        String password = "your-password";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             CSVReader reader = new CSVReader(new FileReader(csvFile))) {
            String[] nextLine;
            String query = "INSERT INTO jatetxeak (URL, _id, address, address_line_2, name, outcode, postcode, rating, type_of_food) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            while ((nextLine = reader.readNext()) != null) {
                statement.setString(1, nextLine[0]);
                statement.setString(2, nextLine[1]);
                statement.setString(3, nextLine[2]);
                statement.setString(4, nextLine[3]);
                statement.setString(5, nextLine[4]);
                statement.setString(6, nextLine[5]);
                statement.setString(7, nextLine[6]);
                statement.setInt(8, Integer.parseInt(nextLine[7]));
                statement.setString(9, nextLine[8]);

                statement.executeUpdate();
            }
        }
    }
}