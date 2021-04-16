package edu.sabana.poob;

public class Cube extends RectangleSolid{

    public Cube() {
    }

    public Cube(String color){
        super(color);
    }

    public Cube(double side) throws ShapeException{
        super(side, side, side);
    }

    public Cube(Double side, String color) throws ShapeException{
        super(color, side, side, side);
    }


}
