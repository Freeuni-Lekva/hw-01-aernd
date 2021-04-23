
/*
 HW1 Taboo problem class.
 Taboo encapsulates some rules about what objects
 may not follow other objects.
 (See handout).
*/

import java.util.*;

public class Taboo<T> {
	HashMap<T, Set<T>> rules = new HashMap<T,Set<T>>();
	/**
	 * Constructs a new Taboo using the given rules (see handout.)
	 * @param rules rules for new Taboo
	 */
	public Taboo(List<T> rules) {
		for(int i=0;i<rules.size()-1;i++){
			if(rules.get(i+1)!=null && rules.get(i)!=null) {
				if (this.rules.containsKey(rules.get(i))) {
					Set<T> s = this.rules.get(rules.get(i));
					s.add(rules.get(i + 1));
					this.rules.put(rules.get(i), s);
				} else {
					Set<T> s = new HashSet<>();
					s.add(rules.get(i + 1));
					this.rules.put(rules.get(i), s);
				}
			}
		}
	}
	
	/**
	 * Returns the set of elements which should not follow
	 * the given element.
	 * @param elem
	 * @return elements which should not follow the given element
	 */
	public Set<T> noFollow(T elem) {
		if(rules.containsKey(elem))
			return this.rules.get(elem);
		return Collections.emptySet();
	}
	
	/**
	 * Removes elements from the given list that
	 * violate the rules (see handout).
	 * @param list collection to reduce
	 */
	public void reduce(List<T> list) {
		for(int i=0;i< list.size()-1;i++){
			if(this.noFollow(list.get(i)).contains(list.get(i+1))){
				list.remove(i+1);
				i--;
			}
		}
	}
}
