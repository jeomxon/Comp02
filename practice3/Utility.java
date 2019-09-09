package lab02.practice3;

import lab02.practice2.Pair;

public class Utility {
	public static <T> GenericBox<T> boxing(T t) {
		GenericBox<T> box = new GenericBox<T>();
		box.set(t);
		return box;
	}
	
	public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
		boolean keyCompare = p1.getKey().equals(p2.getKey());
		boolean valueCompare = p1.getValue().equals(p2.getValue());
		return keyCompare && valueCompare;
	}
	
	public static <T extends Comparable<T>> T getMax(T[] array) {
		if (array == null || array.length == 0)
			return null;
		T largest = array[0];
		for(int i = 0; i < array.length; i++) {
			if(largest.compareTo(array[i]) < 0) {
				largest = array[i];
			}
		}
		return largest;
	}
}
