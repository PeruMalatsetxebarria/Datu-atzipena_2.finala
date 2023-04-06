package dambi.mainklaseak;

import java.io.File;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.atzipenekoak.Jsona;

import dambi.pojoak.Jatetxeak;

public class aCsvkoDanakXmletaJsonera {
    public static void main(String[] args) {

        Jatetxeak jatetxeak = new Jatetxeak();
        Csva csva = new Csva("data/Jatetxeak.csv");
        //System.out.println(new File("").getAbsolutePath());
        
        Xmla xmla = new Xmla("", "data/Jatetxeak.xml");
        Jsona jsona = new Jsona("", "data/Jatetxeak.json");
        jatetxeak = csva.irakurri();
        xmla.idatzi(jatetxeak);
        jsona.idatzi(jatetxeak);   
    }
}
