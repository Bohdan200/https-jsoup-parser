package web.user;

public class UserGeolocaton {
    private final String lat;
    private final String lng;

    public UserGeolocaton(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "{" +
                "lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }
}
