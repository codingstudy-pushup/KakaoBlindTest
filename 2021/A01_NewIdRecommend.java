package zKakao_2021;

public class NewIdRecommend {

	public static void main(String[] args) {
		NewIdRecommend a = new NewIdRecommend();
		String s = "...!@BaT#*..y.abcdefghijklm";
//		"bat.y.abcdefghi";
//	    "z-+.^.", "z--"
//	    "=.=", "aaa"
//	    "123_.def", "123_.def"
//	    "abcdefghijklmn.p", "abcdefghijklmn"
		System.out.println("===result===");
		System.out.println(a.solution1(s));

	}

	public String solution1(String new_id) {
		String str = "";
		// 1
		String temp = new_id.toLowerCase();

		// 2
		for (int i = 0; i < temp.length(); i++) {
			char c = temp.charAt(i);
			if ((c >= 'a' && c <= 'z') || c == '-' || c == '_' || c == '.' || Character.isDigit(c)) {
				str += Character.toString(c);
			}
		}
		// 3
		while (str.indexOf("..") >= 0) {
			str = str.replace("..", ".");
		}

		// 4
		if (str.charAt(0) == '.') {
			str = str.substring(1, str.length());
		}
		if (str.length() > 0 && str.charAt(str.length() - 1) == '.') {
			str = str.substring(0, str.length() - 1);
		}

		// 5
		if (str.equals("")) {
			str = "a";
		}

		// 6
		if (str.length() >= 16) {
			str = str.substring(0, 15);
			if (str.length() > 0 && str.charAt(14) == '.') {
				str = str.substring(0, 14);
			}
		}

		// 7
		if (str.length() <= 2) {
			char c = str.charAt(str.length() - 1);
			while (str.length() != 3) {
				str += Character.toString(c);
			}
		}
		return str;
	}

}
