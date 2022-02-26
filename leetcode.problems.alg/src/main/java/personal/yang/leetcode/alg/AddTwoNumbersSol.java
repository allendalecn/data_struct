package personal.yang.leetcode.alg;

import java.util.List;

public class AddTwoNumbersSol {
    /**
     * simulate two numbers add
     * l1 : [1,2,9] l2 : [3,4,5] ret: [4,6,4,1]
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumList = new ListNode(0);

        plusSingleDigit(sumList, l1, l2);
        ListNode child1, child2, sumChild;
        child1 = l1.next;
        child2 = l2.next;
        //if (sumList.next == null) sumList.next = new ListNode(0);
        sumChild = sumList;
        while (child1 != null || child2 != null) {
            if (sumChild.next == null)
                sumChild.next = new ListNode(0);
            sumChild = sumChild.next;
            plusSingleDigit(sumChild, child1, child2);
            if (child1 != null)
                child1 = child1.next;
            if (child2 != null)
                child2 = child2.next;
            // sumChild = sumChild.next;
        }
        return sumList;
    }

    private void plusSingleDigit(ListNode sumList, ListNode l1, ListNode l2) {
        int sum = 0;
        if (l1 != null) {
            if (l2 != null) {
                sum = l1.val + l2.val;
            } else {
                sum = l1.val;
            }
        } else sum = (l2 != null ? l2.val : 0);

        if (sum < 10) {
            int newVal = sumList.val + sum;
            sum(sumList,newVal);
        } else {
            int newVal = sumList.val + sum - 10;
            sum(sumList,newVal);
            if (sumList.next == null) sumList.next = new ListNode(1);
            else {
                sumList.next.val += 1;
            }
        }
    }

    private void sum(ListNode sumList,int val){
        if (val < 10) {
            sumList.val = val;
            //sumList.next = new ListNode(0);
        } else {
            int newVal = val - 10;
            sum(sumList,newVal);
            if (sumList.next == null) sumList.next = new ListNode(1);
            else {
                sumList.next.val += 1;
            }
        }
    }

    public static void main(String[] args) {
        AddTwoNumbersSol sol = new AddTwoNumbersSol();
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9, new ListNode(9));
        System.out.println("l1:" + l1.toString());

        ListNode l2 = new ListNode(9);
        //l2.next = new ListNode(6, new ListNode(4));
        System.out.println("l2:" + l2.toString());

        ListNode sumList = sol.addTwoNumbers(l1, l2);
        System.out.println("sum:" + sumList.toString());
    }

}
