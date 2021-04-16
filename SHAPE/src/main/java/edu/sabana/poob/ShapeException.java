package edu.sabana.poob;

public class ShapeException extends Exception {
    public static final String BAD_DIMENSION_SIDE = "Size cannot be negative or equal to zero";

    public ShapeException(String BAD_DIMENSION_SIDE) {
        super();
    }

    @Override
    public String getMessage(){
        return "Size cannot be negative or equal to zero";
    }
}
