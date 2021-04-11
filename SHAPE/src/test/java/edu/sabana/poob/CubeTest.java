package edu.sabana.poob;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CubeTest {
    private static Cube cu1;
    private static Cube cu2;
    private static Cube cu3;
    private static Cube cu4;

    @BeforeAll
    public static void setUp() {
        cu1 = new Cube();
        cu2 = new Cube(5.0, "red");
        cu3 = new Cube("Green");
        cu4 = new Cube(2.0);

    }

    @Test
    public void shouldCalculateArea() {
        assertEquals(1, (int) cu1.getArea());
        assertEquals(25, (int) cu2.getArea());
        assertEquals(1, (int) cu3.getArea());
        assertEquals(4, (int) cu4.getArea());
    }

    @Test
    public void shouldCalculatePerimeter() {

        assertEquals(4, (int) cu1.getPerimeter());
        assertEquals(20, (int) cu2.getPerimeter());
        assertEquals(4, (int) cu3.getPerimeter());
        assertEquals(8, (int) cu4.getPerimeter());
    }


    @Test
    public void shouldCalculateVolume() {

        assertEquals(1, (int) cu1.getVolume());
        assertEquals(125, (int) cu2.getVolume());
        assertEquals(1, (int) cu3.getVolume());
        assertEquals(8, (int) cu4.getVolume());
    }

    @Test
    public void shouldCalculateSuperficialArea() {

        assertEquals(6, (int) cu1.getSuperficialArea());
        assertEquals(150, (int) cu2.getSuperficialArea());
        assertEquals(6, (int) cu3.getSuperficialArea());
        assertEquals(24, (int) cu4.getSuperficialArea());
    }

    @Test
    public void shouldPrintCube() {

        assertTrue(cu1.toStringGeometricShape3D().contains("This is a Cube"));
        assertTrue(cu2.toStringGeometricShape3D().contains("This is a Cube"));
        assertTrue(cu3.toStringGeometricShape3D().contains("This is a Cube"));
    }
}
