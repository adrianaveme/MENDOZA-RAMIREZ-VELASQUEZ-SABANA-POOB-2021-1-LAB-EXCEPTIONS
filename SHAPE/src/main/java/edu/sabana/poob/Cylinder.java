package edu.sabana.poob;

public class Cylinder extends Circle implements GeometricShape3D{

    private double height = 1.0;

    public Cylinder() {
    }

    public Cylinder(double radius, double height) throws ShapeException {
        super(radius);

        if (height <= 0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);

        this.height = height;
    }

    public Cylinder(String color, double radius, double height) throws ShapeException {
        super(color, radius);

        if (height <= 0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);

        this.height = height;
    }

    @Override
    public double getVolume(){

        return super.getArea()*height;
    }

    @Override
    public double getSuperficialArea(){

        return 2*super.getArea() + height*super.getPerimeter();
    }


}
