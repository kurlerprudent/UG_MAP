import java.util.Objects;

public class Location {

        String name;
        double latitude;
        double longitude;

        public Location(String name, double latitude, double longitude) {
            this.name = name;
            this.latitude = latitude;
            this.longitude = longitude;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Location)) return false;
            Location other = (Location) obj;
            return name.equals(other.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }

}
