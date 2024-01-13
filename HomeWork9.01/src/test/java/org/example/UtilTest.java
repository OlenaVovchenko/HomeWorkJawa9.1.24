package org.example;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.example.Util.countWinNum;

public class UtilTest {

    @Test
    public void testCountWinNum() {
        Integer[] userData = {1, 2, 3, 4, 5};
        Integer[] winData = {5, 4, 3, 2, 1};
        int expected = 5; // Предполагаем, что все номера совпадут

        assertEquals(expected, countWinNum(userData, winData).intValue());
    }

}