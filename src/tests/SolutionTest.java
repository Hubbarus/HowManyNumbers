package tests;

import org.junit.Test;
import source.Solution;
import java.util.ArrayList;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void parseIntTest() {
        assertEquals(Arrays.asList(8L, 118L, 334L), Solution.findAll(10, 3));
        assertEquals(Arrays.asList(1L, 999L, 999L), Solution.findAll(27, 3));
        assertEquals(new ArrayList<Long>(), Solution.findAll(84, 4));
        assertEquals(Arrays.asList(123L, 116999L, 566666L), Solution.findAll(35, 6));

    }
}
