package edu.sabana.poob;

public class RectangleSolid extends Rectangle implements GeometricShape3D {

    private double depth = 1.0;

    public RectangleSolid() {
    }

    public RectangleSolid(String color) {
        super(color);
    }

    public RectangleSolid(double width, double lenght, double depth) throws ShapeException {
        super(width, lenght);

        if (depth <= 0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);

        this.depth = depth;
    }

    public RectangleSolid(String color, double width, double lenght, double depth) throws ShapeException {
        super(color, width, lenght);

        if (depth <= 0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);

        this.depth = depth;
    }

    @Override
    public double getVolume() {
        return getArea()*depth;
    }

    @Override
    public double getSuperficialArea() {
        return 2*(getArea()+(getLength()*depth)+(getWidth()*depth));
    }
}
