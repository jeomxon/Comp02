package lab11.prtc04;

import java.util.ArrayList;
import java.util.List;
import lab11.prtc04.Predicate;

public class FilterUtils {
	public <T> List<T> filter(List<T> list, Predicate<T> predicate) {
		List<T> filteredResult = new ArrayList<>();
		for (T type : list) {
			if (predicate.test(type)) {
				filteredResult.add(type);
			}
		}
		return filteredResult;
	}
}
