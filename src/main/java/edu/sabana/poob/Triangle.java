package edu.sabana.poob;

public class Triangle extends Shape {
    private double side1 = 1.0;
    private double side2 = 1.0;
    private double side3 = 1.0;

    /**
     * Constructors
     */
    public Triangle() {
        super();
    }

    public Triangle(String color) {
        super(color);
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(String color, double side1, double side2, double side3) {
        super(color);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    /**
     * Method that confirms whether a triangle is isosceles
     * First it verifies whether the triangle is equilateral
     * If it isn't it returns true if any of the other two sides are equal
     *
     * @return boolean result
     */
    public boolean isIsosceles(){
        boolean result = false;
        if (!isEquilateral()) {
            result = side1==side2 || side2==side3 || side3==side1;
        }
        return result;
    }

    /**
     * Method that confirms whether a triangle is equilateral
     * Returns true if all sides are equal
     *
     * @return true or false
     */
    public boolean isEquilateral(){
        return side1==side2 && side2==side3 && side1==side3;
    }

    /**
     * Override of inherited method getArea
     * Calculates the area of the triangle with Heron's formula
     *
     * @return double area
     */
    @Override
    public double getArea() {
        double p = getPerimeter()/2;
        return Math.sqrt(p*(p-side1)*(p-side2)*(p-side3));
    }

    /**
     * Override of inherited method getPerimeter
     * Calculates the perimeter of a triangle by adding all its sides
     *
     * @return double perimeter
     */
    @Override
    public double getPerimeter() {
        return side1+side2+side3;
    }

    /**
     * Override of inherited method toString
     * Adds text to the message that includes the sides of the triangle
     *
     * @return String print of the triangle
     */
    @Override
    public String toString() {
        return super.toString() + String.format(" and sides that measure %s, %s and %s", side1, side2, side3);
    }
}
