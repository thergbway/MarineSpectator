package marine_ships_mvc.dto;

public class Ship {
    private final String name;
    private final Long mmsi;
    private final Double longitude;
    private final Double latitude;
    private final Double speed;
    private final Double angle;
    private final Long datetime;

    public Ship(String name, Long mmsi, Double longitude, Double latitude, Double speed, Double angle, Long datetime) {
        this.name = name;
        this.mmsi = mmsi;
        this.longitude = longitude;
        this.latitude = latitude;
        this.speed = speed;
        this.angle = angle;
        this.datetime = datetime;
    }

    public Ship(String name, Double longitude, Double latitude) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;

        mmsi = null;
        speed = null;
        angle = null;
        datetime = null;
    }

    public String getName() {
        return name;
    }

    public Long getMmsi() {
        return mmsi;
    }

    public Double getLongitude() {
        return longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getSpeed() {
        return speed;
    }

    public Double getAngle() {
        return angle;
    }

    public Long getDatetime() {
        return datetime;
    }
}
