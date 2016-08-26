import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Assignment to teach dynamic programming using 3 simple example problems:
 * 1. Fibonacci numbers
 * 2. Longest common subsequence
 * 3. Edit distance
 * 
 * @author Naomi Robert
 */
public class DynamicProgramming {
	
	/**
	 * Calculates the nth fibonacci number: fib(n) = fib(n-1) + fib(n-2).
	 * Remember that fib(0) = 0 and fib(1) = 1.
	 * 
	 * This should NOT be done recursively - instead, use a 1 dimensional
	 * array so that intermediate fibonacci values are not re-calculated.
	 * 
	 * The running time of this function should be O(n).
	 * 
	 * @param n A number 
	 * @return The nth fibonacci number
	 */
	public static int fib(int n) {
		Map<Integer, Integer> fn = new HashMap<Integer, Integer>();
		fn.put(1, 1);
		fn.put(0, 0);
		for (int i = 2 ; i <= n; i++) {
			int calculatedValue = (fn.get(i - 2) + fn.get(i - 1));
			fn.put(i, calculatedValue);
		}
		return (fn.get(n));
	}
	
	/**
	 * Calculates the length of the longest common subsequence between a and b.
	 * 
	 * @param a
	 * @param b
	 * @return The length of the longest common subsequence between a and b
	 */
	public static int lcs(String a, String b) {
		int[][] lcsTable = new int[a.length() + 1][b.length() + 1];
		if (a == null || b == null) {
			return 0;
		}
		if (a.length() == 1 && b.length() == 1 && a.charAt(0) == (b.charAt(0))) {
			return 1;
		}
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					lcsTable[i + 1][j + 1] = (lcsTable[i][j]) + 1;
				} else {
					int above = lcsTable[i + 1][j];
					int below = lcsTable[i][j + 1];
					lcsTable[i + 1][j + 1] = below >= above ? below: above;
				}
			}
		}
		return (lcsTable[a.length()][b.length()]);
	}

	/**
	 * Calculates the edit distance between two strings.
	 * 
	 * @param a A string
	 * @param b A string
	 * @return The edit distance between a and b
	 */
	public static int edit(String a, String b) {
		int[][] lcsTable = new int[a.length() + 1][b.length() + 1];
		if (a == null || b == null) {
			return 0;
		}
		if (a.length() == 1 && b.length() == 1 && a.charAt(0) == (b.charAt(0))) {
			return 0;
		}
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				
			}
		}
		return (lcsTable[a.length()][b.length()]);
	}
	private static String insert(String z, char c, int i) {
		String secondHalf = z.substring(i);
		String firstHalf = z.substring(0, i);
		StringBuilder sb = new StringBuilder();
		sb.append(firstHalf);
		sb.append(c);
		sb.append(secondHalf);
		String finalString = sb.toString();
		return finalString;
	}
	private static String remove(String z, int i) {
		String secondHalf = z.substring(i+1);
		String firstHalf = z.substring(0, i);
		StringBuilder sb = new StringBuilder();
		sb.append(firstHalf);
		sb.append(secondHalf);
		String finalString = sb.toString();
		return finalString;
	}
	private static String change(String z, char c, int i) {
		String secondHalf = z.substring(i+1);
		String firstHalf = z.substring(0, i);
		StringBuilder sb = new StringBuilder();
		sb.append(firstHalf);
		sb.append(c);
		sb.append(secondHalf);
		String finalString = sb.toString();
		return finalString;
	}
}
