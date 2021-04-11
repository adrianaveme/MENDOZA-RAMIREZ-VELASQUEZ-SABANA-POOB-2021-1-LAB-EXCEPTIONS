package edu.sabana.poob;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class RectangleSolidTest {

    private static RectangleSolid rs1;
    private static RectangleSolid rs2;
    private static RectangleSolid rs3;
    private static RectangleSolid rs4;

    @BeforeAll
    public void setUp() {
        rs1 = new RectangleSolid();
        rs2 = new RectangleSolid("yellow");
        rs3 = new RectangleSolid(3.0, 4.0, 5.0);
        rs4 = new RectangleSolid("blue",6.1, 2.3, 3.1);
    }

    @Test
    public void shouldCalculateArea(){
        assertEquals(1.0, rs1.getArea());
        assertEquals(1.0, rs2.getArea());
        assertEquals(12.0, rs3.getArea());
        assertEquals(14.03, rs4.getArea());
    }

    @Test
    public void shouldCalculatePerimeter(){
        assertEquals(4.0, rs1.getPerimeter());
        assertEquals(4.0, rs2.getPerimeter());
        assertEquals(14.0, rs3.getPerimeter());
        assertEquals(16.8, rs1.getPerimeter());
    }

}
