package edu.sabana.poob;

public class Pyramid extends Triangle implements GeometricShape3D{

    private double height = 1.0;

    public Pyramid() {
    }

    public Pyramid(String color) {
        super(color);
    }

    public Pyramid(double side1, double side2, double side3, double height) {
        super(side1, side2, side3);
        this.height = height;
    }

    public Pyramid(String color, double side1, double side2, double side3, double height) {
        super(color, side1, side2, side3);
        this.height = height;
    }

    @Override
    public double getVolume(){

        return ((super.getArea()*height)/3);
    }

    @Override
    public double getSuperficialArea(){

        return super.getArea()*4;
    }

}
