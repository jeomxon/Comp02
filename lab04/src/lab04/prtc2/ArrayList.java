/***************************
 * 
 * 컴퓨터프로그래밍2 (05) HW01 ~ HW02
 * 학번 : 201902720
 * 이름 : 유 정 훈
 * 작성일 : 2019.09.24
 * 목적  : ArrayList클래스를 만들기 위함
 *  
 ***************************/

package lab04.prtc2;

import lab04.prtc1.*;

public class ArrayList<E> implements List<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elementData;
	private int size = 0; // 필드 선언

	public ArrayList() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	} // 생성자

	public ArrayList(int size) {
		this.elementData = new Object[size];
	} // 매개변수를 갖는 생성자

	@Override
	public boolean add(int index, E element) throws IndexOutOfBoundsException {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}

		if (size == elementData.length) {
			resize();
		} // 사이즈 검사 후 resize메소드 호출
		
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
		size++;
		elementData[index] = element;
		return true;
	} // 리스트에 값을 넣기 위한 메소드

	@Override
	public boolean addFirst(E element) {
		return add(0, element);
	} // 리스트에 첫번째에 값을 넣기 위한 메소드

	@Override
	public boolean addLast(E element) {
		add(this.size(), element);
		return true;
	} // 리스트에 마지막에 값을 넣기 위한 메소드

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index > size - 1) {
			throw new IndexOutOfBoundsException();
		} // 인덱스의 값이 리스트의 크기보다 크다면 예외발생
		Object obj = this.elementData[index];

		for (int i = index + 1; i <= size - 1; i++) {
			this.elementData[i - 1] = this.elementData[i];
		}
		size--;
		elementData[size] = null;
		return (E) obj;
	} // 리스트의 값을 없애기 위한 메소드

	@Override
	public E removeFirst() {
		return this.remove(0);
	} // 리스트의 첫번째 인덱스에 있는 값을 제거하는 메소드

	@Override
	public E removeLast() {
		return this.remove(size - 1);
	} // 리스트의 마지막 인덱스에 있는 값을 제거하는 메소드

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		} // 인덱스의 값이 사이즈의 값보다 크면 예외발생
		return (E) this.elementData[index];
	} // 인덱스를 주면 값을 반환하는 메소드

	@Override
	public E set(int index, E element) throws IndexOutOfBoundsException {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		} // 인덱스가 사이즈보다 크면 예외발생
		Object previousElement = elementData[index];
		elementData[index] = element;
		return (E) previousElement;
	} // 인덱스의 값을 설정해주는 메소드

	@Override
	public int indexOf(E element) {
		for (int i = 0; i < size; i++) {
			if (element.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	} // 인자로 전달된 값의 가장 첫번째 인덱스를 반환하는 메소드

	@Override
	public int size() {
		return this.size;
	} // 크기를 반환하는 메소드

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	} // 값이 비어있다면 true를 반환하는 메소드

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder("[");
		for (int i = 0; i < size; i++) {
			str.append(elementData[i]);
			if (i < size - 1) {
				str.append(", ");
			}
		}
		str.append("]");
		return new String(str);
	} // String으로 표출하기 위한 메소드

	public class ListIterator implements Iterator<E> {
		private int nextIndex;

		private ListIterator() {
			this.nextIndex = 0;
		}

		public boolean hasNext() {
			return nextIndex < size();
		}

		public E next() {
			return (E) elementData[nextIndex++];
		}
	} // 반복자 메소드를 포함한 내부 클래스

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private void resize() {
		int resize = elementData.length * 2;
		Object[] copyData = new Object[resize];
		System.arraycopy(elementData, 0, copyData, 0, size);

		elementData = copyData;
	} // resize메소드를 통해 원래의 크기보다 더 큰 인덱스에 접근했을 때 2배만큼 크기를 증가시켜주는 메소드
}
