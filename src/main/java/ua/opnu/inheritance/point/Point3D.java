package ua.opnu.inheritance.point;

public class Point3D extends Point {
    protected int z;

    public Point3D() {
        super(0, 0);
        this.z = 0;
    }

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        this.z = 0; // z обнуляется
    }

    public void setLocation(int x, int y, int z) {
        super.setLocation(x, y);
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    @Override
    public double distanceFromOrigin() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double distance(Point3D p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;
        int dz = this.z - p.z;
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
}
