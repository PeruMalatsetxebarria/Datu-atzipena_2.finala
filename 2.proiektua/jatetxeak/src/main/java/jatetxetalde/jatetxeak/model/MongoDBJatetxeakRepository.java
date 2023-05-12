package jatetxetalde.jatetxeak.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.management.Query;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;//


//import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBJatetxeakRepository implements JatetxeakRepository {

    private static final TransactionOptions txnOptions = TransactionOptions.builder()
                                                                           .readPreference(ReadPreference.primary())
                                                                           .readConcern(ReadConcern.MAJORITY)
                                                                           .writeConcern(WriteConcern.MAJORITY)
                                                                           .build();
    @Autowired
    private MongoClient client;
    private MongoCollection<Jatetxea> jatetxeaCollection;

    @PostConstruct
    void init() {
        jatetxeaCollection = client.getDatabase("jatetxeak").getCollection("jatetxeak", Jatetxea.class);
    }//datu basi eta tabli aldatu

    @Override
    public List<Jatetxea> findAll() {
        return jatetxeaCollection.find().into(new ArrayList<>());
    }

    @Override
    public List<Jatetxea> findName(String name) {
        return jatetxeaCollection.find(Filters.eq("name", name)).into(new ArrayList<>());
    }

    @Override
    public List<Jatetxea> findId(String _id) {
        return jatetxeaCollection.find(Filters.eq("_id", _id)).into(new ArrayList<>());
    }

    @Override
    public Jatetxea save(Jatetxea jatetxea) {
        //jatetxea.setId(new ObjectId());
        jatetxeaCollection.insertOne(jatetxea);
        return jatetxea;
    }

    @Override
    public long delete(String name) {
        return jatetxeaCollection.deleteMany(Filters.eq("name", name)).getDeletedCount();
    }

    @Override
    public Jatetxea updateJatetxea(Jatetxea jatetxea) {
        jatetxeaCollection.updateOne(Filters.eq("_id", jatetxea.getId()), new Document("$set", new Document("address", jatetxea.getAddress())));
        return jatetxea;
    } 
}
