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
    
	
	void addAtBegining(NodeMod newNode)
	{
        	
		newNode.next=head;//You're directly doing it with head, instead of taking current ref
        	
		head=newNode;
    	
	}
    
	
	void addAtEnd(NodeMod newNode)
	{
        
		NodeMod temp=head;
        
		while(temp.next!=null)
		{
            		
			temp=temp.next;
        	}
        	
		temp.next=newNode;
    	}
    
	void addAtPosition(int pos, NodeMod newNode)
	{
        	
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
    
	void deleteAtEnd()
	{
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
    
	void deleteAtPosFromStart(int pos)
	{
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
    
	void deleteAtPosFromEnd(int pos)
	{
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
        
	//System.out.print("1 ");
        
	if(k == 0 || k > r+1)
        {
            //System.out.print("2 ");
            
	    return Integer.MIN_VALUE;
        }

        for(;i<k  ;i++)
        {
            
	    //System.out.print("3 ");
            
	    maxHeap.add(arr[i]);
            
	    //System.out.print("4 ");
        }
        
	//System.out.print("3 ");
        
	int pop;
        
	//System.out.print("5 ");
        
	for(;i<=r;i++)
        {
            //System.out.print("6 ");

            if( arr[i]<(Integer)maxHeap.peek())
            {
                
		//System.out.print("7 ");
                
		pop=maxHeap.poll();
                
		maxHeap.add(arr[i]);
            }
            
	    //System.out.print("5 ");

        }

        //System.out.print("8 ");
        
	pop=maxHeap.poll();
        
	return(pop);

    }

    public static int binarySearch(int arr[], int first, int last, int key){
        
	//System.out.print("1 ");
        
	while( first <= last ){
        
	    int mid = (first + last)/2;
            
	    //System.out.print("2 ");
            
	    if ( arr[mid] < key )
            {
            
	    	//System.out.print("3 ");
                
		first = mid + 1;
            }
            else if ( arr[mid] == key )
            {
                
		//System.out.print("4 ");
                
		System.out.println("Element is found at index: " + mid);
                
		return mid;
            }
            else
            {
                
		//System.out.print("5 ");
                
		last = mid - 1;
            }
            
	    //System.out.print("1 ");
        }
        
	//System.out.print("6 ");
        
	return -1;

    }

    public static boolean isAnagram(String word, String anagram)
    {
        //System.out.print("1 ");
        
	if(word.length() != anagram.length())
        {
            //System.out.print("2 ");
            
	    return false;
        }
        
	//System.out.print("3 ");
        
	char[] chars = word.toCharArray();
        
	for(char c : chars)
        {
            
	    //System.out.print("4 ");
            
	    int index = anagram.indexOf(c);
            
	    if(index != -1)
            {
                
		//System.out.print("5 ");
                
		anagram = anagram.substring(0,index) + anagram.substring(index +1, anagram.length());
            }
            else
            {
                
		//System.out.print("6 ");
                
		return false;
            }
            
	    //System.out.print("3 ");

        }
        
	//System.out.print("7 ");
        
	return anagram.isEmpty();
    }



    static ArrayList<Integer> Insertionsort(ArrayList<Integer> arr) 
    {
        
	int n = arr.size();
        
	for (int i = 1; i < n; ++i) 
	{
            
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
        
	//System.out.println();
        
	return arr;
    }


    public static boolean IsLoopPresent(LinkedList l1)
    {
        
	LinkedList.NodeMod temp=l1.head;
        
	//System.out.print("1 ");
        
	//push all next addresses into hash table.
        
	HashSet nextAddresses=new HashSet();
        
	boolean inserted=false;
        
	while(temp!=null)
        {
            
	    //System.out.print("2 ");
            
	    if(nextAddresses.add(temp)==false)
            {
                //loop exists
                
		//System.out.print("3 ");
                
		return true;
            }
            
	    //System.out.print("4 ");
            
	    temp=temp.next;
            
	    //System.out.print("1 ");
        }
        
	//System.out.print("5 ");
        
	return false;
    }
public static int sumOddLengthSubarrays(int arr[]) 
{
        
	//System.out.print("1 ");
        
	int ans=0; 
        
	int n = arr.length;
        
	System.out.print("2 ");
        
	for(int i = 0; i < n; i++) 
	{ 
            
	    //System.out.print("3 ");
            
	    int start = i;
            
	    int end = n - i;
            
	    int total = (start + 1) * (end);
            
	    int odd = total / 2;
            
	    //System.out.print("4 ");
            
	    if(total % 2 != 0) 
	    {
               // System.out.print("5 ");
                
		odd++;
            }
	
		//System.out.print("6 ");
            
	    ans += arr[i] * odd;
            
	    //System.out.print("7 ");
        }
		//System.out.print("8 ");
        
	return ans;
        
    }


public static int findMiddleIndex(int nums[]) {
            
	//System.out.print("1 ");
        
	int n=nums.length;
        
	int sum=0;
        
	//System.out.print("2 ");
        
	for(int i=0;i<n;i++)
        { 
           
	   //System.out.print("3 ");
           sum+=nums[i];
           //System.out.print("5 ");
        }
        
        //System.out.print("4 ");
        
	int l_sum=0;
        //System.out.print("6 ");
        
	for(int i=0; i<n;i++)
        {   
		//System.out.print("9 ");
            
	    if(l_sum==sum-nums[i])
            {
                //System.out.print("8 ");
                
		return i;
            }
            
	    l_sum+=nums[i];
            
	    sum=sum-nums[i];
            
	    //System.out.print("10 ");
        }
        
	//System.out.print("7 ");
        return -1;
    }

public static boolean findSubarrays(int n[]) 
{
            //System.out.print("1 ");
        int k=n.length;
        
	int a[]=new int[k-1];
        
	//System.out.print("2 ");
        
	for(int i=1;i<k;i++)
        {
            //System.out.print("3 ");
            a[i-1]=n[i-1]+n[i];
        }
        
	//System.out.print("4 ");
        Arrays.sort(a);
        
	//System.out.print("5 ");
        
	for(int i=0;i<k-2;i++)
        {
            //System.out.print("6 ");
            if(a[i]==a[i+1])
            {
                //System.out.print("7 ");
                return true;
            }
        }
        return false;
    }

    public static int linearsearch(int[] arr,int key)
    {
        int n=arr.length;

        for (int i=0;i<n;i++)
        {
            if(arr[i] == key)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        
        
        while (true)
        {

            System.out.println("----------Java basic Programs----------");

            System.out.println("1. Binary Search \n"
                    +"2. Linear Search\n"
                    +"3. Anagrams\n"
                    +"4. Loop present in linked list\n"
                    +"5. Insertion sort \n"
                    +"6. Kth Smallest \n"
                    +"7. Sum Odd Length Subarrays\n"
                    +"8. Find Middle Index\n"
                    +"9. Find Subarrays\n"
            );


            System.out.println("Enter your choice: ");

            Scanner sc= new Scanner(System.in);

            int choice;

            choice=sc.nextInt();

            switch (choice)
            {

                case 1:
                    System.out.println("Your choice: "+ choice);

                    System.out.println("BINARY SEARCH");

                    int size;

                    System.out.println("Enter array size");

                    size = sc.nextInt();

                    System.out.println("Enter "+size+" elements");

                    int arr[]= new int[size];

                    for(int i=0; i<size;i++)
                        arr[i] = sc.nextInt();

                    System.out.println("Enter key to be searched ");

                    int key;

                    key=sc.nextInt();

                    System.out.println(binarySearch(arr,0,arr.length-1,key));

                    break;
                case 2:
                    System.out.println("Your choice: "+ choice);

                    System.out.println("LINEAR SEARCH");

                    System.out.println("Enter array size");

                    size = sc.nextInt();

                    System.out.println("Enter "+size+" elements");

                    arr= new int[size];

                    for(int i=0; i<size;i++)
                        arr[i] = sc.nextInt();

                    System.out.println("Enter key to be searched ");

                    key=sc.nextInt();

                    System.out.println(linearsearch(arr,key));

                    break;

                case 3:
                    System.out.println("Your choice: "+ choice);

                    System.out.println("ANAGRAMS");

                    String s1;

                    String s2;

                    System.out.println("Enter string 1");

                    s1= sc.next();

                    System.out.println("Enter string 2");

                    s2= sc.next();

                    System.out.println(isAnagram(s1,s2));

                    break;

                case 4:
                    System.out.println("Your choice: "+ choice);

                    System.out.println("DETECT LOOP IN A LINKED LIST");

                    System.out.println("Enter number of nodes");

                    size = sc.nextInt();

                    LList lList= new LList();

                    for (int i=0;i<size;i++)
                        lList.addAtBegining(new LList.NodeMod(sc.nextInt()));

                    System.out.println(lList.IsLoopPresent(lList));

                    break;

                case 5:

                    System.out.println("Your choice: "+ choice);

                    System.out.println("INSERTION SORT");

                    System.out.println("Enter array size");

                    size = sc.nextInt();

                    System.out.println("Enter "+size+" elements");

                    arr= new int[size];

                    for(int i=0; i<size;i++)
                        arr[i] = sc.nextInt();


                    ArrayList<Integer> result = Insertionsort((ArrayList) Arrays.asList(arr)) ;

                    for (Integer i: result)
                        System.out.print(i+"   ");

                    System.out.println();

                    break;


                case 6:

                    System.out.println("Your choice: "+ choice);

                    System.out.println("KTH SMALLEST ELEMENT");


                    System.out.println("Enter array size");

                    size = sc.nextInt();

                    System.out.println("Enter "+size+" elements");

                    arr= new int[size];

                    for(int i=0; i<size;i++)
                        arr[i] = sc.nextInt();

                    System.out.println("Enter k ");


                    int k=sc.nextInt();

                    System.out.println(kthSmallest(arr,0,arr.length-1,k));

                    break;

                case 7:
                    System.out.println("Your choice: "+ choice);

                    System.out.println("SUM OF ODD LENGTH SUB ARRAYS");

                    System.out.println("Enter array size");

                    size = sc.nextInt();

                    System.out.println("Enter "+size+" elements");

                    arr= new int[size];

                    for(int i=0; i<size;i++)
                        arr[i] = sc.nextInt();

                    System.out.println(sumOddLengthSubarrays(arr));

                    break;


                case 8:
                    System.out.println("Your choice: "+ choice);

                    System.out.println("FIND MIDDLE INDEX IN ARRAY");

                    System.out.println("Enter array size");

                    size = sc.nextInt();

                    System.out.println("Enter "+size+" elements");

                    arr= new int[size];

                    for(int i=0; i<size;i++)
                        arr[i] = sc.nextInt();

                    System.out.println(findMiddleIndex(arr));

                    break;

                case 9:
                    System.out.println("Your choice: "+ choice);

                    System.out.println("FIND SUBARRAYS ");

                    System.out.println("Enter array size");

                    size = sc.nextInt();

                    System.out.println("Enter "+size+" elements");

                    arr= new int[size];

                    for(int i=0; i<size;i++)
                        arr[i] = sc.nextInt();

                    System.out.println(findSubarrays(arr));

                    break;


                default:
                    System.out.println("Invalid choice");
                    exit(0);
            }
        }



    }
}

