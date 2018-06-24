package hackerrank;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeConversion {

	/*
	0AM
	1AM
	11AM
	12PM
	01PM
	02PM
	..
	11PM
	*/
	public static void main(String[] args) {
		String format1 = "01:03:10PM";	
		String patternString = "^(\\d\\d):(\\d\\d):(\\d\\d)(\\D\\D)$";
		Pattern pattern = Pattern.compile(patternString);
		Matcher matcher = pattern.matcher(format1);
		while(matcher.find()) {
			String hrStr = matcher.group(1);
			String minStr = matcher.group(2);
			String secStr = matcher.group(3);
			String ampmStr = matcher.group(4);
			int hr = Integer.parseInt(hrStr);
			if(ampmStr.equals("PM")) {
				if(hr < 12) {
					hr += 12;
				}
			}
			String output = String.format("%02d:%s:%s", hr,minStr, secStr);
			System.out.println(output);
			
		}
	}
}
