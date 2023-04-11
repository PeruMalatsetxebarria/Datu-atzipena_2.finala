package dambi.mainklaseak;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MongoDbtikCsvra {
    public static void main(String[] args) throws IOException {
        /*MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("mycollection");

        String csvFile = "/path/to/csv/file.csv";
        String line;
        String[] fields;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                fields = line.split(",");
                Document doc = new Document("field1", fields[0])
                        .append("field2", fields[1])
                        .append("field3", fields[2]);
                collection.insertOne(doc);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        mongoClient.close();*/

        MongoClient mongoClient = new MongoClient("localhost", 27017); //MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mugikorrak");
        MongoCollection<Document> collection = database.getCollection("mugikorrak");

        FileWriter csvWriter = new FileWriter("data/data.csv");

        for (Document doc : collection.find()) {
            String name = doc.getString("marka");
            int age = doc.getInteger("ram");
            csvWriter.append(name + "," + age + "\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }
}