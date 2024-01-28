
package football.tournament.of.antiparos;


public class Address {
    private String streetName;
    private String streetNumber;
    private String postCode;
    private String city;
    
    public Address(String streetName, String streetNumber, 
            String postCode){
        
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = "Athens"; 
    }
    
    public Address(String streetName, String streetNumber, 
            String postCode, String city){
        
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postCode = postCode;
        this.city = city; 
    }
    
    public String getStreetName(){
        return streetName;
    }
    public void setStreetName(String streetName){
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
