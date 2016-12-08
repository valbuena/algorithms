package com.algorithms.search;


import com.algorithms.search.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void test_NullList (){
        int result = binarySearch.getPositionWithBinarySearch(null, 1);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void test_EmptyList (){
        int [] list = {};
        int result = binarySearch.getPositionWithBinarySearch(list, 1);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void test_notExitsElement (){
        int [] list = {1,2,3,4,5,6,7,8};
        int result = binarySearch.getPositionWithBinarySearch(list, 9);
        Assert.assertEquals(-1, result);
    }

    @Test
    public void test_easyList (){
        int [] list = {1,2,3,4,5,6,7,8};
        int result = binarySearch.getPositionWithBinarySearch(list, 3);
        Assert.assertEquals(2, result);
    }

    @Test
    public void test_difficultList (){
        int [] list = {-40,-30,-23,4,12,35,57,58};
        int result = binarySearch.getPositionWithBinarySearch(list, 4);
        Assert.assertEquals(3, result);
    }

    @Test
    public void test_lowEndList (){
        int [] list = {-40,-30,-23,4,12,35,57,58};
        int result = binarySearch.getPositionWithBinarySearch(list, -40);
        Assert.assertEquals(0, result);
    }

    @Test
    public void test_HighEndList (){
        int [] list = {-40,-30,-23,4,12,35,57,58};
        int result = binarySearch.getPositionWithBinarySearch(list, 58);
        Assert.assertEquals(7, result);
    }

}
