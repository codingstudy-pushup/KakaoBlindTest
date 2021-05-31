package zKakao_2021;

import java.util.*;

public class A02_MenuRenewal11 {
	public static void main(String[] args) {
		A02_MenuRenewal a = new A02_MenuRenewal();

		String[] s1 = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] aa1 = { 2, 3, 4 };
		String[] s2 = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
		int[] aa2 = { 2, 3, 5 };
		String[] s3 = { "XYZ", "XWY", "WXA" };
		int[] aa3 = { 2, 3, 4 };
		String[] res = a.solution(s1, aa1);
		for (int i = 0; i < res.length; i++)
			System.out.print(res[i] + " ");
//	        System.out.println();
//	        res = solution(s2, aa2);
//	        for (int i=0; i<res.length; i++)
//	            System.out.print (res[i]+ " ");
//	        System.out.println();
//	        res = solution(s3, aa3);
//	        for (int i=0; i<res.length; i++)
//	            System.out.print (res[i]+ " ");
		System.out.println();
	}

	public Map<String, Integer> map = new HashMap<>();

	public String[] solution(String[] orders, int[] course) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < orders.length; i++) {
			char[] ch = orders[i].toCharArray();
			Arrays.sort(ch);
			for (int j = 0; j < course.length; j++) {
				if (course[j] <= orders[i].length()) {

					dfs(ch, course[j], "", 0);
				}
			}
		}

		List<String> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, (o1, o2) -> map.get(o2) - map.get(o1));

		for (int i = 0; i < course.length; i++) {
			System.out.println("course[" + i + "] " + course[i]);
			int max_value = 0;

			for (String key : keySetList) {
				if (map.get(key) >= 2 && key.length() == course[i]) {
					System.out.println("22key " + key);
					if (map.get(key) >= max_value) {
						list.add(key);
						max_value = map.get(key);
						System.out.println("22key " + key + " max_value " + max_value);
					}
				}
			}
		}
		Collections.sort(list);
		String[] answer = new String[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}

	public void dfs(char[] ch, int course, String result, int start) {
		for (char c : ch)
//			System.out.print(""+c);
//		System.out.println();
//		System.out.println("course:"+course+" result:"+result+" start:"+start);
			if (course == 0) {
				map.put(result, map.getOrDefault(result, 0) + 1);
				return;
			}
		for (int i = start; i < ch.length; i++) {
			dfs(ch, course - 1, result + ch[i], i + 1);
		}
	}
}
