import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude;

    public double getMagnitude() {
        return this.magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    public Star(String name, double x, double y, double z, double magnitude) {
        super(name, x, y, z);
        this.magnitude = magnitude;
    }

    public Star() {
    }

    @Override
    public String toString() {
        return String.format("%s shines at the %.3f magnitude", this.name, this.magnitude);
    }

    @Override
    public boolean equals(CelestialObject obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;
        Star other = (Star) obj;
        return this.getName().equals(other.getName()) &&
                Double.compare(this.getX(), other.getX()) == 0 &&
                Double.compare(this.getY(), other.getY()) == 0 &&
                Double.compare(this.getZ(), other.getZ()) == 0 &&
                this.getMagnitude() - other.getMagnitude() == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name, this.x, this.y, this.z, this.magnitude);
    }
}