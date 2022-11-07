package orderStatistics.test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import orderStatistic.KLargestOrderStatisticsImpl;

public class orderStatisticsTest {

    private KLargestOrderStatisticsImpl<Integer> implementation;
    private Integer[] array;

    @Before
    public void setUp() {
        this.implementation = new KLargestOrderStatisticsImpl<>();
        this.array = new Integer[] { 30, 28, 7, 29, 11, 26, 4, 22, 23, 31 };
    }

    @Test
    public void testGetKLargest() {

    }

    @Test
    public void testOrderStatistics01() {
        assertEquals((Integer) 4, this.implementation.orderStatistics(this.array, 1));
    }

    @Test
    public void testOrderStatistics02() {
        assertEquals((Integer) 7, this.implementation.orderStatistics(this.array, 2));
    }

    @Test
    public void testOrderStatistics04() {
        assertEquals((Integer) 31, this.implementation.orderStatistics(this.array, 10));
    }

    @Test
    public void testOrderStatistics06() {
        assertNull(this.implementation.orderStatistics(null, 1));
    }

    @Test
    public void testOrderStatistics07() {
        assertNull(this.implementation.orderStatistics(this.array, 11));
    }

    @Test
    public void testOrderStatistics08() {
        assertNull(this.implementation.orderStatistics(this.array, 0));
    }

    @Test
    public void testOrderStatistics09() {
        assertNull(this.implementation.orderStatistics(new Integer[] {}, 1));
    }

    @Test
    public void testGetKLargest01() {
        assertArrayEquals(new Integer[] { 31 }, this.implementation.getKLargest(array, 1));
    }

    @Test
    public void testGetKLargest02() {
        assertArrayEquals(new Integer[] { 4, 7, 11, 22, 23, 26, 28, 29, 30, 31 },
                this.implementation.getKLargest(array, 10));
    }

    @Test
    public void testGetKLargest03() {
        assertArrayEquals(new Integer[] { 30, 31 }, this.implementation.getKLargest(array, 2));
    }

    @Test
    public void testGetKLargest04() {
        assertArrayEquals(new Integer[] { 7, 11, 22, 23, 26, 28, 29, 30, 31 },
                this.implementation.getKLargest(array, 9));
    }

    @Test
    public void test01() {
        Integer[] array = new Integer[]{12, 8, 4, 9, 6};
        Comparable[] arrayKLargest = this.implementation.getKLargest(array, 3);
        Comparable[] expectedArray = new Integer[]{8, 9, 12};
        assertArrayEquals(expectedArray, arrayKLargest);
    }

    @Test
    public void test06() {
        Integer[] array = new Integer[]{6, 6, 6, 6, 6};
        Comparable[] expectedArray = new Comparable[]{6, 6, 6};
        assertArrayEquals(expectedArray, this.implementation.getKLargest(array, 3));
    }

    @Test
    public void test08() {
        Comparable[] expectedArray = new Comparable[]{};
        assertArrayEquals(expectedArray, this.implementation.getKLargest(null, 1));
    }
}