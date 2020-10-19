package com.mzy.leecode;

public class TwoPlus {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
//        l2.next.next = new ListNode(4);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }

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
            addTwoNumbers(l1.next, l2.next);
        }
        return l1;
    }


}
