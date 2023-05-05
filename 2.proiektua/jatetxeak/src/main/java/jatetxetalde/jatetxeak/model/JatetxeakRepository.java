package jatetxetalde.jatetxeak.model;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface JatetxeakRepository {
    List<Jatetxea> findAll();
    List<Jatetxea> findName(String name);
    Jatetxea save(Jatetxea jat);
}
