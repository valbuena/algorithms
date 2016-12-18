package com.algorithms.sort;

import org.junit.Assert;
import org.junit.Test;

public class QuickSortTest {

    QuickSort quickSort = new QuickSort();

    @Test
    public void tets_EmptyList (){
        int [] unsorted = {};
        int [] result = quickSort.quickSort(unsorted);
        Assert.assertArrayEquals(new int[]{}, result);
    }

    @Test
    public void tets_OneElementList (){
        int [] unsorted = {1};
        int [] result = quickSort.quickSort(unsorted);
        Assert.assertArrayEquals(new int[]{1}, result);
    }

    @Test
    public void tets_SimpleList (){
        int [] unsorted = {2,4,6,8,7,5,3,1};
        int [] result = quickSort.quickSort(unsorted);
        Assert.assertArrayEquals(new int[]{1,2,3,4,5,6,7,8}, result);
    }

    @Test
    public void tets_ComplexList (){
        int [] unsorted = {20,-40,6,-80,17,54,-3,0};
        int [] result = quickSort.quickSort(unsorted);
        Assert.assertArrayEquals(new int[]{-80,-40,-3,0,6,17,20,54}, result);
    }
}
