package edu.sabana.poob;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PyramidTest {

    private static Pyramid p1;
    private static Pyramid p2;
    private static Pyramid p3;
    private static Pyramid p4;

    @BeforeAll
    public static void setUp() {
        p1 = new Pyramid();
        p2 = new Pyramid("yellow");
        p3 = new Pyramid(4.0,4.0,4.0,2*Math.sqrt(3));
        p4 = new Pyramid("blue",9.0,9.0,9.0, Math.sqrt(3)*4.5);
    }

    @Test
        public void shouldCalculateArea() {
        assertEquals(Math.sqrt(3)/4, p1.getArea());
        assertEquals(Math.sqrt(3)/4, p2.getArea());
        assertEquals(Math.sqrt(3)*4, p3.getArea());
        assertEquals(Math.sqrt(3)*81/4, p4.getArea());
    }

    @Test
    public void shouldCalculatePerimeter() {
        assertEquals(3.0, p1.getPerimeter());
        assertEquals(3.0, p2.getPerimeter());
        assertEquals(12.0,p3.getPerimeter());
        assertEquals(27.0, p4.getPerimeter());
    }

    @Test
    public void shouldCalculateVolume() {

        assertEquals(Math.sqrt(3)/12, p1.getVolume());
        assertEquals(Math.sqrt(3)/12, p2.getVolume());
        assertEquals(7, (int) p3.getVolume());
        assertEquals(91.125, p4.getVolume());
    }

    @Test
    public void shouldCalculateSuperficialArea() {

        assertEquals(Math.sqrt(3)*1, p1.getSuperficialArea());
        assertEquals(Math.sqrt(3)*1, p2.getSuperficialArea());
        assertEquals(Math.sqrt(3)*16, p3.getSuperficialArea());
        assertEquals(Math.sqrt(3)*81, p4.getSuperficialArea());
    }


    @Test
    public void shouldPrintPyramid(){
        assertTrue(p1.toStringGeometricShape2D().contains("This is a Pyramid"));
        assertTrue(p2.toStringGeometricShape2D().contains("This is a Pyramid"));
        assertTrue(p3.toStringGeometricShape2D().contains("This is a Pyramid"));
        assertTrue(p4.toStringGeometricShape2D().contains("This is a Pyramid"));
    }

}
