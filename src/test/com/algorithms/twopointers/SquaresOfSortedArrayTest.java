package com.algorithms.twopointers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquaresOfSortedArrayTest {

    @Test
    void sortedSquares() {
        assertArrayEquals(new int[]{4,9,9,49,121},new SquaresOfSortedArray().sortedSquares(new int[]{-7,-3,2,3,11}));
    }
}