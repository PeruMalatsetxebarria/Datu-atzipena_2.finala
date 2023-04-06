package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Jatetxeak")
public class Jatetxeak {

    List<Jatetxea> jatetxeak;

    public List<Jatetxea> getJatetxeak() {
        return jatetxeak;
    }

    @XmlElement(name = "Jatetxea")
    public void setJatetxeak(List<Jatetxea> jatetxeak) {
        this.jatetxeak = jatetxeak;
    }

    public void add(Jatetxea jatetxea) {
        if (this.jatetxeak == null) {
            this.jatetxeak = new ArrayList<Jatetxea>();
        }
        this.jatetxeak.add(jatetxea);

    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (Jatetxea m : this.jatetxeak) {
            str.append(m.toString());
            str.append("\n");
        }
        return str.toString();
    }

}
