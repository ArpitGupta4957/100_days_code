
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class day_12 {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;

        if(k == 0){
            return null;
        }

        return partitionAndMerge(0, k-1, lists);
    }

    private ListNode partitionAndMerge(int start, int end, ListNode[] lists){
        if(start == end){
            return lists[start];
        }

        if(start>end){
            return null;
        }
        int mid = start + (end - start)/2;
        ListNode L1 = partitionAndMerge(start, mid, lists);
        ListNode L2 = partitionAndMerge(mid +1, end, lists);

        return mergeTwoSortedList(L1 ,L2);
    }

    private ListNode mergeTwoSortedList(ListNode L1, ListNode L2){
        if(L1 == null) return L2;
        if(L2 == null) return L1;

        if(L1.val <= L2.val){
            L1.next = mergeTwoSortedList(L1.next, L2);
            return L1;
        }else {
            L2.next = mergeTwoSortedList(L1, L2.next);
            return L2;
        }
    }
    public static void main(String[] args) {

        day_12 obj = new day_12();

        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        System.out.println(obj.mergeKLists(lists));
        
    }
}