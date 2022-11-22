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
        
    }
}

