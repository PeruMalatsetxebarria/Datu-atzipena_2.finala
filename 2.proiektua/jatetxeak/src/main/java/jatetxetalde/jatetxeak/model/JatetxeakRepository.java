package jatetxetalde.jatetxeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface JatetxeakRepository {
    List<Jatetxea> findAll();
    List<Jatetxea> findName(String name);
    List<Jatetxea> findId(String _id);
    Jatetxea save(Jatetxea jat);
    long delete(String name);
}
