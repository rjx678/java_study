package com.company;

import java.util.Arrays;
public class myBinarySearch {
    public static int binarySearch(int[] arr,int value){
        int low=0,high=arr.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(arr[mid]==value)
                return mid;
            else if(arr[mid]<value)
                low=mid+1;
            else if(arr[mid]>value)
                high=mid-1;
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr={2,5,6,7,3,10,30,20,40,80,70};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr,80));
    }

}
