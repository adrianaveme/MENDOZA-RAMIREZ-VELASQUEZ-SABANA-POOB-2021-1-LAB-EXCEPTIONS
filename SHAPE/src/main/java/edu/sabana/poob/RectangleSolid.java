package edu.sabana.poob;

public class RectangleSolid extends Rectangle implements GeometricShape3D {

    private double depth = 1.0;

    public RectangleSolid() {
    }

    public RectangleSolid(String color) {
        super(color);
    }

    public RectangleSolid(double width, double lenght, double depth) {
        super(width, lenght);
        this.depth = depth;
    }

    public RectangleSolid(String color, double width, double lenght, double depth) {
        super(color, width, lenght);
        this.depth = depth;
    }

    @Override
    public double getVolume() {
        return 0;
    }

    @Override
    public double getSuperficialArea() {
        return 0;
    }
}
