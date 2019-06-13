/* Remove Duplicates from Sorted List II:
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Problem82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy; // slow - track the node before the first duplicated nodes.
        ListNode fast = head; // fast - to find the last duplicated nodes.
         
        while(fast != null) {
        	while(fast.next != null && fast.val == fast.next.val) {
        		fast = fast.next;
        	}  // while loop to find the last duplicated nodes.
        	
        	if(slow.next != fast) { // duplicates detected.
        		slow.next = fast.next; // remove the duplicates.
        		fast = slow.next; // reset the fast pointer.
        	} else { // if no duplicate detected, move down both pointers.
        		slow = slow.next;
        		fast = fast.next;
        	}
        }
        
        return dummy.next;
    }
}