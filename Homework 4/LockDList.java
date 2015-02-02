package list;

public class LockDList extends DList{

	  protected DListNode newNode(Object item, DListNode prev, DListNode next) {
		    return new LockDListNode(item, prev, next);
		  }
	  
	  public void lockNode(DListNode node) {
		  ((LockDListNode)node).isLocked = true;
	  }
		
	  public void remove (DListNode node) {
		  if (((LockDListNode)node).isLocked == false) {
			 super.remove(node);  
		  }
	  }
	  
	  
	  public static void main (String[] args) {
			System.out.println("Testing Constructor");
			LockDList testList = new LockDList();
			System.out.println("Is empty? Should be true: " + testList.isEmpty());
			System.out.println("Should be zero length: " + testList.length());

			System.out.println("\nTesting insertFront");
			testList.insertFront(new Integer(1));
			System.out.println("Is empty? Should be false: " + testList.isEmpty());
			System.out.println("Should be one length: " + testList.length());
			System.out.println("Should be [ 1 ]: " + testList);
			testList.insertFront(new Integer(3));
			testList.insertFront(new Integer(6));
			testList.insertFront(new Integer(9));
			System.out.println(testList);

			LockDListNode currNode = (LockDListNode) ((DList) testList).front();
			currNode = (LockDListNode) testList.next(currNode);
			currNode = (LockDListNode) testList.next(currNode);
			//testList.lockNode(currNode);
			testList.remove(currNode);

			System.out.println(testList);


		        LockDList l = new LockDList();
				System.out.println("\n\n###Testing insertFront ###\nEmpty list is" + l);
				l.insertFront(new Integer(9));
				System.out.println("\nInserting 9 at front. \nList with 9 is " + l);
				l.insertFront(new Integer(8));
				l.insertFront(new Integer(7));
				System.out.println("\nInserting 7, 8 at the front. \nList with 7, 8, 9 is " + l);
				l.insertAfter(new Integer(6), l.head);
				System.out.println("\nInserting 6 after head. nList with 6, 7, 8, 9 is "+l);
				l.remove(l.head.next);
				System.out.println("Removed head.next, should return a list of 7, 8, 9. nList with 7, 8, 9 is " + l);
				LockDList m = new LockDList();
				m.insertFront(new Integer(9));
				m.insertFront(new Integer(8));
				m.insertFront(new Integer(7));
				System.out.println("\nInserting 7, 8, 9 at the front. List with 7, 8, 9 is " + m);
				m.lockNode(m.head.next);
				m.remove(m.head.next);
				System.out.println("Locked the first element of the DList, should not be removed. List with 7, 8, 9 is " + m);
	  }
}
