package edu.sabana.poob;

public class Cube extends RectangleSolid{

    public Cube() {
    }

    public Cube(String color){
        super(color);
    }

    public Cube(double side){
        super(side, side, side);
    }

    public Cube(Double side, String color){
        super(color, side, side, side);
    }


}
