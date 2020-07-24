//You are given two non-empty linked lists representing two non-negative integer
//s. The digits are stored in reverse order and each of their nodes contain a sing
//le digit. Add the two numbers and return it as a linked list. 
//
// You may assume the two numbers do not contain any leading zero, except the nu
//mber 0 itself. 
//
// Example: 
//
// 
//Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
//Output: 7 -> 0 -> 8
//Explanation: 342 + 465 = 807.
// 
// Related Topics 链表 数学


package leetcode.editor.cn;

/**
 * AddTwoNumbers
 */    
public class AddTwoNumbers{
    public static void main(String[] args) {
        Solution solution = new AddTwoNumbers().new Solution();

      }
      
/**
 * 
 */
 //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null){
            return null;
        }
        ListNode listNodeHead = new ListNode(0);
        ListNode listNode = new ListNode(0);
        ListNode listNodePre = new ListNode(0);
        listNodeHead.next = listNode;

        while (l1 != null || l2 != null){
            int sumTemp=0;
            if(l1==null){
                sumTemp = listNode.val+l2.val;
                l2=l2.next;
            }else if(l2==null){
                sumTemp = listNode.val+l1.val;
                l1=l1.next;
            }else {
                sumTemp = l1.val + l2.val + listNode.val;
                l1=l1.next;
                l2=l2.next;
            }
            listNode.val = sumTemp % 10;
            listNode.next = new ListNode(sumTemp / 10);
            listNodePre = listNode;
            listNode = listNode.next;
        }

        if(listNode.val == 0 ) {
            listNodePre.next=null;
        }
        return listNodeHead.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

        if(l1 == null || l2 == null){
            return null;
        }
        ListNode listNodeHead = new ListNode(0);
        ListNode listNode = new ListNode(0);
        listNodeHead.next = listNode;

        while (l1 != null && l2 != null){
            int sumTemp = l1.val+l2.val+listNode.val;

            listNode.val = sumTemp % 10;
            listNode.next = new ListNode(sumTemp / 10);
            l1=l1.next;
            l2=l2.next;
            listNode = listNode.next;
        }
        while(l1==null&&l2!=null){
            int sumTemp = listNode.val+l2.val;
            listNode.val = sumTemp % 10;
            listNode.next = new ListNode(sumTemp / 10);
            listNode = listNode.next;
            l2=l2.next;
        }
        while (l1!=null&&l2==null){

            int sumTemp = listNode.val+l1.val;
            listNode.val = sumTemp % 10;
            listNode.next = new ListNode(sumTemp / 10);
            listNode = listNode.next;
            l1=l1.next;
        }

        if(listNode.val == 0 ) {
            ListNode temp = listNodeHead;
            while (temp.next != listNode) {
                temp = temp.next;
            }
            temp.next = null;
        }
        return listNodeHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
  
}