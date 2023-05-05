package jatetxetalde.jatetxeak.model;

import java.util.List;

import org.bson.types.ObjectId;

public class Jatetxea {
	//private int _id;
    private String _id;
	private String url;
    private String address;
    private String address_line_2;
	private String name;
	private String outcode;
	private String postcode;
	private int rating;
	private String type_of_food;


    /*public int getId() {
		return _id;//return Integer.parseInt(_id);Integer.toString(_id)
	}

	public void setId(int _id) {
		this._id = _id;
	}*/
	public String getId() {
		return _id;
	}

	public void setId(String _id) {
		this._id = _id;
	}




	public String getURL() {
		return url;
	}

	public void setURL(String url) {
		this.url = url;
	}

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress_line_2() {
		return address_line_2;
	}

	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOutcode() {
		return outcode;
	}

	public void setOutcode(String outcode) {
		this.outcode = outcode;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getType_of_food() {
		return type_of_food;
	}

	public void setType_of_food(String type_of_food) {
		this.type_of_food = type_of_food;
	}





	@Override
	public String toString() {
        return "jatetxea [id=" + _id + " + , url=" + url + ", helbide=" + address + ", 2. helbidea=" + address_line_2 + ", izena=" + name + ", outcode=" + outcode + ", postcode=" + postcode + ", balorazioa=" + rating + ", type_of_food=" + type_of_food + "]";
	}
}
