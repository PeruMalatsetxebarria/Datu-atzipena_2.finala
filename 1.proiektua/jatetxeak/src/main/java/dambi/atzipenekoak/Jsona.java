package dambi.atzipenekoak;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import org.apache.commons.io.FileUtils;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONObject;

import dambi.pojoak.Jatetxea;
import dambi.pojoak.Jatetxeak;

public class Jsona {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public Jsona(String strFile) {
        strFileIn = strFile;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public Jsona(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Jatetxeak irakurri() {
        Jatetxeak jatetxeak = null;
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();
            jatetxeak = new Jatetxeak();
            for (int i = 0; i < jsonarray.size(); i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);
                Jatetxea jatetxea = new Jatetxea();


                jatetxea.setId(jsonobj.getInt("id"));

                jatetxea.setURL(jsonobj.getString("URL"));
                jatetxea.setAddress(jsonobj.getString("address"));
                jatetxea.setAddress_line_2(jsonobj.getString("address_line_2"));
                jatetxea.setName(jsonobj.getString("name"));
                jatetxea.setOutcode(jsonobj.getString("outcode"));
                jatetxea.setPostcode(jsonobj.getString("postcode"));
                jatetxea.setRating(jsonobj.getInt("rating"));
                jatetxea.setType_of_food(jsonobj.getString("type_of_food"));
                jatetxeak.add(jatetxea);
            }
            
        } catch (Exception e) {
            System.out.println("Arazoak " + strFileIn + " fitxategia irakurtzerakoan.");
        }
        return jatetxeak;
    }

    public int idatzi(Jatetxeak jatetxeak) {
        int jatetxeKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Jatetxea m : jatetxeak.getJatetxeak()) {
            jab.add(Json.createObjectBuilder()
                    .add("id", m.getId())
                    .add("URL", m.getURL())
                    .add("address", m.getAddress())
                    .add("address_line_2", m.getAddress_line_2())
                    .add("name", m.getName())
                    .add("outcode", m.getOutcode())
                    .add("postcode", m.getPostcode())
                    .add("rating", m.getRating())
                    .add("type_of_food", m.getType_of_food())
                    .build());
            jatetxeKopurua++;
        }
        model=jab.build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
            jsonWriter.writeArray(model);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }
        return jatetxeKopurua;

    }
    public int idatzi_Formatua(Jatetxeak jatetxeak) {
        int jatetxeKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Jatetxea m : jatetxeak.getJatetxeak()) {
            jab.add(Json.createObjectBuilder()
                    .add("id", m.getId())
                    .add("URL", m.getURL())
                    .add("address", m.getAddress())
                    .add("address_line_2", m.getAddress_line_2())
                    .add("name", m.getName())
                    .add("outcode", m.getOutcode())
                    .add("postcode", m.getPostcode())
                    .add("rating", m.getRating())
                    .add("type_of_food", m.getType_of_food())
                    .build());
            jatetxeKopurua++;
        }
        model=jab.build();
        String modelString = "{jatetxeak: " + model.toString() + "}";
        JSONObject output;
        try {
           output = new JSONObject(modelString);
           JSONArray docs = output.getJSONArray("jatetxeak");
           File file = new File("EmpDetails.csv");
           String csv = CDL.toString(docs);
           FileUtils.writeStringToFile(file, csv);
           System.out.println("Data has been Sucessfully Writeen to "+ file);
           System.out.println(csv);
        }
        catch(Exception e) {
           e.printStackTrace();
        }
        return jatetxeKopurua;

    }
}
