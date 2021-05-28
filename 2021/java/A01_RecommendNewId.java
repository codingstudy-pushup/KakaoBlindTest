package zKakao_2021;

public class NewIdRecommend {

	public static void main(String[] args) {
		NewIdRecommend a = new NewIdRecommend();
//		String s = "...!@BaT#*..y.abcdefghijklm";
		String s = "=.=";
//		"bat.y.abcdefghi";
//	    "z-+.^.", "z--"
//	    "=.=", "aaa"
//	    "123_.def", "123_.def"
//	    "abcdefghijklmn.p", "abcdefghijklmn"
//		System.out.println("===result===");
//		System.out.println(a.solution1(s));
		a.solution1(s);

	}

	public String solution1(String new_id) {
		
		// 1
		System.out.println("1new_id: "+new_id);
		String str ="";
		
		String temp = new_id.toLowerCase();
		System.out.println("1new_id: "+temp);
		
		//2 charAt(i)
		for(int i=0; i<temp.length(); i++) {
			char c = temp.charAt(i);
//			System.out.println("c "+c);
//			 (c >='a'&& c <='z')
			if( Character.isLetter(c)||c == '-' || c == '_' || c == '.' || 
				Character.isDigit(c)){
				str += Character.toString(c);
			}
		}
		System.out.println("2new_id: "+str);
		
	    // 3
		while(str.indexOf("..") >= 0){
			System.out.println("str.indexOf: "+str.indexOf(".."));
		      str = str.replace("..", ".");
		      System.out.println("3new_id: "+str);
	     }

		//4
		if(str.charAt(0)=='.') {
			str = str.substring(1, str.length());
			System.out.println("4new_id: "+str);
		}
	
		//5
		if(str.equals("")) {
			str = "a";
		}
		System.out.println("5new_id: "+str);
		
		//6
		if(str.length() >= 16) {
			System.out.println("6new_id: "+str.length());
			str = str.substring(0, 15);
			System.out.println("62new_id: "+str);
			System.out.println("62new_id: "+str.length());//15
            if(str.length() > 0 && str.charAt(14) == '.'){
                str = str.substring(0, 14);
                System.out.println("63new_id: "+str);
            }

		}
		//7  a=>aaa
		 if(str.length() <= 2){
	            char c = str.charAt(str.length()-1);
	            while(str.length() != 3){
	                str += Character.toString(c);
	            }
	        }

		
		
//		System.out.println("5new_id: "+str);
		
		return str;
	}

}
