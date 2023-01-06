package info;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckRegexImpl implements CheckRegex {

	@Override
	public int checkIdByRegex(String line) {
		Pattern p = Pattern.compile("[a-z0-9]{1,8}");
		Matcher m = p.matcher(line);
		
		if (m.matches()) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public int checkPwByRegex(String line) {
		Pattern p = Pattern.compile("\\w{1,6}");
		Matcher m = p.matcher(line);
		
		if (m.matches()) {
			return 1;
		} else {
			return -1;
		}
	}

	@Override
	public int checkNnByRegex(String line) {
		Pattern p = Pattern.compile("[ㄱ-힣]{1,6}");
		Matcher m = p.matcher(line);
		
		if (m.matches()) {
			return 1;
		} else {
			return -1;
		}
	}

}
