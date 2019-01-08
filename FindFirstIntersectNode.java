package code_03;

public class FindFirstIntersectNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int data) {
            this.value = data;
        }
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        if(head1 == null || head2 == null){
            return null;
        }
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1 == null && loop2 == null){
            return noLoop(head1,head2);
        }else if(loop1 != null && loop2 != null){
            return bothLoop(head1,head1,loop1,loop2);
        }else{
            return null;
        }
    }

    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node slow = head.next;
        Node fast = head.next.next;
        while (slow != fast){
            if(fast.next ==null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static Node noLoop(Node head1, Node head2) {
        int index = 0;
        Node cur1 = head1;
        Node cur2 = head2;
        while (cur1.next != null){
            index ++;
            cur1 = cur1.next;
        }
        while (cur2.next != null){
            index --;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        cur1 = index > 0?head1:head2;
        cur2 = cur1 == head1?head2:head1;
        index = Math.abs(index);
        while (index != 0){
            cur1 = cur1.next;
            index --;
        }

        while (cur1 != cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2) {
        Node cur1 =head1;
        Node cur2 =head2;
        if(loop1 == loop2){
            int index = 0;
            while (cur1 != loop1){
                index ++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2){
                index --;
                cur2 = cur2.next;
            }
            cur1 = index > 0?head1:head2;
            cur2 = cur1 == head1?head2:head1;
            index = Math.abs(index);
            while (cur1 != null && index != 0){
                cur1 = cur1.next;
                index --;
            }

            while (cur1 != cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while (cur1 != loop1){
                if(cur1 == loop2){
                    return cur1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

        // 1->2->3->4->5->6->7->4...
        head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).value);

        // 0->9->8->6->4->5->6..
        head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).value);

    }


}
