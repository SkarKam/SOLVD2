package Models;

public class Address {
    private String street;
    private String city;
    private String state;

    public Address(String street, String city, String state) {
        this.street = street;
        this.city = city;
        this.state = state;
    }
    public Address(){

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        if(!street.isBlank()) {
            this.street = street;
        } else{
            throw new IllegalArgumentException("Street cannot be blank.");
        }
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(!city.isBlank()) {
            this.city = city;
        } else {
            throw new IllegalArgumentException("City cannot be blank.");
        }
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        if(!state.isBlank()) {
            this.state = state;
        } else {
            throw new IllegalArgumentException("State cannot be blank.");
        }
    }

    @Override
    public String toString() {
        return "\nAddress{" +
                "street='" + street + '\'' +
                "city='" + city + '\'' +
                "state='" + state + '\'' +
                '}';
    }
}
