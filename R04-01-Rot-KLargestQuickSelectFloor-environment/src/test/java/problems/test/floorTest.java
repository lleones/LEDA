package problems.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import problems.FloorBinarySearchImpl;

public class floorTest {
    private FloorBinarySearchImpl implementation;
    private Integer[] array;

    @Before
    public void setUp() {
        this.implementation = new FloorBinarySearchImpl();
        this.array = new Integer[] { 5, 10, 40, 25, 21, 24, 37, 8, 9, 2, -3, -5 };
    }

    @Test
    public void floorBinaryTest01() {
        assertEquals((Integer) 5, this.implementation.floor(array, 6));
    }

    @Test
    public void floorBinaryTest02() {
        assertEquals((Integer) 37, this.implementation.floor(array, 37));
    }

    @Test
    public void floorBinaryTest03() {
        assertNull(this.implementation.floor(array, -6));
    }

    @Test
    public void floorBinaryTest04() {
        assertEquals((Integer) (-3), this.implementation.floor(array, 1));
    }

    @Test
    public void floorBinaryTest05() {
        assertEquals((Integer) (-5), this.implementation.floor(array, -4));
    }

    @Test
    public void floorBinaryTest06() {
        assertEquals((Integer) (-3), this.implementation.floor(array, -3));
    }

    @Test
    public void floorBinaryTest07() {
        assertEquals((Integer) (40), this.implementation.floor(array, 100));
    }

    @Test
    public void floorBinaryTest08() {
        assertNull(this.implementation.floor(null, 100));
    }

    @Test
    public void floorBinaryTest09() {
        assertNull(this.implementation.floor(new Integer[0], 100));
    }

    @Test
    public void floorBinaryTest10() {
        assertNull(this.implementation.floor(array, null));
    }
}