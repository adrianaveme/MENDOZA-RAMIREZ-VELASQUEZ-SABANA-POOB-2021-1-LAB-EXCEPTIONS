package edu.sabana.poob;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SquareTest {

    private static Square s1;
    private static Square s2;
    private static Square s3;
    private static Square s4;

    @BeforeAll
    public static void setUp() throws ShapeException {
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
    public void shouldPrintSquare() {

        assertTrue(s1.toStringGeometricShape2D().contains("This is a Square"));
        assertTrue(s2.toStringGeometricShape2D().contains("This is a Square"));
        assertTrue(s3.toStringGeometricShape2D().contains("This is a Square"));
        assertTrue(s4.toStringGeometricShape2D().contains("This is a Square"));

    }

    @Test
    public void shouldNotCreateSquareWithSideNegative() {

        try {
            new Square(-1);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }

    @Test
    public void shouldNotCreateSquareWithSideZero() {

        Exception e = assertThrows(ShapeException.class, () -> new Square(0));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
    }
}
