package coderust.array;

public class LongestSubStringWithKUniqChar {
	static final int MAX_CHAR = 26;

	private String longestKSubStr(String str, int k) {
		int uniqChars = numOfUniqChars(str);
		if (uniqChars < k) {
			throw new IllegalArgumentException("uniqChars " + uniqChars + " is less than " + k);
		}
		int maxSubStringIndex = 0;
		int maxSubStringLen = 0;
		int currStart = 0;
		int[] count = new int[MAX_CHAR];
		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i) - 'a']++;
			int u = numOfUniqChars(count);
			while (u > k) {
				count[str.charAt(currStart) - 'a']--;
				currStart++;
				u = numOfUniqChars(count);
			}
			if (i - currStart + 1 > maxSubStringLen) {
				maxSubStringIndex = currStart;
				maxSubStringLen = i - currStart + 1;
			}
		}
		System.out.println("maxSubStringIndex = " + maxSubStringIndex + " maxSubStringLen = " + maxSubStringLen);
		return str.substring(maxSubStringIndex, maxSubStringIndex + maxSubStringLen);
	}

	private int numOfUniqChars(int[] count) {
		int uniqCharCount = 0;
		for (int i = 0; i < MAX_CHAR; i++) {
			if (count[i] > 0) {
				uniqCharCount++;
			}
		}
		return uniqCharCount;
	}

	private int numOfUniqChars(String str) {
		int[] count = new int[MAX_CHAR];
		for (char c : str.toCharArray()) {
			count[c - 'a']++;
		}
		int uniqCharCount = 0;
		for (int i = 0; i < MAX_CHAR; i++) {
			if (count[i] > 0) {
				uniqCharCount++;
			}
		}
		return uniqCharCount;
	}

	public static void main(String[] args) {
		LongestSubStringWithKUniqChar s = new LongestSubStringWithKUniqChar();
		// String str = "eaabbaacd";
		String str = "aabacbebebe";
		System.out.println(s.longestKSubStr(str, 3));
	}
}
