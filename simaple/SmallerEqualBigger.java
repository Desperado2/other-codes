package code_03.simaple;

public class SmallerEqualBigger {

    public static class Node{
        private Node next;
        private int value;

        public Node(int value){
            this.value = value;
        }
    }

    public static Node listPartition1(Node head, int piovt){
        if (head== null || head.next == null){
            return head;
        }
        Node cur = head;
        int i= 0;
        while (cur != null){
            i++;
            cur = cur.next;
        }
        Node[] array = new Node[i];
        cur = head;
        i =0;
        for ( i=0;i!=array.length; i++){
            array[i] = cur;
            cur = cur.next;
        }
        nodePartition(array,piovt);
        for (i=1; i != array.length; i++){
            array[i-1].next = array[i];
        }
        array[i-1].next =null;
        return array[0];
    }

    public static void nodePartition(Node[] array, int pivot){
        int small = -1;
        int big = array.length;
        int index = 0;
        while (index != big){
            if(array[index].value < pivot){
                swap(array,++small,index++);
            }else if(array[index].value > pivot){
                swap(array,--big,index);
            }else{
                index++;
            }
        }
    }

    public static void swap(Node[] array, int i,int j){
        Node temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static Node listPartition2(Node head, int piovt){
        if (head== null || head.next == null){
            return head;
        }
        Node sHead = null;
        Node sTail = null;
        Node eHead = null;
        Node eTail = null;
        Node bHead = null;
        Node bTail = null;
        Node next = null;
        while (head != null){
            next = head.next;
            head.next = null;
            if(head.value < piovt){
                if(sHead == null){
                    sHead = head;
                    sTail = head;
                }else{
                    sTail.next = head;
                    sTail = head;
                }
            }else if(head.value == piovt){
                if(eHead == null){
                    eHead = head;
                    eTail = head;
                }else{
                    eTail.next = head;
                    eTail = head;
                }
            }else{
                if(bHead == null){
                    bHead = head;
                    bTail = head;
                }else{
                    bTail.next = head;
                    bTail = head;
                }
            }
            head = next;
        }

        if(sTail != null){
            sTail.next = eHead;
            eTail = eTail== null?sTail:eTail;
        }
        if(eTail != null){
            eTail.next = bHead;
        }
        return sHead != null?sHead:eHead != null?eHead:bHead;
    }

    public static void printLinkedList(Node node) {
        System.out.print("Linked List: ");
        while (node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = new Node(7);
        head1.next = new Node(9);
        head1.next.next = new Node(1);
        head1.next.next.next = new Node(8);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(2);
        head1.next.next.next.next.next.next = new Node(5);
        printLinkedList(head1);
        head1 = listPartition1(head1, 4);
        //head1 = listPartition2(head1, 5);
        printLinkedList(head1);

    }

}
