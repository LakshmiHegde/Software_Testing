package com.example.softwaretesting.LL;


import java.util.HashSet;

public class LList {
    public NodeMod head;
    public static class NodeMod
    {
        int data;
        public NodeMod next;

        public NodeMod(int data) {
            this.data = data;
            next = null;
        }
    }
    public void addAtBegining(NodeMod newNode){
        newNode.next=head;//You're directly doing it with head, instead of taking current ref
        head=newNode;
    }
    void addAtEnd(NodeMod newNode) {
        NodeMod temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;

    }

    public static boolean IsLoopPresent(LList l1)
    {
        LList.NodeMod temp=l1.head;
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
