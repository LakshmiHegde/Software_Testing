
import com.example.softwaretesting.LL.LList;
import com.example.softwaretesting.MainProg;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    MainProg main = new MainProg();

    @Test
    public void isAnagram_test_EC(){
        //Edge Coverage
        String s1 = "a";
        String s2 = "a";

        Assert.assertEquals(true,main.isAnagram(s1, s2)); // Test path [1 3 4 5 3 7]

        s1 = "";
        s2 = "w";

        Assert.assertEquals(false,main.isAnagram(s1, s2)); // Test path [1 2]

        s1="w";
        s2="a";

        Assert.assertEquals(false,main.isAnagram(s1, s2)); // Test path [1 3 4 6]
    }

    @Test
    public void isAnagram_test_PC(){

        //Prime Path Coverage

        String s1="it";
        String s2="if";

        Assert.assertEquals(false,main.isAnagram(s1, s2)); // Test path [1 3 4 5 3 4 6]

        s1="on";
        s2="no";

        Assert.assertEquals(true,main.isAnagram(s1, s2)); // Test path [1 3 4 5 3 4 5 3 7]

        s1="";
        s2="w";

        Assert.assertEquals(false,main.isAnagram(s1, s2)); // Test path [1 2]

        s1="";
        s2="";

        Assert.assertEquals(true,main.isAnagram(s1, s2)); // Test path [1 3 7]

        s1="word";
        s2="hell";

        Assert.assertEquals(false,main.isAnagram(s1, s2)); // Test path [1 3 4 6]
    }


    @Test
    public void binarysearch_test_EC(){
        //Edge Coverage
        int[] arr= new int[]{3,6,10,14};
        // Test path [1 2 5 1 2 3 1 6]
        Assert.assertEquals(-1,main.binarySearch(arr,0,arr.length-1,4));

        arr=new int[]{3,6,10};
        // Test path [1 2 4]
        Assert.assertEquals(1,main.binarySearch(arr,0,arr.length-1,6));

    }

    @Test
    public void binarysearch_test_PC(){

        //Prime path coverage
        int[] arr=new int[]{2,4,5,7,9,12};
        //Test Path [1 2 3 1 2 5 1 2 4]
        Assert.assertEquals(1,main.binarySearch(arr,0,arr.length-1,4));

        arr=new int[]{2,5,8,10,11,15,16,17};
        // Test Path [1 2 5 1 2 3 1 2 3 1 6]
        Assert.assertEquals(-1,main.binarySearch(arr,0,arr.length-1,9));

        arr=new int[]{5};
        // Test path [1 2 5 1 6]
        Assert.assertEquals(-1,main.binarySearch(arr,0,arr.length-1,4));

        arr=new int[]{2,5,7};
        //Test path [1 2 5 1 2 5 1 6]
        Assert.assertEquals(-1,main.binarySearch(arr,0,arr.length-1,1));

        //Test path [1 2 3 1 2 4]
        Assert.assertEquals(2,main.binarySearch(arr,0,arr.length-1,7));

    }



    @Test
    public void kthsmallestele_EC(){
        //Edge Coverage


        int[] arr= new int[]{8,9,6};
        // Test path [1,3,4,3,5,6,5,6,7,5,8]
        Assert.assertEquals(6,main.kthSmallest(arr,0,arr.length-1,1));


        // Test path [1 2 ]
        Assert.assertEquals(Integer.MIN_VALUE,main.kthSmallest(arr,0,arr.length-1,4));

        arr=new int[]{4};
        //Test path [1 3 4 3 5 8]
        Assert.assertEquals(4,main.kthSmallest(arr,0,arr.length-1,1));

    }

    @Test
    public void kthsmallestele_PC(){

        //Prime path coverage

        int arr[] =  {7,-1,0,4,12};
        //Test Path [1 2 ]
        Assert.assertEquals(Integer.MIN_VALUE,main.kthSmallest(arr,0,arr.length-1,0));

        arr =  new int[]{0,-1};
        //Test Path [1 3 4 3 4 3 5 8 ]
        Assert.assertEquals(0,main.kthSmallest(arr,0,arr.length-1,2));


        arr= new int[]{4,3,2,6,0,5};
        // Test path [1,3,4,3,5,6,7,5,6,7,5,6,5,6,7,5,6,5,8]
        Assert.assertEquals(0,main.kthSmallest(arr,0,arr.length-1,1));

        arr= new int[]{4};
        // Test path [1,3,4,3,5,8] , side trip 1 3 5 8
        Assert.assertEquals(4,main.kthSmallest(arr,0,arr.length-1,1));

    }

    @Test
    public void islooppresent_EC()
    {
        LList l= new LList();

        //Test path [1 2 4 1 2 3]
        l.head=new LList.NodeMod(1);
        l.head.next = l.head;
        Assert.assertEquals(true,l.IsLoopPresent(l));

        //Test path [1 5]
        l.head=null;
        Assert.assertEquals(false,l.IsLoopPresent(l));

    }

    @Test
    public void islooppresent_PC()
    {
        LList l= new LList();

        //Test path [1 2 4 1 2 4 1 5]
        l.head=new LList.NodeMod(1);
        l.addAtBegining(new LList.NodeMod(7));
        Assert.assertEquals(false,l.IsLoopPresent(l));

        //Test path [1 2 4 1 2 4 1 2 3]

        l.head=new LList.NodeMod(1);
        LList.NodeMod temp=new LList.NodeMod(5);
        l.head.next = temp;
        temp.next= l.head;

        Assert.assertEquals(true,l.IsLoopPresent(l));

    }
    @Test
    public void sumOddLengthSubarrays_test_EC(){
        //Edge Coverage
        int[] arr= new int[]{10,11};
        // Test path [1 2 3 4 5 7 8 3 9 10]
        Assert.assertEquals(21,main.sumOddLengthSubarrays(arr));

        arr=new int[]{6};
        // Test path [1 2 3 4 5 6 7 8 3 9 10]
        Assert.assertEquals(6,main.sumOddLengthSubarrays(arr));

    }
