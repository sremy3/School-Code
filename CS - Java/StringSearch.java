import java.util.ArrayList;
import java.util.List;


public class StringSearch implements StringSearchInterface {

	@Override
	public List<Integer> boyerMoore(String needle, String haystack) {
		List<Integer> bm = new ArrayList<Integer>();
		int[] lastTable = buildLastTable(needle);
		if (haystack.length() < needle.length()) {
			return bm;
		}
		for (int i = needle.length() - 1; i < haystack.length();) {
			int j = needle.length() - 1;
			if (haystack.charAt(i) == needle.charAt(j)) {
			    int skipNumber = matchesOrNot(needle, haystack, i, lastTable, bm);
			    i = i + skipNumber;
			} else {
			    i = i + lastTable[haystack.charAt(i)];
			}
		}
		return bm;
	}
	/**
	 * A helper method to check from the given index backwards in the string
	 * to see if the haystack matches the needle.
	 * @param needle- needle being looked for
	 * @param haystack- the haystack the needle might be in
	 * @param lastHaystackIndex- the index of the last letter
	 * where the search is going to start
	 * @param lastTable- to look up how far the index should
	 * skip if there is a mismatch
	 * @param bm- the list to add the found index
	 * @return integer to skip to
	 */
	private int matchesOrNot(String needle, String haystack, int lastHaystackIndex, int[] lastTable, List<Integer> bm) {
		String subString = haystack.subSequence(lastHaystackIndex - needle.length() + 1, lastHaystackIndex + 1).toString();
		int misMatch;
		for (int i = 0; i < subString.length(); i++) {
			if (subString.charAt(i) != needle.charAt(i)) {
				misMatch = lastTable[subString.charAt(i)];
				return misMatch;
			}
		}
		bm.add(lastHaystackIndex - needle.length() + 1);
		return 1;
	}
	@Override
 	public int[] buildLastTable(String needle) {
		int[] table = new int[Character.MAX_VALUE];
		for (int i = Character.MIN_VALUE; i < Character.MAX_VALUE; i++) {
			table[i] = needle.length() - 1;
		}
		for (int i = 0; i < needle.length(); i++) {
			char c = needle.charAt(i);
			int j = Math.max(needle.length() - needle.lastIndexOf(c) - 1, 1);
			table[c] = j;
		}
		return table;
	}
	@Override
	public int generateHash(String current) {
		int hash = 0;
		for (int j = 0; j < current.length(); j++) {
			char c = current.charAt(j);
			hash = hash + (c * (powerHelper(BASE, (current.length() - 1 - j))));
		}
		return hash;
	}
	/**
	 * Private helper method to take the power of the
	 * base to the given exponent.
	 * @param base- the base
	 * @param exp- the exponenet
	 * @return the base raised to the exponent
	 */
    private int powerHelper(int base, int exp) {
    	int result = 1;
        while (exp != 0) {
            if ((exp & 1) == 1) {
                result *= base;
            }
            exp >>= 1;
            base *= base;
        }
        return result;
    }
	@Override
	public int updateHash(int oldHash, int length, char oldChar, char newChar) {
		oldHash = oldHash - (oldChar * (powerHelper(BASE, (length - 1))));
		oldHash = newChar + (oldHash * BASE);
		return oldHash;
	}
	@Override
	public List<Integer> rabinKarp(String needle, String haystack) {
		List<Integer> rabinList = new ArrayList<Integer>();
		final int needleHash = generateHash(needle);
		if (haystack.length() < needle.length()) {
			return rabinList;
		}
		int subHash = 0;
		for (int i = 0; (i + (needle.length() - 1)) < haystack.length(); i++) {
			String subString = haystack.subSequence(i, (i + (needle.length()))).toString();
			if (i == 0) {
				subHash = generateHash(subString);
			} else {
				subHash = updateHash(subHash, needle.length(), haystack.charAt(i - 1), subString.charAt(subString.length() - 1));
			}
			if (subHash == needleHash) {
				rabinList.add(i);
			}
		}
		return rabinList;
	}
}
