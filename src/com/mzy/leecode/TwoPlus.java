package com.mzy.leecode;

public class TwoPlus {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        l1.next.next.next.next = new ListNode(9);
        l1.next.next.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(9);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

    /**
     * 这里需要考虑几种情况的，就是进位后导致后一位超过10
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 != null || l2 != null){
            int val = l1.val + l2.val;
            l1.val = val%10;
            if (val >= 10){
                if (l1.next == null){
                    l1.next = new ListNode(1);
                }else {
                    l1.next.val = l1.next.val+1;
                }
            }
            if (l2.next == null){
                if (l1.next != null && l1.next.val >= 10){
                    addTwoNumbers(l1.next, new ListNode(0));
                }
                return l1;
            }
            if (l1.next == null){
                l1.next = new ListNode(0);
            }
            addTwoNumbers(l1.next, l2.next);
        }
        return l1;
    }


}
