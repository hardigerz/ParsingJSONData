package parsingjsondata.project.com.parsingjsondata.Model;

public class Address {

    public void setStreet(String street) {
        this.street = street;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    String street;
     String suite;
     String city;
     String postcode;



    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }
}
