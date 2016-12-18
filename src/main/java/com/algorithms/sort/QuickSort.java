package com.algorithms.sort;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

/**
 * Shorting an array with divide and conquer.
 * Select a pivot
 * Divide array in two sub-arrays, elements less than the pivot
 * and elements greater than the pivot
 * and repeat recursively
 * O(n) = n log n
 * It's implemented with arrayList to explain better the algorithm
 */
public class QuickSort {

    public int[] quickSort (int[] unsorted){
        List<Integer> unsortedList = IntStream.of(unsorted)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> sortedList = quickSort(unsortedList);
        return sortedList.stream().mapToInt(Integer::intValue).toArray() ;
    }



    public List<Integer> quickSort (List<Integer> unsorted){

        if (unsorted == null || unsorted.size() == 0)
            return new ArrayList<>();
        if (unsorted.size() == 1)
            return unsorted;
        int index = unsorted.size() /2;
        Integer pivot = unsorted.get(index);
        unsorted.remove(index);

        List<Integer> less = new ArrayList();
        List<Integer> greater = new ArrayList();

        for (Integer element: unsorted) {
            if (pivot > element){
                less.add(element);
            }else{
                greater.add(element);
            }
        }

        List<Integer> sorted = quickSort(less);
        sorted.add(pivot);
        sorted.addAll(quickSort(greater));

        return sorted;

    }
}
