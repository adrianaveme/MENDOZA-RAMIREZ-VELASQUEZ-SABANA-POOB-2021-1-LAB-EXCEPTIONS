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
    public static void setUp() {
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
        assertEquals("This is a Triangle with color NONE and sides that measure 1.0, 1.0 and 1.0", t1.toString());
        assertEquals("This is a Triangle with color yellow and sides that measure 1.0, 1.0 and 1.0", t2.toString());
        assertEquals("This is a Triangle with color NONE and sides that measure 4.0, 6.0 and 4.0", t3.toString());
        assertEquals("This is a Triangle with color blue and sides that measure 9.0, 7.0 and 8.0", t4.toString());
    }
}
