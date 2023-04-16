package dambi.mainklaseak;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.opencsv.CSVReader;

public class CsvtikMariaDBra {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mariadb://localhost:3306/jatetxeak";
        String username = "";
        String password = "";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            String query = "INSERT INTO table_name (_id, URL, address, address_line_2, name, outcode, postcode, rating, type_of_food) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);

            String csvFile = "data/Jatetxeak.csv";
            BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                preparedStatement.setInt(1, Integer.parseInt(data[0]));
                preparedStatement.setString(2, data[1]);
                preparedStatement.setString(3, data[2]);
                preparedStatement.setString(4, data[3]);
                preparedStatement.setString(5, data[4]);
                preparedStatement.setString(6, data[5]);
                preparedStatement.setString(7, data[6]);
                preparedStatement.setInt(8, Integer.parseInt(data[7]));
                preparedStatement.setString(9, data[8]);

                preparedStatement.executeUpdate();
            }

            System.out.println("Datuak era egokian inportatu dira CSVtik MariaDBra.");
        } catch (Exception e) {
            System.out.println("Arazoak izan dira CSVa MariaDBra esportatzerakoan: " + e.getMessage());
        }
    }
}