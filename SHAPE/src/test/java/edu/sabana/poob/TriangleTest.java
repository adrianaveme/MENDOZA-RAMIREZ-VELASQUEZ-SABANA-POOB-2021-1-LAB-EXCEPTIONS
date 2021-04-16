package edu.sabana.poob;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleTest {

    private static Triangle t1;
    private static Triangle t2;
    private static Triangle t3;
    private static Triangle t4;

    @BeforeAll
    public static void setUp() throws ShapeException {
        t1 = new Triangle();
        t2 = new Triangle("yellow");
        t3 = new Triangle(4.0,6.0,4.0);
        t4 = new Triangle("blue",9.0,7.0,8.0);
    }

    @Test
    @DisplayName("GIVEN a triangle WHEN asked for area SHOULD return correct value")
    public void shouldCalculateArea() {
        assertEquals(Math.sqrt(3)/4, t1.getArea());
        assertEquals(Math.sqrt(3)/4, t2.getArea());
        assertEquals(Math.sqrt(7)*3, t3.getArea());
        assertEquals(Math.sqrt(5)*12, t4.getArea());
    }

    @Test
    @DisplayName("GIVEN a triangle WHEN asked for perimeter SHOULD return correct value")
    public void shouldCalculatePerimeter() {
        assertEquals(3.0, t1.getPerimeter());
        assertEquals(3.0, t2.getPerimeter());
        assertEquals(14.0,t3.getPerimeter());
        assertEquals(24.0, t4.getPerimeter());
    }

    @Test
    @DisplayName("GIVEN a triangle with two equal sides WHEN asked whether it is isosceles SHOULD return true")
    public void shouldReturnThatTriangleIsIsosceles() {
        assertTrue(t3.isIsosceles());
    }

    @Test
    @DisplayName("GIVEN a triangle with three equal sides or three different sides WHEN asked whether it is isosceles SHOULD return false")
    public void shouldReturnThatTriangleIsNotIsosceles() {
        assertFalse(t1.isIsosceles());
        assertFalse(t4.isIsosceles());
    }

    @Test
    @DisplayName("GIVEN a triangle with three equal sides WHEN asked whether it is equilateral SHOULD return true")
    public void shouldReturnThatTriangleIsEquilateral() {
        assertTrue(t2.isEquilateral());
    }

    @Test
    @DisplayName("GIVEN a triangle with two equal sides or three different sides WHEN asked whether it is equilateral SHOULD return false")
    public void shouldReturnThatTriangleIsNotEquilateral() {
        assertFalse(t3.isEquilateral());
        assertFalse(t4.isEquilateral());
    }

    @Test
    @DisplayName("GIVEN a triangle WHEN printed SHOULD return a message with its atributes")
    public void shouldPrintTriangle(){
        assertTrue(t1.toStringGeometricShape2D().contains("This is a Triangle"));
        assertTrue(t2.toStringGeometricShape2D().contains("This is a Triangle"));
        assertTrue(t3.toStringGeometricShape2D().contains("This is a Triangle"));
        assertTrue(t4.toStringGeometricShape2D().contains("This is a Triangle"));
    }

    @Test
    public void shouldNotCreateTriangleWithSize1Negative() {

        try {
            new Triangle(-8, 7, 9);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }

    @Test
    public void shouldNotCreateTriangleWithSize2Negative() {

        try {
            new Triangle(8, -7, 9);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }

    @Test
    public void shouldNotCreateTriangleWithSize3Negative() {

        try {
            new Triangle(8, 7, -9);
        } catch (ShapeException e) {
            assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
        }
    }

    @Test
    public void shouldNotCreateTriangleWithSize1Zero() {

        Exception e = assertThrows(ShapeException.class, () -> new Triangle(0, 7, 7));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
    }

    @Test
    public void shouldNotCreateTriangleWithSize2Zero() {

        Exception e = assertThrows(ShapeException.class, () -> new Triangle(7, 0, 7));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
    }

    @Test
    public void shouldNotCreateTriangleWithSize3Zero() {

        Exception e = assertThrows(ShapeException.class, () -> new Triangle(7, 7, 0));
        assertEquals(ShapeException.BAD_DIMENSION_SIDE, e.getMessage());
    }
}
