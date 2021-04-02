package edu.sabana.poob;

public class Square extends Rectangle{

    public Square() {
        super ();
    }

    public Square(String color) {
        super(color);
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(String color, double side) {
        super(color, side, side);

    }
}
