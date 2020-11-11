// 解法2：迭代
/* 思路：定义一个哨兵节点prehead用于返回最后合并的链表。维护一个pre指针，调整它的next指针。重复循环以下过程：当l1.val < l2.val时，将l1该节点接在Pre后边。同时令l1指向1l->next。l2是同样的操作处理。最后无论是谁小于谁，都要将pre向后移动至pre->next。当循环处理结束后，最多只有一个链表是空的，只需要将pre->next指向那个非空的链表即可。最后返回prehead->next即可得到整合的链表。*/
//时间复杂度：O(N+M);空间复杂度：O(1)
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    ListNode PreHead = new ListNode(-1);  // 新链表的头节点
    ListNode pre = PreHead;
    while(l1!=null && l2 != null)
        if (l1.val < l2.val){
            pre.next = l1;
            l1 = l1.next;
        }
        else{
            pre.next = l2;
            l2 = l2.next;
        }
        pre = pre.next;
    }
    pre.next = l1 == null ? l2:l1;
    return PreHead.next;  
 } 
}
