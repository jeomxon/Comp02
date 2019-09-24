/***************************
 * 
 * ��ǻ�����α׷���2 (05) HW01 ~ HW02
 * �й� : 201902720
 * �̸� : �� �� ��
 * �ۼ��� : 2019.09.24
 * ����  : ArrayListŬ������ ����� ����
 *  
 ***************************/

package lab04.prtc2;

import lab04.prtc1.*;

public class ArrayList<E> implements List<E> {
	private static final int DEFAULT_CAPACITY = 10;
	private Object[] elementData;
	private int size = 0; // �ʵ� ����

	public ArrayList() {
		this.elementData = new Object[DEFAULT_CAPACITY];
	} // ������

	public ArrayList(int size) {
		this.elementData = new Object[size];
	} // �Ű������� ���� ������

	@Override
	public boolean add(int index, E element) throws IndexOutOfBoundsException {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		}

		if (size == elementData.length) {
			resize();
		} // ������ �˻� �� resize�޼ҵ� ȣ��
		
		for (int i = size - 1; i >= index; i--) {
			elementData[i + 1] = elementData[i];
		}
		size++;
		elementData[index] = element;
		return true;
	} // ����Ʈ�� ���� �ֱ� ���� �޼ҵ�

	@Override
	public boolean addFirst(E element) {
		return add(0, element);
	} // ����Ʈ�� ù��°�� ���� �ֱ� ���� �޼ҵ�

	@Override
	public boolean addLast(E element) {
		add(this.size(), element);
		return true;
	} // ����Ʈ�� �������� ���� �ֱ� ���� �޼ҵ�

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index > size - 1) {
			throw new IndexOutOfBoundsException();
		} // �ε����� ���� ����Ʈ�� ũ�⺸�� ũ�ٸ� ���ܹ߻�
		Object obj = this.elementData[index];

		for (int i = index + 1; i <= size - 1; i++) {
			this.elementData[i - 1] = this.elementData[i];
		}
		size--;
		elementData[size] = null;
		return (E) obj;
	} // ����Ʈ�� ���� ���ֱ� ���� �޼ҵ�

	@Override
	public E removeFirst() {
		return this.remove(0);
	} // ����Ʈ�� ù��° �ε����� �ִ� ���� �����ϴ� �޼ҵ�

	@Override
	public E removeLast() {
		return this.remove(size - 1);
	} // ����Ʈ�� ������ �ε����� �ִ� ���� �����ϴ� �޼ҵ�

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		} // �ε����� ���� �������� ������ ũ�� ���ܹ߻�
		return (E) this.elementData[index];
	} // �ε����� �ָ� ���� ��ȯ�ϴ� �޼ҵ�

	@Override
	public E set(int index, E element) throws IndexOutOfBoundsException {
		if (index > size) {
			throw new IndexOutOfBoundsException();
		} // �ε����� ������� ũ�� ���ܹ߻�
		Object previousElement = elementData[index];
		elementData[index] = element;
		return (E) previousElement;
	} // �ε����� ���� �������ִ� �޼ҵ�

	@Override
	public int indexOf(E element) {
		for (int i = 0; i < size; i++) {
			if (element.equals(elementData[i])) {
				return i;
			}
		}
		return -1;
	} // ���ڷ� ���޵� ���� ���� ù��° �ε����� ��ȯ�ϴ� �޼ҵ�

	@Override
	public int size() {
		return this.size;
	} // ũ�⸦ ��ȯ�ϴ� �޼ҵ�

	@Override
	public boolean isEmpty() {
		return this.size == 0;
	} // ���� ����ִٸ� true�� ��ȯ�ϴ� �޼ҵ�

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
	} // String���� ǥ���ϱ� ���� �޼ҵ�

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
	} // �ݺ��� �޼ҵ带 ������ ���� Ŭ����

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	private void resize() {
		int resize = elementData.length * 2;
		Object[] copyData = new Object[resize];
		System.arraycopy(elementData, 0, copyData, 0, size);

		elementData = copyData;
	} // resize�޼ҵ带 ���� ������ ũ�⺸�� �� ū �ε����� �������� �� 2�踸ŭ ũ�⸦ ���������ִ� �޼ҵ�
}
