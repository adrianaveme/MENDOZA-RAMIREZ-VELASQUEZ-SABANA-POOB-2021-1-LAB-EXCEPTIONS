package edu.sabana.poob;

public class Circle extends Shape {

    public static final double PI=3.142;
    private double radius;

    public Circle() {
        this.radius = 1.0;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(String color, double radius) {
        super(color);
        this.radius = radius;
    }

    public double getDiameter() {
        return 2*radius;
    }

    @Override
    public double getArea(){
        return Math.pow(radius,2)*PI;
    }

    @Override
    public double getPerimeter() {
        return 2*radius*PI;
    }

    @Override
    public String toString() {
        String result;

        if ((int)radius == radius){
            int newRadius = (int)radius;
            result = super.toString() + String.format(" and radius %s", newRadius);
        }
        else {
            result = super.toString() + String.format(" and radius %s", radius);
        }

        return result;
    }
}
