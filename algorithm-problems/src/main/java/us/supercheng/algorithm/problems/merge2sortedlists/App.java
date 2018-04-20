package us.supercheng.algorithm.problems.merge2sortedlists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[]  args) {
        App app = new App();
        System.out.println(app.mergeTwoLists(null, null));
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        List<Integer> ints = new ArrayList<Integer>();
        while(l1 != null || l2 != null) {
            if(l1!=null) {
                ints.add(l1.val);
                l1 = l1.next;
            }
            if(l2!=null) {
                ints.add(l2.val);
                l2 = l2.next;
            }
        }
        Collections.sort(ints);
        ListNode returnNode = createLinkedList(ints);
        return returnNode;
    }

    private ListNode createLinkedList(List<Integer> ints) {
        if(ints.isEmpty()) {
            return null;
        }
        ListNode node = new ListNode(ints.get(0));
        node.next = createLinkedList(ints.subList(1, ints.size()));
        return node;
    }
}