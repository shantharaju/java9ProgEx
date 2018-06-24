package Strings;

public class CamelCase {

	static int findNumWords(String str) {
		if(str == null || str.isEmpty()) {
			return 0;
		}
		int wordCount=1;
		for(int i=1; i<str.length(); i++) {
			if(Character.isUpperCase(str.charAt(i))) wordCount++;
		}
		return wordCount;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "detailedProgSimL";
		System.out.println(findNumWords(str));
	}

}
