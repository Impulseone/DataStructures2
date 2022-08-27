package AlgorithmsDataStructures2;

import org.junit.Test;

import static org.junit.Assert.*;

public class AlgorithmsDataStructures2Test {
    @Test
    public void testGenerateBBSTArray() {
        int[] resultArray = AlgorithmsDataStructures2.GenerateBBSTArray(new int[]{1, 2, 3, 4, 5});
        assertEquals(3, resultArray[0]);
        assertEquals(2, resultArray[1]);
        assertEquals(5, resultArray[2]);
        assertEquals(1, resultArray[3]);
        assertEquals(0, resultArray[4]);
        assertEquals(4, resultArray[5]);
        assertEquals(0, resultArray[6]);
    }
}