class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}


public class LinkedList {

    private Node head = null;
    private static int frequency = 0;

    public Node getHead() {
        return head;
    }

    public LinkedList() {

    }

    private Node createNode(int data) {
        Node newNode = new Node(data);
        return newNode;
    }

    private void addNode(int data) {
        Node newNode = createNode(data);
        Node curr = head;
        if(head == null) {
            head = newNode;
            return;
        }
        while(curr.next != null) {
            curr = curr.next;
        }
        //curr = curr.next;
        curr.next = newNode;
    }

    public void deleteUsingKey(int data) {
        Node curr = head;
        Node prev = null;
        if(head.data == data) {
            head = curr.next;
            return;
        }
        while(curr != null && curr.data != data) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
    }

    public void deleteUsingPosition(int pos) {
        Node temp = head;
        Node prev = null;
        if(pos == 0 && temp != null) {
            head = temp.next;
            return;
        }
        while(temp != null && (pos--) > 0) {
            prev = temp;
            temp = temp.next;
        }

        if(temp == null || temp.next == null){
            System.out.println("Given position exceeded the size of list");
            return;
        }
    }
    //Iterative Approach length calculation
    public int lengthOfList() {
        Node temp = head;
        int count = 0;
        while(temp != null) {
            ++count;
            temp = temp.next;
        }
        return count;
    }


    public void searchUsingIterative(int data) {
        Node temp = head;
        while(temp != null && temp.data != data) {
            temp = temp.next;
        }

        if(temp == null) {
            System.out.println("Element "+data+" was not found in list");
            return;
        }

        System.out.println("Element "+ data + " is found");
    }

    public boolean searchUsingRecursive(Node temp, int data) {

        if(temp == null) {
            return false;
        }

        if(temp.data == data) {
            return true;
        }

        return searchUsingRecursive(temp.next, data);
    }

    public int countOccurences(int value) {
        Node temp = head;
        int count = 0;
        while(temp != null) {
            if(temp.data == value) {
                ++count;
            }
            temp = temp.next;
        }

        if(temp == null && count == 0) {
            System.out.println("No occurences found");
            return 0;
        }

        return count;
    }

    public void middleOfList() {
        Node slowPtr = head;
        Node fastPtr = head;
        while(fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
        }
        System.out.println("Middle of list -- "+slowPtr.data);
    }

    public int lengthOfListRecursive(Node temp) {
        if(temp == null)
            return 0;
        return 1+lengthOfListRecursive(temp.next);

    }

    public void addNodeToList(int data) {
        addNode(data);
    }

    public void printList() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data+"\t");
            curr = curr.next;
        }
        System.out.println("\n");
    }

    public void removeNodesGreaterThanValue(int value) {
        Node curr = head;
        Node prev = null;
        if( curr.next == null && curr.data > value) {
            head = curr.next;
            return;
        }
        while(curr != null) {
            if(curr.data > value) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
    }

    public static int countOccurencesUsingRecursion(Node head, int value) {
        if(head == null)
            return frequency;
        if(head.data == value)
            ++frequency;
        return countOccurencesUsingRecursion(head.next, value);
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        /*list.addNodeToList(1);
        list.addNodeToList(2);
        list.addNodeToList(3);
        list.addNodeToList(4);
        list.addNodeToList(5);*/
        //list.addNodeToList(6);
        //list.printList();
        //list.deleteUsingKey(3);
        //list.deleteUsingPosition(6);
       // list.printList();
        //System.out.println("Length of list -- "+list.lengthOfList());
        Node head = list.getHead();
        //System.out.println("Length of list using recursion -- "+list.lengthOfListRecursive(head));
        //list.searchUsingIterative(0);
        for(int i=1;i<=5;i++) {
            list.addNodeToList(i);
        }
        list.addNodeToList(2);
        list.addNodeToList(3);
        list.addNodeToList(10);
        list.printList();
        //list.middleOfList();
        //list.removeNodesGreaterThanValue(3);
        //list.printList();
        System.out.println("Occurence of number 2 is -- "+ LinkedList.countOccurencesUsingRecursion(head, 2));
    }
}
