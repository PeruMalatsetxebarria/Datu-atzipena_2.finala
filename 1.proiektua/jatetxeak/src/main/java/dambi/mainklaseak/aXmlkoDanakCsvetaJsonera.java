package dambi.mainklaseak;

import java.io.File;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.atzipenekoak.Jsona;

import dambi.pojoak.Jatetxeak;

public class aXmlkoDanakCsvetaJsonera {
    public static void main(String[] args) {

        Jatetxeak jatetxeak = new Jatetxeak();
        Xmla xmla = new Xmla("data/Jatetxeak.xml");
        //System.out.println(new File("").getAbsolutePath());
        
        Csva csva = new Csva("", "data/Jatetxeak.csv");
        Jsona jsona = new Jsona("", "data/Jatetxeak.json");
        jatetxeak = xmla.irakurri();
        csva.idatzi(jatetxeak);
        jsona.idatzi(jatetxeak);   
    }
}
