import java.util.LinkedList;
import java.util.Collections;

public class List {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node mergeLists(Node headA, Node headB) {
        Node currentA = headA;
        Node currentB = headB;
        LinkedList<Integer> result = new LinkedList<>();

        while (currentA != null || currentB != null) {
            if (currentA != null) {
                result.add(currentA.data);
                currentA = currentA.next;
            }
            if (currentB != null) {
                result.add(currentB.data);
                currentB = currentB.next;
            }
        }

        Collections.sort(result);

        Node head = new Node(result.get(0));
        Node current = head;
        for (int i = 1; i < result.size(); i++) {
            current.next = new Node(result.get(i));
            current = current.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node headA = new Node(25);
        headA.next = new Node(35);
        headA.next.next = new Node(12);
        headA.next.next.next = new Node(4);
        headA.next.next.next.next = new Node(36);
        headA.next.next.next.next.next = new Node(48);
        Node headB = new Node(8);
        headB.next = new Node(32);
        headB.next.next = new Node(22);
        headB.next.next.next = new Node(45);
        headB.next.next.next.next = new Node(63);
        headB.next.next.next.next.next = new Node(49);
        Node result = mergeLists(headA, headB);
        while (result != null) {
            System.out.print(result.data + "->");
            result = result.next;
        }
    }
}
