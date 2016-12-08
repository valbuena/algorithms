package com.algorithms.search;


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
