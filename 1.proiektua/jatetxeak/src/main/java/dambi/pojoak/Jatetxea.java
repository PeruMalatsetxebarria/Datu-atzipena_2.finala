package dambi.pojoak;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "URL", "address", "address_line_2", "name", "outcode", "postcode", "rating", "type_of_food" })
@XmlRootElement(name = "Jatetxea")

public class Jatetxea {

    String URL;
    //int id = 0;
    int id;
    String address;
    String address_line_2;
    String name;
    String outcode;
    String postcode;
    int rating;
    String type_of_food;

    public String getURL() {
        return URL;
    }

    @XmlElement(name = "URL")
    public void setURL(String URL) {
        this.URL = URL;
    }

    public int getId(){
       return id;
    }

    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    @XmlElement(name = "Address")
    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress_line_2() {
        return address_line_2;
    }

    @XmlElement(name = "Address_line_2")
    public void setAddress_line_2(String address_line_2) {
        this.address_line_2 = address_line_2;
    }

    public String getName() {
        return name;
    }

    @XmlElement(name = "Name")
    public void setName(String name) {
        this.name = name;
    }

    public String getOutcode() {
        return outcode;
    }

    @XmlElement(name = "Outcode")
    public void setOutcode(String outcode) {
        this.outcode = outcode;
    }

    public String getPostcode() {
        return postcode;
    }

    @XmlElement(name = "Postcode")
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public int getRating() {
        return rating;
    }

    @XmlElement(name = "Rating")
    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getType_of_food() {
        return type_of_food;
    }

    @XmlElement(name = "Type_of_food")
    public void setType_of_food(String type_of_food) {
        this.type_of_food = type_of_food;
    }

    @Override
    public String toString() {
        return "Jatetxea["+ id+", "+URL+", "+address+", "+address_line_2+", "+name+", "+outcode+", "+postcode+", "+rating+", "+type_of_food+"]";
    }
}
