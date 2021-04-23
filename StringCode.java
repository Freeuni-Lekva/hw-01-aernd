import java.util.HashSet;
import java.util.Set;
import java.lang.Character;
import java.lang.String;
import static java.lang.Math.*;
// CS108 HW1 -- String static methods

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return max run length
	 */
	public static int maxRun(String str) {
		int curRun = 1;
		int maxRun = 0;
		for(int i=0;i<str.length()-1;i++){
			if(str.charAt(i) == str.charAt(i+1)){
				curRun++;
			}
			else{
				maxRun = max(maxRun,curRun);
				curRun = 1;
			}
		}
		return maxRun;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		StringBuilder ret = new StringBuilder();
		for(int i=0;i<str.length();i++){
			if(isDigit(str.charAt(i))){
				if(i != str.length()-1){
					String repeated = Character.toString( str.charAt(i+1) );
					repeated = repeated.repeat( Character.getNumericValue( str.charAt(i) ) );
					ret.append(repeated);
				}
			}
			else{
				ret.append( str.charAt(i) );
			}
		}
		return ret.toString();
	}

	private static boolean isDigit(char c){
		if('0' <= c && c <= '9'){
			return true;
		}
		return false;
	}

	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 * Compute this in linear time using a HashSet. Len will be 1 or more.
	 */
	public static boolean stringIntersect(String a, String b, int len) {
		HashSet<String> set = new HashSet<>();
		if(len>a.length() || len>b.length()) return false;
		for(int i=0;i<a.length()-len+1;i++){
			set.add(a.substring(i,i+len));
		}
		for(int i=0;i<b.length()-len+1;i++){
			if(set.contains(b.substring(i,i+len))){
				return true;
			}
		}
		return false;
	}
}
