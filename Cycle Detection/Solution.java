import java.io.*;
import java.util.*;

class SinglyLinkedListNode {
    int data;
    SinglyLinkedListNode next;
}

public class Solution {

    static int has_cycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode tortoise = head;
        SinglyLinkedListNode hare = head;

        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;

            if (tortoise == hare) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int tests = scanner.nextInt();

        while (tests-- > 0) {
            int listSize = scanner.nextInt();
            SinglyLinkedListNode head = readSinglyLinkedList(scanner, listSize);

            int result = has_cycle(head);

            System.out.println(result);
        }

        scanner.close();
    }

    static SinglyLinkedListNode readSinglyLinkedList(Scanner scanner, int size) {
        if (size <= 0) {
            return null;
        }

        SinglyLinkedListNode head = new SinglyLinkedListNode();
        SinglyLinkedListNode current = head;

        for (int i = 0; i < size; i++) {
            current.data = scanner.nextInt();
            if (i < size - 1) {
                current.next = new SinglyLinkedListNode();
                current = current.next;
            }
        }

        return head;
    }
}
