/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.10.01
 * ����  : LinkedListŬ���� ����
 *
 ***************************/

package lab05.prtc1;

import lab04.prtc1.List;
import lab04.prtc2.Iterator;

public class LinkedList<T> implements List<T> {
	private Node<T> head; // ù ��° ��带 ����Ű�� �ʵ�
	private Node<T> tail; // ������ ��带 ����Ű�� �ʵ�
	private int size = 0; // ����Ʈ�� ������ ����
	
	public class ListIterator implements Iterator<T> {
		private Node lastReturned; // ���ϰ��� ������ ����
		private Node next; 
		private int nextIndex;
		
		public ListIterator() {
			next = head;
			nextIndex = 0;
		}
		
		public boolean hasNext() {
			return nextIndex < size(); // ������ ������ next�� �ǰ��� nextIndex�� size�� ���� �������� ������ nextIndex�� ���� size������ ���� �� true�� ����
		}
		
		public T next() {
			lastReturned = next; // next�� �ִ� ��带 lastReturned�� ���� ������ ����
			next = next.next; // �� ���� ��带 ��������
			nextIndex++; 
			return (T) lastReturned.data; //lastReturned�� �ִ� �����͸� ����
		}
	}
	
	public ListIterator listIterator() {
		return new ListIterator();
	} // �ݺ��ڸ� �����ؼ� ����
	
	private class Node<E> {
		private E data; // �����Ͱ� ����� �ʵ�
		private Node<E> next; // ���� ��带 ����Ű�� �ʵ�
		
		public Node(E input) {
			this.data = input; // ������ ����
			this.next = null;
		}
		
		@Override
		public String toString() {
			// ����� �����͸� Ȯ��
			return String.valueOf(this.data);
		}
	}
	
	public String toString() {
		if (head == null) {
			return "[]";
		} // ����Ʈ�� ���Ұ� ������ head�� null�̴�.
		Node<T> temp = head; //head�� ��带 temp�� ����
		StringBuilder str = new StringBuilder("[");
		while (temp.next != null) {
			str.append(temp.data + ", ");
			temp = temp.next;
		} // temp�� ���� ������ null�� �ƴϸ� while�� ����
		
		str.append(temp.data); // ���� ��尡 null������ ��忡 �����ʹ� �����ֱ� ������ str�� append�� ���ش�.
		return new String(str + "]");
	} 
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public boolean addFirst(T element) {
		Node<T> newNode = new Node<>(element); // ���ο� ��� ����
		newNode.next = head; // ù��° �ڸ��� ��ġ�ϹǷ� ù��° ����� ���� newNode�� next�� �������ش�.
		head = newNode; // head�� newNode�� �Ű��ش�.
		size++;
		
		if(head.next == null) {
			tail = head;
		} // head.next == null�� ���, head�� tail�� ���� ����.
		return true;
	}
	
	@Override
	public boolean addLast(T element) {
		if (isEmpty()) {
			addFirst(element);
		} // size�� 0�� ��쿡�� addFirst�޼ҵ带 ȣ���Ѵ�.
		else {
			Node<T> newNode = new Node<>(element);
			tail.next = newNode;
			tail = newNode;
			size++;
		}
		return true;
	}
	
	private Node<T> node(int index) {
		Node<T> x = head;
		
		for(int i = 0; i < index; i++) {
			x= x.next;
		} // head��忡�� index�� next�� ȣ���ϸ� LinkedList�� index node�� �� �� �ִ�.
		return x;
	} // LinkedList ���ο����� ����ϱ� ������ private�� �����Ѵ�.
	
	@Override
	public boolean add(int index, T element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} // index���� �߸��Ǹ� ���ܹ߻�
		if (index == 0) {
			addFirst(element);
		} // index���� 0�̸� addFirst�� ���� ����
		else {
			Node<T> temp1 = node(index - 1); // ���ڷ� �� index �ٷ� ���� ��带 temp1�� ����
			Node<T> temp2 = temp1.next; // ���ڷ� �� index ��带 temp2�� ����
			Node<T> newNode = new Node<>(element); // ���ο� ��带 ����
			temp1.next = newNode; // �ش� index �� ����� temp1�� ������ newNode�� ����
			newNode.next = temp2; // newNode ������ temp2�� ����
			size++;
			if (newNode.next == null) {
				tail = newNode;
			} // ���� ������ temp1�� ������ ��忩�� index�� �ش��ϴ� ��尡 null�̸� temp2�� null�� �ǰ�, newNode.next�� null�� ����Ű�� �ȴ�. �̷� ��쿡�� newNode�� tail�� �ȴ�.
		}
		return true;
	}
	
	@Override
	public T removeFirst() {
		Node<T> temp = head; // ��� ��带 ����
		head = temp.next;
		T returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}
	
	@Override
	public T removeLast() {
		return remove(size - 1);
	}
	
	@Override
	public T remove(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (index == 0) {
			return removeFirst();
		}
		
		Node<T> temp = node(index - 1); // ������ ����� �� ���
		Node<T> nodeToDelete = temp.next; // ������ ���
		temp.next = temp.next.next; // temp�� ��ũ�� ������ ����� �������� �ٲ۴�.
		T returnData = nodeToDelete.data; // ���ϵ� �����͸� ����
		if (nodeToDelete == tail) {
			tail = temp;
		} // ������ ��尡 tail�̸� tail�� temp���� ����
		nodeToDelete = null; // ������� ����
		size--;
		return returnData;
	}
	
	@Override
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		return node(index).data;
	}

	public int indexOf(T element) {
		Node<T> temp = head;
		int index = 0; // �ε����� ī��Ʈ�ϱ� ���ؼ� index��� �̸��� ������ ����
		while(temp.data != element) {
			temp = temp.next;
			index++;
			if (temp == null) {
				return -1;
			} // temp���� null�̸� -1�� ����
		}
		return index; // �ε����� ����
	}
	
	@Override
	public T set(int index, T element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} // �ε��� ���� ���� ������ ���ܹ߻�
		return node(index).data = element;
	} 

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
}
