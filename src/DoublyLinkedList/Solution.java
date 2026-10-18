package DoublyLinkedList;

public class Solution {

    static class Node{
        int data;
        Node prev;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private Node head;
    private Node tail;
    private int size;

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
            head.prev = newNode;
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
            newNode.prev = tail;
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
        Node next = prevNode.next;
        Node newNode = new Node(data);
        // here is connection write down;
        newNode.prev = prevNode;
        prevNode.next = newNode;
        newNode.next = next;
        next.prev = newNode;

        // ab size ko increse ko ker dena

        size++;
    }

    public void printList()
    {
        Node temp = head;

        while(temp != null)
        {
            System.out.print(temp.data+"<->");
            temp = temp.next;
        }
        System.out.println();
    }

    public void printListBack()
    {
        Node temp = tail;

        while(temp != null)
        {
            System.out.print(temp.data+"<->");
            temp = temp.prev;
        }
        System.out.println();
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

    public void deleteHead()
    {
        if(head == null)
        {
            System.out.println("not delete any node of linkedlist");
            return;
        }
        if(head == tail)
        {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteTail()
    {
        if(head == null)
        {
            System.out.println("not delete any node of linkedlist");
            return;
        }
        if(head == tail)
        {
            head = null;
            tail = null;
            size = 0;
            return;
        }
        Node currNode = tail;
        Node prevNode = tail.prev;

        // ab linkes change kerte hain '
        prevNode.next = null;
        currNode.prev = null;

        size--;
    }

    public void deleteAtPosition(int pos)
    {
        if(head == null)
        {
            System.out.println("not deleted ");
            return;
        }
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
        Node currNode = head;
        for(int i = 1;i<=pos-1;i++)
        {
            currNode = currNode.next;
        }
        Node prevNode = currNode.prev;
        Node forward = currNode.next;

       // ab linked yahaan lagan hain
        prevNode.next = forward;
        forward.prev = prevNode;

        currNode.prev = null;
        currNode.next = null;

        size--;
    }
    public Solution()
    {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    public static void main(String[] args) {
        Solution mylist = new Solution();
//        if (mylist.isEmpty()) {
//            System.out.println("yes mylist is empty");
//        }
//        System.out.println("size of ll " + mylist.getSize());

        mylist.insertAtHead(10);
        mylist.printList();

        mylist.insertAtHead(20);
        mylist.printList();

        mylist.insertAtHead(30);
        mylist.printList();

        mylist.insertAtTail(40);
        mylist.printList();

        mylist.insertAtTail(50);
        mylist.printList();

        mylist.insertAtPosition(3 ,5);
        mylist.printList();

        mylist.insertAtPosition(7 , 60);
        mylist.printList();

        mylist.printListBack();

        System.out.println(mylist.serach(20));

        System.out.println(mylist.updateValue(20 , 30000));
        mylist.printList();

        mylist.deleteHead();
        mylist.printList();

        mylist.deleteTail();
        mylist.printList();

        mylist.deleteAtPosition(2);
        mylist.printList();

        mylist.deleteAtPosition(3);
        mylist.printList();

    }
}
