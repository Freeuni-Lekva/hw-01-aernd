import java.util.*;

public class Appearances {
	
	/**
	 * Returns the number of elements that appear the same number
	 * of times in both collections. Static method. (see handout).
	 * @return number of same-appearance elements
	 */
	public static <T> int sameCount(Collection<T> a, Collection<T> b) {
		HashMap<T,Integer> mapA = new HashMap<>();
		HashMap<T,Integer> mapB = new HashMap<>();
		for(T t : a){
			if(mapA.containsKey(t)){
				mapA.put(t, mapA.get(t)+1);
			}
			else
				mapA.put(t, 1);
		}

		for(T t : b){
			if(mapB.containsKey(t)){
				mapB.put(t, mapB.get(t)+1);
			}
			else
				mapB.put(t, 1);
		}
		int ret = 0;
		for(T t : mapA.keySet()) {
			try {
				if (mapB.get(t).equals(mapA.get(t))) ret++;
			} catch(Exception e){}
		}
		return ret;
	}
	
}
