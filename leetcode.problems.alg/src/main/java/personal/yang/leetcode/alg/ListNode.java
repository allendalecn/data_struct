package personal.yang.leetcode.alg;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.val);
        ListNode child = this.next;
        while (child != null) {
            sb.append(",");
            sb.append(child.val);
            child = child.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
