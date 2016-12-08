package com.algorithms.sort;

public class SelectSort {

    public int[] selectSort (int [] unsorted) {
        int[] result = new int[unsorted.length];
        for (int i = 0; i < result.length; i++) {
            int positionSmaller = getPositionSmaller(unsorted);
            result[i] = unsorted[positionSmaller];
            unsorted = removeElement(unsorted, positionSmaller);
        }
        return result;
    }

    private int getPositionSmaller(int [] list){
        int result = 0 ;
        int small = list[0];
        for (int i = 0; i < list.length; i++) {
            if (small > list[i]){
                small = list[i];
                result = i;
            }
        }
        return result;
    }

    private int[] removeElement (int[] list, int position){
        if (list == null || list.length < 1)
            return new int[0];

        int [] result = new int[list.length-1];
        System.arraycopy(list,0,result,0,position);
        if (position < result.length) {
            System.arraycopy(list, position + 1, result, position, list.length - position - 1);
        }

        return result;
    }
}
