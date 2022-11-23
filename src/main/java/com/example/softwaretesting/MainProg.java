package com.example.softwaretesting;


import java.util.*;

class LinkedList{
    public NodeMod head;
    public static class NodeMod
    {
        int data;
        NodeMod next;

        NodeMod(int data) {
            this.data = data;
            next = null;
        }
    }
    void addAtBegining(NodeMod newNode){
        newNode.next=head;//You're directly doing it with head, instead of taking current ref
        head=newNode;
    }
    void addAtEnd(NodeMod newNode){
        NodeMod temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
    }
    void addAtPosition(int pos, NodeMod newNode){
        NodeMod temp=head;
        if(pos==1) // one element
        {
            addAtBegining(newNode);
        }
        else
        {
            //Stand one node before the position
            for(int i=1;i<pos-1 && temp!=null;i++)
            {
                temp=temp.next;
            }

            newNode.next=temp.next;
            temp.next=newNode;
        }
    }
    void deleteAtBeg()
    {
        if(head!=null)
            head=head.next;
        else
            throw new RuntimeException("No elements in linked list, to delete");
    }
    void deleteAtEnd(){
        NodeMod temp=head;
        if(temp==null)//No elements
        {
            throw new RuntimeException("No elements in linked list, to delete");
        }
        else if(temp.next==null)
        {
            //only one element
            head=head.next;
        }
        else
        {
            while(temp.next.next!=null)
            {
                temp=temp.next;
            }
            temp.next=null;
        }
    }
    void deleteAtPosFromStart(int pos){
        if(head!=null)
        {
            NodeMod temp=head;
            for(int i=1;i<pos-1 && temp!=null;i++)
            {
                temp=temp.next;
            }
            temp.next=temp.next.next;
        }
        else
            throw new RuntimeException("No elements in linked list, to delete");
    }
    void deleteAtPosFromEnd(int pos){
        if(head!=null)
        {
            //totalNoOfelements - pos = gives the position count after which the element to delete exist.
            int count=0;
            NodeMod temp=head;
            while(temp!=null)
            {
                temp=temp.next;
                count++;
            }
            temp=head;
            if(count-pos == 0)//first element
            {
                deleteAtBeg();
            }
            else
            {
                for(int i=1;i<count-pos;i++)
                {
                    temp=temp.next;
                }
                temp.next=temp.next.next;
            }
        }
        else
            throw new RuntimeException("No elements in linked list, to delete");
    }
    void deleteAtPosFromEndInOnePass(int pos)
    {
        NodeMod trav1, trav2;
        trav1=trav2=head;
        int beginingDeleteFlag=0;
        for(int i=1;i<=pos+1;i++)
        {
            if(trav2==null)
            {
                beginingDeleteFlag=1;
                break;
            }
            trav2=trav2.next;
        }
        if(beginingDeleteFlag==1)
            deleteAtBeg();
        else
        {
            while(trav2!=null)
            {
                trav2=trav2.next;
                trav1=trav1.next;
            }
            trav1.next=trav1.next.next;
        }
    }
    void Display()
    {
        NodeMod temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.println();
    }

}
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



    static ArrayList<Integer> Insertionsort(ArrayList<Integer> arr) {
        int n = arr.size();
        for (int i = 1; i < n; ++i) {
            int key = arr.get(i);
            int j = i - 1;

            while (j >= 0 && arr.get(j) > key)
            {
                arr.set(j + 1, arr.get(j));
                j = j - 1;
            }
            arr.set(j + 1, key);
        }


        for (int i = 0; i < n; ++i)
            System.out.print(arr.get(i) + " ");
        System.out.println();
        return arr;
    }


    public static boolean IsLoopPresent(LinkedList l1)
    {
        LinkedList.NodeMod temp=l1.head;
        System.out.print("1 ");
        //push all next addresses into hash table.
        HashSet nextAddresses=new HashSet();
        boolean inserted=false;
        while(temp!=null)
        {
            System.out.print("2 ");
            if(nextAddresses.add(temp)==false)
            {
                //loop exists
                System.out.print("3 ");
                return true;
            }
            System.out.print("4 ");
            temp=temp.next;
            System.out.print("1 ");
        }
        System.out.print("5 ");
        return false;
    }
public static int sumOddLengthSubarrays(int arr[]) {
        System.out.print("1 ");
        int ans; 
        int n = arr.length;
        System.out.print("2 ");
        for(int i = 0; i < n; i++) { 
            System.out.print("3 ");
            int start = i;
            int end = n - i;
            int total = (start + 1) * (end);
            int odd = total / 2;
            System.out.print("4 ");
            if(total % 2 != 0) {
                System.out.print("5 ");
                odd++;
            }
			System.out.print("6 ");
            ans += arr[i] * odd;
            System.out.print("7 ");
        }
		System.out.print("8 ");
        return ans;
        
    }


public static int findMiddleIndex(int nums[]) {
            System.out.print("1 ");
        int n=nums.length;
        int sum=0;
        System.out.print("2 ");
        for(int i=0;i<n;i++)
        { 
            System.out.print("3 ");
           sum+=nums[i];
           System.out.print("5 ");
        }
        
        System.out.print("4 ");
        int l_sum=0;
        System.out.print("6 ");
        for(int i=0; i<n;i++)
        {   System.out.print("9 ");
            if(l_sum==sum-nums[i])
            {
                System.out.print("8 ");
                return i;
            }
            l_sum+=nums[i];
            sum=sum-nums[i];
            System.out.print("10 ");
        }
        System.out.print("7 ");
        return -1;
    }


    public static void main(String[] args)
    {
        

    }
}

