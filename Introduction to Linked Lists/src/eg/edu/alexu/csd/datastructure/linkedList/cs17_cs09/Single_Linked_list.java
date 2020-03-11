package eg.edu.alexu.csd.datastructure.linkedList.cs17_cs09;

public class Single_Linked_list implements ILinkedList {
	
	
	class Node {
		Object element;
		Node next;
	};
	Node head,tail;
	int size;
	Single_Linked_list(){
		head=tail=null;
		size = 0;
	};

	@Override
	public void add(int index, Object element) {
		Node Nnew =new Node();
		Nnew.element=element;
		Node position;
		position = head;
		if (index==size-1) {
			add(element);
		}else {
			for (int i=0;i<index-1;i++) {
				position=position.next;
			}
			Nnew.next=position.next;
			position.next=Nnew;
		}
		size++;
	}

	@Override
	public void add(Object element) {
		Node Nnew = new Node();
		Nnew.element=element;
		if (isEmpty()) {
			head=tail=Nnew;
			Nnew.next=null;
		}else {
			
			tail.next=Nnew;
			tail=Nnew;
			Nnew.next=null;
		}
		size++;
	}

	@Override
	public Object get(int index) {
		Node Temp;
		Temp=head;
		for (int i=0;i<index;i++) {
			Temp=Temp.next;
		}
		return Temp.element;
	}

	@Override
	public void set(int index, Object element) {
		Node Temp;
		Temp=head;
		for (int i=0;i<index;i++) {
			Temp=Temp.next;
		}
		Temp.element=element;
	}

	@Override
	public void clear() {
		head=tail=null;
		size=0;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void remove(int index) {
		if (isEmpty()) {
			throw new RuntimeException("the list is empty can't remove from it");
		}else {
			if (index==0) {
				head=head.next;
			}else if (index==size-1) {
				Node N1=head;
				while(true) {
					if (N1.next==tail)break;
				}
				tail=N1;
				tail.next=null;
			}else {
				Node N1=head,N2=head.next;
				for (int i=0;i<index-1;i++) {
					N1=N1.next;
					N2=N2.next;
				}
				N2=N2.next;
				N1.next=N2;
			}
			size--;
		}
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		if (isEmpty()) {
			throw new RuntimeException("the list is empty");
		}else {
			if (toIndex>size-1) {
				throw new RuntimeException("the border of the list you need is bigger than the base list");
			}else {
				Single_Linked_list sublist = new Single_Linked_list();
				sublist.size=toIndex-fromIndex+1;
				Node temp=head;
				for (int i=0;i<size;i++) {
					if (i==fromIndex) {
						sublist.head=temp;
					}else if(i==fromIndex) {
						sublist.tail=temp;
					}
					temp=temp.next;
				}
				return sublist;
			}
		}
	}

	@Override
	public boolean contains(Object o) {
		if (isEmpty()) {
			return false;
		}else {
			boolean test=false;
			Node temp = head;
			for (int i=0;i<size;i++) {
				if (temp.element==o) {
					test=true;
					break;
				}
				temp=temp.next;
			}
			return test;
		}
	}
	
	public void print() { //this function for testing the code
		Node temp=head;
		for (int i=0;i<size;i++) {
			System.out.println(temp.element);
			temp=temp.next;
		}
	}

}
