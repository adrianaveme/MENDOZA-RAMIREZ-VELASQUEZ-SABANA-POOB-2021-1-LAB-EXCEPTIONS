package edu.sabana.poob;

public class Rectangle extends Shape implements GeometricShape2D{

    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
        super();
    }

    public Rectangle(String color) {
        super(color);
    }

    public Rectangle(double width, double lenght) throws ShapeException {

        if (width <= 0 || lenght <= 0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);

        this.width = width;
        this.length = lenght;
    }

    public Rectangle(String color, double width, double lenght) throws ShapeException {
        super(color);

        if (width <= 0 || lenght <= 0)
            throw new ShapeException(ShapeException.BAD_DIMENSION_SIDE);

        this.width = width;
        this.length = lenght;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getDiagonal() {
        return Math.hypot(width,length);
    }

    @Override
    public double getArea() {
        return width*length;
    }

    @Override
    public double getPerimeter(){
        return (2*width+2*length);
    }

    /*@Override
    public String toString() {
        return super.toString() + String.format(", length %s ", length) +String.format( "and width %s", width);

    }

     */



}
