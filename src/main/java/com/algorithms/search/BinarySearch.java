package com.algorithms.search;

/**
 * Given a sort int array, we search an int.
 * We have to divide the array at the middle several times to find the number
 */
public class BinarySearch {

    public int getPositionWithBinarySearch (int[] listShorted, int searched){
        int result = -1;
        if (listShorted == null)
            return result;

        int low = 0;
        int high = listShorted.length-1;
        while (low <= high){
            int mid = (high + low) / 2 ;
            int guess = listShorted[mid];
            //We found it
            if (guess == searched){
                return mid;
            }

            if (guess > searched){
                high = mid - 1;
            }else{
                low = mid +1;
            }
        }

        return result;
    }
}
