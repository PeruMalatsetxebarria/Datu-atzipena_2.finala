package dambi.mainklaseak;

import java.io.File;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Xmla;
import dambi.atzipenekoak.Jsona;

import dambi.pojoak.Jatetxeak;

public class aJsonkoDanakCsvetaXmlra {
    public static void main(String[] args) {

        Jatetxeak jatetxeak = new Jatetxeak();
        Jsona jsona = new Jsona("data/Jatetxeak.json");
        //System.out.println(new File("").getAbsolutePath());
        
        Xmla xmla = new Xmla("", "data/Jatetxeak.xml");
        Csva csva = new Csva("", "data/Jatetxeak.csv");
        jatetxeak = jsona.irakurri();
        xmla.idatzi(jatetxeak);
        csva.idatzi(jatetxeak);   
    }
}
