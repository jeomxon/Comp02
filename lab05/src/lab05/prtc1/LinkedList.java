/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.10.01
 * 목적  : LinkedList클래스 구현
 *
 ***************************/

package lab05.prtc1;

import lab04.prtc1.List;
import lab04.prtc2.Iterator;

public class LinkedList<T> implements List<T> {
	private Node<T> head; // 첫 번째 노드를 가리키는 필드
	private Node<T> tail; // 마지막 노드를 가리키는 필드
	private int size = 0; // 리스트의 원소의 개수
	
	public class ListIterator implements Iterator<T> {
		private Node lastReturned; // 리턴값을 저장할 변수
		private Node next; 
		private int nextIndex;
		
		public ListIterator() {
			next = head;
			nextIndex = 0;
		}
		
		public boolean hasNext() {
			return nextIndex < size(); // 마지막 노드까지 next가 되고나면 nextIndex와 size의 값이 같아지기 때문에 nextIndex의 값이 size값보다 작을 때 true를 리턴
		}
		
		public T next() {
			lastReturned = next; // next에 있던 노드를 lastReturned에 먼저 저장을 해줌
			next = next.next; // 그 다음 노드를 설정해줌
			nextIndex++; 
			return (T) lastReturned.data; //lastReturned에 있던 데이터를 리턴
		}
	}
	
	public ListIterator listIterator() {
		return new ListIterator();
	} // 반복자를 생성해서 리턴
	
	private class Node<E> {
		private E data; // 데이터가 저장될 필드
		private Node<E> next; // 다음 노드를 가리키는 필드
		
		public Node(E input) {
			this.data = input; // 데이터 저장
			this.next = null;
		}
		
		@Override
		public String toString() {
			// 노드의 데이터를 확인
			return String.valueOf(this.data);
		}
	}
	
	public String toString() {
		if (head == null) {
			return "[]";
		} // 리스트에 원소가 없으면 head가 null이다.
		Node<T> temp = head; //head의 노드를 temp로 참조
		StringBuilder str = new StringBuilder("[");
		while (temp.next != null) {
			str.append(temp.data + ", ");
			temp = temp.next;
		} // temp의 다음 연결이 null이 아니면 while문 실행
		
		str.append(temp.data); // 다음 노드가 null이지만 노드에 데이터는 남아있기 때문에 str에 append를 해준다.
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
		Node<T> newNode = new Node<>(element); // 새로운 노드 생성
		newNode.next = head; // 첫번째 자리에 위치하므로 첫번째 노드인 헤드로 newNode의 next로 연결해준다.
		head = newNode; // head를 newNode로 옮겨준다.
		size++;
		
		if(head.next == null) {
			tail = head;
		} // head.next == null인 경우, head와 tail은 같게 해줌.
		return true;
	}
	
	@Override
	public boolean addLast(T element) {
		if (isEmpty()) {
			addFirst(element);
		} // size가 0인 경우에는 addFirst메소드를 호출한다.
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
		} // head노드에서 index번 next를 호출하면 LinkedList의 index node를 알 수 있다.
		return x;
	} // LinkedList 내부에서만 사용하기 때문에 private로 선언한다.
	
	@Override
	public boolean add(int index, T element) {
		if (index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		} // index값이 잘못되면 예외발생
		if (index == 0) {
			addFirst(element);
		} // index값이 0이면 addFirst로 원소 삽입
		else {
			Node<T> temp1 = node(index - 1); // 인자로 온 index 바로 전의 노드를 temp1에 지정
			Node<T> temp2 = temp1.next; // 인자로 온 index 노드를 temp2에 지정
			Node<T> newNode = new Node<>(element); // 새로운 노드를 만듦
			temp1.next = newNode; // 해당 index 전 노드인 temp1의 다음을 newNode로 지정
			newNode.next = temp2; // newNode 다음을 temp2로 지정
			size++;
			if (newNode.next == null) {
				tail = newNode;
			} // 만약 이전에 temp1이 마지막 노드여서 index에 해당하는 노드가 null이면 temp2는 null이 되고, newNode.next는 null을 가리키게 된다. 이런 경우에는 newNode가 tail이 된다.
		}
		return true;
	}
	
	@Override
	public T removeFirst() {
		Node<T> temp = head; // 헤드 노드를 참조
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
		
		Node<T> temp = node(index - 1); // 삭제될 노드의 전 노드
		Node<T> nodeToDelete = temp.next; // 삭제될 노드
		temp.next = temp.next.next; // temp의 링크를 삭제될 노드의 다음으로 바꾼다.
		T returnData = nodeToDelete.data; // 리턴될 데이터를 저장
		if (nodeToDelete == tail) {
			tail = temp;
		} // 삭제할 노드가 tail이면 tail에 temp값을 저장
		nodeToDelete = null; // 명시적인 삭제
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
		int index = 0; // 인덱스를 카운트하기 위해서 index라는 이름의 변수를 선언
		while(temp.data != element) {
			temp = temp.next;
			index++;
			if (temp == null) {
				return -1;
			} // temp값이 null이면 -1을 리턴
		}
		return index; // 인덱스를 리턴
	}
	
	@Override
	public T set(int index, T element) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		} // 인덱스 값이 맞지 않으면 예외발생
		return node(index).data = element;
	} 

	@Override
	public Iterator<T> iterator() {
		return new ListIterator();
	}
	
}
