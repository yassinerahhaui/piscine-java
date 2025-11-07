public class CelestialObject {
    public double x ,y , z;
    public String name;

    public static double KM_IN_ONE_AU = 150000000.0;

    public CelestialObject() { this("Soleil", 0.0, 0.0, 0.0); }

    public CelestialObject(String name, double x,double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.name = name;
    }

    public double getX() {
        return this.x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return this.y;
    }

    public void setY(double y) {
        this.y = y;
    } 

    public double getZ() {
        return this.z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getDistanceBetween(CelestialObject obj1,CelestialObject obj2) {
        double dx = obj1.x - obj2.x;
        double dy = obj1.y - obj2.y;
        double dz = obj1.z - obj2.z;
        return Math.sqrt(dx*dx+dy*dy+dz*dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject obj1,CelestialObject obj2) {
        return getDistanceBetween(obj1,obj2) * KM_IN_ONE_AU;
    }
}