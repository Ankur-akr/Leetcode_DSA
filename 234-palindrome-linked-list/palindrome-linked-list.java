/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> al = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            al.add(curr.val);
            curr = curr.next;
        }
        int l =0;
        int r = al.size()-1;
        while(l<r){
            if(al.get(l) != al.get(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}