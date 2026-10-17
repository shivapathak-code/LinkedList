package SinglyLinkedList;

public class Solution {

static class Node{
    int data;
    Node next;

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }
}
private Node head;
private Node tail;
private int size;
public Solution()
{
    this.head = null;
    this.tail = null;
    this.size = 0;
}
// insert at head;
    public void insertAtHead(int data)
    {
        Node newNode = new Node(data);
        // if linkedlist is empty;
        if(head == null && tail == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    public void insertAtTail(int data)
    {
        Node newNode = new Node(data);
        // if linkedlist is empty;
        if(head == null && tail == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    public void insertAtPosition(int position , int data)
    {
        // invalid position ;
        if(position < 1 || position > size+1)
        {
            System.out.println("that is invalid position so insertion not possible");
            return;
        }
        if(position == 1)
        {
            insertAtHead(data);
            return;
        }
        if(position == size+1)
        {
            insertAtTail(data);
            return;
        }
        // ab hame us position tak pauchna padega ;
        Node prevNode = head;
        for(int i = 1;i<=position-2;i++)
        {
            prevNode = prevNode.next;
        }
        //position in rigth place ;
        // than  insert a node in place where are you insert the node;
        Node newNode = new Node(data);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        // ab size ko increse ko ker dena

        size++;
    }
    public void printList()
    {
        Node temp = head;

        while(temp != null)
        {
            System.out.print(temp.data+"->");
            temp = temp.next;
        }
        System.out.println();
    }
    public int getSize()
    {
        return size;
    }
    public boolean isEmpty()
    {
        return head == null;
    }
    public int gethead()
    {
        if(head == null)
        {
            return -1;
        }
        else
        {
            return head.data;
        }
    }
    public int gettail()
    {
        if(tail == null)
        {
            return -1;
        }
        else
        {
            return tail.data;
        }
    }
    public boolean serach( int target) {
        Node temp = head;
        while (temp != null)
        {
            if(temp.data == target)
            {
                return true;
            }
            else
            {
                temp = temp.next;
            }
        }
        // yahan poori list traverse ho chuki hain iske baad muje
        // yahan false kerna padega kyoki complete list traverse ho chuki uske baad muje
        // ans nhi mila to isi ko false kerna padega ;
        return false;
    }
    public int findPosition(int data)
    {
        Node temp = head;
        int  pos = 1;

        while(temp != null)
        {
            if(temp.data == data){
                return pos;
            }
            else
            {
                temp = temp.next;
                pos++;
            }
        }
        return -1;
    }

    public void updateAtPosition(int pos  , int newData)
    {
        if(pos < 1 || pos > size+1)
        {
            System.out.println("Invalid position that have to insert the value");
            return;
        }
        Node temp = head;
        for(int i = 1;i<=pos - 1;i++)
        {
            temp = temp.next;
        }
        temp.data = newData;
    }
    public boolean updateValue(int oldValue , int newValue){
    Node temp = head;

    while(temp != null)
    {
        if(temp.data == oldValue)
        {
            temp.data = newValue;
            return true;
        }
        temp = temp.next;
    }
    return  false;
    }
    public void deleteHead()
    {
        if(head == null)
        {
            System.out.println("not delete any node of linkedlist");
            return;
        }
        head = head.next;
        if(head == null)
        {
            tail = null;
        }
        size--;
    }
    public void deleteTail()
    {
        if(head == null)
        {
            System.out.println("Invlaid so not delete the node");
            return;
        }
        // check for single node;

        if(head == tail)
        {
            head = null;
            tail = null;
            size = 0;
            return;
        }

        Node temp = head;
        for(int i = 1;i<=size-2;i++)
        {
            temp = temp.next;
        }
        temp.next = null;
        tail = temp;

        size--;
    }
    public void deleteAtPosition(int pos)
    {
        if(pos < 1 || pos > size+1)
        {
            System.out.println("Invalid position that have not delete");
            return;
        }
        if(pos == 1)
        {
            deleteHead();
            return;
        }
        if(pos == size)
        {
            deleteTail();
            return;
        }
        Node prevNode = head;
        for(int i = 1;i<=pos-2;i++)
        {
            prevNode = prevNode.next;
        }
        Node curr = prevNode.next;
        Node forward = curr.next;

        prevNode.next = forward;
        curr.next = null;

        size--;
    }
    public boolean deleteAtValue(int target)
    {
        if(head == null)
        {
            System.out.println("invalid not delete");
            return false;
        }
        if(head.data == target)
        {
            deleteHead();
            return true;
        }
        Node prev = head;
        Node curr = head.next;

        while(curr != null)
        {
            Node forward = curr.next;
            if(curr.data == target)
            {
                prev.next = forward;
                curr.next = null;
                if(tail == curr)
                {
                    tail = prev;
                    size--;
                }
                return true;

            }
            else
            {
                curr = curr.next;
            }
        }
        return false;
    }

    public static void main(String[] args)
    {
        Solution mylist = new Solution();
        if(mylist.isEmpty())
        {
            System.out.println("yes mylist is empty");
        }
        System.out.println("size of ll " + mylist.getSize());
        mylist.insertAtHead(10);
        mylist.printList();

        mylist.insertAtHead(20);
        mylist.printList();

        mylist.insertAtHead(30);
        mylist.printList();

        mylist.insertAtHead(40);
        mylist.printList();

        mylist.insertAtTail(100);
        mylist.printList();

        mylist.insertAtTail(110);
        mylist.printList();

        mylist.insertAtPosition(1 , 11);
        mylist.printList();

        mylist.insertAtPosition(8 , 1000);
        mylist.printList();

        mylist.insertAtPosition(4 , 90);
        mylist.printList();

        System.out.println(mylist.gethead());
        System.out.println(mylist.gettail());
        System.out.println(mylist.getSize());

       System.out.println(mylist.serach(20));

        System.out.println(mylist.findPosition(200));

        mylist.updateAtPosition(2 , 30000);
        mylist.printList();


        System.out.println(mylist.updateValue(20 , 30000));
        mylist.printList();

        mylist.deleteHead();
        mylist.printList();

        mylist.deleteHead();
        mylist.printList();

        mylist.deleteHead();
        mylist.printList();

        mylist.deleteTail();
        mylist.printList();

        mylist.deleteTail();
        mylist.printList();

        mylist.deleteAtPosition(4);
        mylist.printList();

        mylist.deleteAtPosition(2);
        mylist.printList();

        System.out.println(mylist.deleteAtValue(30000));
        mylist.printList();


    }

}
