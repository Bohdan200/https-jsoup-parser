package web.user;

public class UserAddress {
    private final String street;
    private final String suite;
    private final String city;
    private final String zipcode;
    private final UserGeolocaton geo;

    public UserAddress(String street, String suite, String city, String zipcode, UserGeolocaton geo) {
        this.street = street;
        this.suite = suite;
        this.city = city;
        this.zipcode = zipcode;
        this.geo = geo;
    }

    @Override
    public String toString() {
        return "{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}';
    }
}
