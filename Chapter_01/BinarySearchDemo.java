package com.nicktheblackbeard;
import java.util.Arrays;


public class BinarySearchDemo {

    public static void main(String[] args) {
	    int[] whitelist = {1,2,3,4,7,321,-2,-5,2};
	    Arrays.sort(whitelist);

	    int numberForSearch = 4;
	    int result = BinarySearch.indexOf(whitelist,numberForSearch);
	    if(result == -1)    System.out.println("Not Found");
	    else    System.out.println("Found");

    }
}



class BinarySearch{
    public static int indexOf(int[] a, int key){
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid ;
        }
        return -1;
    }
}
