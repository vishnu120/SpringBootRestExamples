package duplicate_character;

import java.util.HashMap;
import java.util.Iterator;

public class DuplicateCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findDuplicateCharacter("i am a java programmer");

	}

	private static void findDuplicateCharacter(String string) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> hm = new HashMap<>();
		char c = 0;
		String sh[] = string.split(" ");
		for (String str : sh) {
			System.out.println(str);
		}
		for (int i = 0; i < string.length(); i++) {

			if (string.charAt(i) != ' ') {
				c = string.charAt(i);
				if (hm.get(c) != null) {
					hm.put(c, hm.get(c) + 1);
				} else
					hm.put(c, 1);
			}

		}

		System.out.println(hm);
		Iterator<Character> it = hm.keySet().iterator();
		while (it.hasNext()) {
			char ch = it.next();
			if (hm.get(ch) > 1) {
				System.out.println(ch + " has repeated " + hm.get(ch) + " times");
			}

		}

	}

}
