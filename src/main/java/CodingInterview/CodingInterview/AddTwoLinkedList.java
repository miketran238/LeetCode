package CodingInterview.CodingInterview;

public class AddTwoLinkedList {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
		ListNode l4 = null;
		String s1 = Integer.toString(l1.val);
		while(l1.next != null)
		{
			s1+= Integer.toString(l1.val);
			l1 = l1.next;
		}
		
		String s2 = Integer.toString(l2.val);
		while(l2.next != null)
		{
			s2+= Integer.toString(l2.val);
			l2 = l2.next;
		}
		s1.length();
		return l4;
	}




	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	public static void main(String[] args) {

	}
}