@Test
    public void sumOddLengthSubarrays_test_PC(){

        //Prime path coverage
        int[] arr=new int[]{4,3,1,2};
        //Test Path [1 2 3 4 5 6 7 8 3 4 5 6 7 8 3 4 5 7 8 3 4 5 7 8 3 9 10] 
        //Test path that it covers with side trip is
        //[1 2 3 4 5 6 7 8 3 4 5 7 8 3 4 5 6 7 8 3 4 5 7 8 3 9 10 6 7 8 3 4 5 7 8 3 4 5 6] 
        Assert.assertEquals(24,main.sumOddLengthSubarrays(arr));

        arr=new int[]{};
        // Test Path [1 2 3 9 10]
        Assert.assertEquals(0,main.sumOddLengthSubarrays(arr));

        arr=new int[]{6};
        // Test path [1 2 3 4 5 6 7 8 3 9 10]
        Assert.assertEquals(-6,main.sumOddLengthSubarrays(arr));

        arr=new int[]{10,11};
        //Test path [1 2 3 4 5 7 8 3 9 10]
        Assert.assertEquals(21,main.sumOddLengthSubarrays(arr));

    }

    @Test
    public void findMiddleIndex_test_EC(){
        //Edge Coverage
        int[] arr= new int[]{8,10};
        // Test path [1 2 4 6 9 10 4 7]
        //Test path that it covers with side trip is
        //[1 2 4 6 9 10 4 6 9 10 4 7]
        Assert.assertEquals(-1,main.findMiddleIndex(arr));

        arr=new int[]{10};
        // Test path [1 2 3 5 2 4 6 8]
        Assert.assertEquals(0,main.findMiddleIndex(arr));

    }
@Test
    public void findMiddleIndex_test_PC(){

        //Prime path coverage
        int[] arr=new int[]{4,6,4};
        //Test Path [1 2 3 5 2 3 5 2 4 6 9 10 4 6 8]
        Assert.assertEquals(1,main.findMiddleIndex(arr));

        arr=new int[]{8,10};
        // Test Path [1 2 4 6 9 10 4 6 9 10 4 7]
        Assert.assertEquals(-1,main.findMiddleIndex(arr));

        arr=new int[]{};
        // Test path [1 2 4 7]
        Assert.assertEquals(-1,main.findMiddleIndex(arr));

        arr=new int[]{10,2};
        //Test path [1 2 3 5 2 4 7]
        ////Test path that it covers with side trip is
        //[1 2 3 5 2 3 5 2 4 6 9 10 2 4 6 9 10 4 7]
        Assert.assertEquals(-1,main.findMiddleIndex(arr));

        arr=new int[]{10};
        //Test path [1 2 4 6 8]
        //Test path that it covers with side trip is
        //[1 2 3 5 2 4 6 8]
        Assert.assertEquals(0,main.findMiddleIndex(arr));

        arr=new int[]{10};
        //Test path [1 2 3 5 2 4 6 8]
        Assert.assertEquals(0,main.findMiddleIndex(arr));

    }

}
