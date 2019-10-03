package com.company;
import java.util.Arrays;
public class myBubbleSort {
    public static void main(String[] args){
        int[] arr={3,1,6,2,9,0,7,4,5,8};
        for(int i=0;i<arr.length-1;i++){
            boolean flag=true;//没有交换元素
            for(int j=0;j<arr.length-1-i;j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
                System.out.println(Arrays.toString(arr));
            }
            if(flag)
                break;
            }
        }
    }


