import java.util.Objects;
public class Address {
    private String street;
    private String city;
    private String state;
    private String zipCode;

    public Address(String street, String city, String state, String zipCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) && Objects.equals(city, address.city) && Objects.equals(state, address.state) && Objects.equals(zipCode, address.zipCode);
    }


    @Override
    public String toString() {
        return "Informacion Dirección: " +
                " calle='" + street + '\'' +
                ", ciudad='" + city + '\'' +
                ", estado='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
