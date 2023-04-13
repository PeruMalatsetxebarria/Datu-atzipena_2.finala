package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import dambi.pojoak.Jatetxea;
import dambi.pojoak.Jatetxeak;

public class Csva {

    public String strFileIn;
    public String strFileOut;

    /**
     * Konstruktoreak parametro bakarra jasotzen badu,
     * sarrera fitxategiaren izena jaso dugula suposatuko dugu.
     */
    public Csva(String strFileIn) {
        this.strFileIn = strFileIn;
    }

    /**
     * Konstruktoreak parametro bi jasotzen baditu,
     * lehengoa, sarrera fitxategiaren izena dela eta bigarrena irteerakoarena
     * direla suposatuko dugu.
     * Sarrera fitxategirik erabiliko ez badugu, kate hutsa erabiliko dugu lehen
     * parametro moduan.
     */
    public Csva(String strFileIn, String strFileOut) {
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }
    /**
     * strFileIn atributoan zehaztutako fitxategia irakurriko du metodo honek.
     * 
     * @return Jatetxeak klaseko objetu bat fitxategian irakurritako informazioarekin
     */
    public Jatetxeak irakurri() {
        Jatetxeak jatetxeak = null;

        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))) {
            String banatzailea = "; ";
            String l;
            jatetxeak = new Jatetxeak();
            while ((l = inputStream.readLine()) != null) {
                String[] eremuak = l.split(banatzailea);
                if (!eremuak[0].equals("id")) {
                    Jatetxea jatetxea = new Jatetxea();
                    //jatetxea.setId(jatetxeak.getJatetxeak() == null ? 0 : jatetxeak.getJatetxeak().size());
                    
                    jatetxea.setId(Integer.parseInt(eremuak[0]));
                    jatetxea.setURL(eremuak[1]);
                    jatetxea.setAddress(eremuak[2]);
                    jatetxea.setAddress_line_2(eremuak[3]);
                    jatetxea.setName(eremuak[4]);
                    jatetxea.setOutcode(eremuak[5]);
                    jatetxea.setPostcode(eremuak[6]);
                    jatetxea.setRating(Integer.parseInt(eremuak[7]));
                    jatetxea.setType_of_food(eremuak[8]);
                    jatetxeak.add(jatetxea);
                }
            }
            // System.out.println(jatetxeak.getJatetxeak());
        } catch (FileNotFoundException e) {
            System.out.println("Ez da " + strFileIn + " fitxategia aurkitu.");

        } catch (IOException e) {
            System.out.println("IOsalbuespena gertatu da.");
        }
        return jatetxeak;
    }

    /**
     * strFileOut atributoan zehaztutako fitxategian, jasotako objetuko datuak idatziko ditu metodo honek.
     * 
     * @param jatetxeak
     * @return Fitxategian idatzitako mendi kopurua 
     */
    public int idatzi(Jatetxeak jatetxeak) {
        int mendiKopurua=0;        

        try (PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut))) {
            for (Jatetxea m : jatetxeak.getJatetxeak()) {
                if (mendiKopurua==0){
                    outputStream.println("id; URL; address; address line 2; name; outcode; postcode; rating; type of food");
                }
                mendiKopurua++;
                
                outputStream.println(m.getId()+"; "+m.getURL()+"; "+m.getAddress()+"; "+m.getAddress_line_2()+"; "+m.getName()+"; "+m.getOutcode()+"; "+m.getPostcode()+"; "+m.getRating()+"; "+m.getType_of_food());
            }
        } catch (IOException e) {
            System.out.println(strFileOut + " fitxategiarekin arazoren bat egon da.");
        }
        return mendiKopurua;
    }
}
