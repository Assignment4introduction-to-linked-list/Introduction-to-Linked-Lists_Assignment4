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
		}
		for (int i=0;i<index-1;i++) {
			position=position.next;
		}
		Nnew.next=position.next;
		position.next=Nnew;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public void remove(int index) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public ILinkedList sublist(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

}
