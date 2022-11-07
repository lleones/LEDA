package orderStatistics.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.QuickSelect;

public class quickSelectTest {

    private QuickSelect<Integer> implementation;
    private Integer[] array;
    private Integer[] array2;

    @Before
    public void setUp() {
        this.implementation = new QuickSelect<>();
        this.array = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
        this.array2 = new Integer[] { 3, 1, 2, 5, 4 };
    }

    @Test
    public void quickSelectTest01() {
        assertEquals((Integer) 4, this.implementation.quickSelect(array, 1));
    }

    @Test
    public void quickSelectTest02() {
        assertEquals((Integer) 2, this.implementation.quickSelect(array2, 2));
    }

    @Test
    public void quickSelectTest03() {
        assertEquals((Integer) 7, this.implementation.quickSelect(array, 2));
    }
}
