/* Merge Two Sorted Lists:
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */


/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Problem21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        while(l1 != null || l2 != null) {
        	if(l1 == null || (l2 != null && l2.val < l1.val)) {
        		cur.next = l2;
        		cur = cur.next;
        		l2 = l2.next;
        	} else {
        		cur.next = l1;
        		cur = cur.next;
        		l1 = l1.next;
        	}
        }
        
        return dummy.next;
    }
}