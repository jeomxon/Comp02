package lab02.practice1;

public class GenericBox<T> {
	private T data;
	public T get() {
		return data;
	}
	public void set(T data) {
		this.data = data;
	}
	public String toString() {
		return data.toString();
	}
}
