package com.example.softwaretesting;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

class Mycomparator implements Comparator
{
    public int compare(Object o1, Object o2)
    {
        Integer num1=(Integer)o1;
        Integer num2=(Integer)o2;
        return num2.compareTo(num1);
    }
}
public class MainProg {
    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        PriorityQueue<Integer> maxHeap=new PriorityQueue<Integer>(new Mycomparator());
        int i=l;
        System.out.print("1 ");
        if(k == 0 || k > r+1)
        {
            System.out.print("2 ");
            return Integer.MIN_VALUE;
        }

        for(;i<k  ;i++)
        {
            System.out.print("3 ");
            maxHeap.add(arr[i]);
            System.out.print("4 ");
        }
        System.out.print("3 ");
        int pop;
        System.out.print("5 ");
        for(;i<=r;i++)
        {
            System.out.print("6 ");

            if( arr[i]<(Integer)maxHeap.peek())
            {
                System.out.print("7 ");
                pop=maxHeap.poll();
                maxHeap.add(arr[i]);
            }
            System.out.print("5 ");

        }

        System.out.print("8 ");
        pop=maxHeap.poll();
        return(pop);

    }

    public static int binarySearch(int arr[], int first, int last, int key){
        System.out.print("1 ");
        while( first <= last ){
            int mid = (first + last)/2;
            System.out.print("2 ");
            if ( arr[mid] < key )
            {
                System.out.print("3 ");
                first = mid + 1;
            }
            else if ( arr[mid] == key )
            {
                System.out.print("4 ");
                System.out.println("Element is found at index: " + mid);
                return mid;
            }
            else
            {
                System.out.print("5 ");
                last = mid - 1;
            }
            System.out.print("1 ");
        }
        System.out.print("6 ");
        return -1;

    }

    public static boolean isAnagram(String word, String anagram)
    {
        System.out.print("1 ");
        if(word.length() != anagram.length())
        {
            System.out.print("2 ");
            return false;
        }
        System.out.print("3 ");
        char[] chars = word.toCharArray();
        for(char c : chars)
        {
            System.out.print("4 ");
            int index = anagram.indexOf(c);
            if(index != -1)
            {
                System.out.print("5 ");
                anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length());
            }
            else
            {
                System.out.print("6 ");
                return false;
            }
            System.out.print("3 ");

        }
        System.out.print("7 ");
        return anagram.isEmpty();
    }


    public static void main(String[] args)
    {

        //pp cov
        int arr[] =  {7,-1,0,4,12};
        // 1 -2
        /*System.out.println(kthSmallest(arr,0,arr.length-1,0));



        arr= new int[]{0,-1}; //1 3 4 3 4 3 5 8
        System.out.println(kthSmallest(arr,0,arr.length-1,2));
        arr= new int[]{4,3,2,6,0,5}; // 1,3,4,3,5,6,7,5,6,7,5,6,5,6,7,5,6,5,8
        System.out.println(kthSmallest(arr,0,arr.length-1,1));
        arr= new int[]{4}; // 1,3,4,3,5,8 , side trip 1 3 5 8
        System.out.println(kthSmallest(arr,0,arr.length-1,1));

        //ec
        arr= new int[]{8,9,6}; // 1,3,4,3,5,6,5,6,7,5,8
        System.out.println(kthSmallest(arr,0,arr.length-1,1));
        System.out.println(kthSmallest(arr,0,arr.length-1,4)); // 1-2*/


        /*int[] b=new int[]{1,3,432,431,10};
        binarySearch(b,0,b.length-1,30);
        //EC
        b=new int[]{3,6,10,14};
        binarySearch(b,0,b.length-1,4);// 1 2 5 1 2 3 1 6

        b=new int[]{3,6,10};
        binarySearch(b,0,b.length-1,6);// 1 2 4

    //PPc
        b=new int[]{2,4,5,7,9,12};
        System.out.println(binarySearch(b,0,b.length-1,7));// 1 2 4

        b=new int[]{2,5,8,10,11,15,16,17};
        System.out.println(binarySearch(b,0,b.length-1,9));// 1 2 5 1 2 3 1 2 3 1 6
        b=new int[]{5};
        System.out.println(binarySearch(b,0,b.length-1,4));// 1 2 5 1 6

        b=new int[]{2,5,7};
        System.out.println(binarySearch(b,0,b.length-1,1));// 1 2 5 1 2 5 1 6

        b=new int[]{2,5,7};
        System.out.println(binarySearch(b,0,b.length-1,7));// 1 2 3 1 2 4*/

    }
}
