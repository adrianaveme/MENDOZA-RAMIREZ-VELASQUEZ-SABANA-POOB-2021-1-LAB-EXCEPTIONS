package edu.sabana.poob;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleSolidTest {

    private static RectangleSolid rs1;
    private static RectangleSolid rs2;
    private static RectangleSolid rs3;
    private static RectangleSolid rs4;

    @BeforeAll
    public static void setUp() {
        rs1 = new RectangleSolid();
        rs2 = new RectangleSolid("yellow");
        rs3 = new RectangleSolid(3.0, 4.0, 5.0);
        rs4 = new RectangleSolid("blue",6.0, 2.5, 3.0);
    }

    @Test
    public void shouldCalculateArea(){
        assertEquals(1.0, rs1.getArea());
        assertEquals(1.0, rs2.getArea());
        assertEquals(12.0, rs3.getArea());
        assertEquals(15.0, rs4.getArea());
    }

    @Test
    public void shouldCalculatePerimeter(){
        assertEquals(4.0, rs1.getPerimeter());
        assertEquals(4.0, rs2.getPerimeter());
        assertEquals(14.0, rs3.getPerimeter());
        assertEquals(17.0, rs4.getPerimeter());
    }

    @Test
    public void shouldCalculateVolume(){
        assertEquals(1.0, rs1.getVolume());
        assertEquals(1.0, rs2.getVolume());
        assertEquals(60.0, rs3.getVolume());
        assertEquals(45.0, rs4.getVolume());
    }

    @Test
    public void shouldCalculateSuperficialArea(){
        assertEquals(6.0, rs1.getSuperficialArea());
        assertEquals(6.0, rs2.getSuperficialArea());
        assertEquals(94.0, rs3.getSuperficialArea());
        assertEquals(81.0, rs4.getSuperficialArea());
    }
}
