//Split Linked List in Parts
public class Day29 {
    public ListNode[] splitListToParts(ListNode head, int k) {

        ListNode cur = head;
        int N = 0;
        while (cur != null) {
            cur = cur.next;
            N++;
        }

        int width = N / k, remain = N % k;

        ListNode[] ans = new ListNode[k];
        cur = head;
        for (int i = 0; i < k; i++) {
            ans[i] = cur;
            for (int j = 0; j < width + (i < remain ? 1 : 0) - 1; j++) {
                if (cur != null) cur = cur.next;
            }
            if (cur != null) {
                ListNode hold = cur;
                cur = cur.next;
                hold.next = null;
            }
        }
        return ans;
    }

    //Given in question description
    class ListNode {
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
    }

}
