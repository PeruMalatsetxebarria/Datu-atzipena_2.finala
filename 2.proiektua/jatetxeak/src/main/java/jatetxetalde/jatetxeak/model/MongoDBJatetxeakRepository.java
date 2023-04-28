package jatetxetalde.jatetxeak.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mongodb.ReadConcern;
import com.mongodb.ReadPreference;
import com.mongodb.TransactionOptions;
import com.mongodb.WriteConcern;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;


import static com.mongodb.client.model.Filters.eq;

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
        return jatetxeaCollection.find(eq("name", name)).into(new ArrayList<>());
    }

}
