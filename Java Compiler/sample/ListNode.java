public class ListNode {

    public int value;
    public ListNode next;

    public ListNode(int value) {
        this(value, null);
    }

    public ListNode(int value, ListNode next) {
        this.value = value;
        this.next = next;
    }

    public void printList() {
        if (next != null) next.printList();
        System.out.println(value);
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2, first);
        ListNode third = new ListNode(3, second);
        ListNode fourth = new ListNode(4, third);
        fourth.printList();
    }

}