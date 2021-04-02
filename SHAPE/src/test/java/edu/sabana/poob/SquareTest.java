package edu.sabana.poob;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

    private static Square s1;
    private static Square s2;
    private static Square s3;
    private static Square s4;

    @BeforeAll
    public static void setUp() {
        s1 = new Square(10);
        s2 = new Square("blue");
        s3 = new Square();
        s4 = new Square("purple", 25);
    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(100, (int) s1.getArea());
        assertEquals(1, (int) s2.getArea());
        assertEquals(1, (int) s3.getArea());
        assertEquals(625, (int) s4.getArea());
    }

    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(40, (int) s1.getPerimeter());
        assertEquals(4, (int) s2.getPerimeter());
        assertEquals(4, (int) s3.getPerimeter());
        assertEquals(100, (int) s4.getPerimeter());
    }

    @Test
    public void shouldCalculateDiagonal() {

        assertEquals(14, (int) s1.getDiagonal());
        assertEquals(1, (int) s2.getDiagonal());
        assertEquals(1, (int) s3.getDiagonal());
        assertEquals(35, (int) s4.getDiagonal());
    }

    @Test
    public void shouldPrintCircle() {

        assertEquals("This is a Square with color NONE, length 10.0 and width 10.0", s1.toString());
        assertEquals("This is a Square with color blue, length 1.0 and width 1.0", s2.toString());
        assertEquals("This is a Square with color NONE, length 1.0 and width 1.0", s3.toString());
        assertEquals("This is a Square with color purple, length 25.0 and width 25.0", s4.toString());
    }
}
