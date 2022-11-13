
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	static HashMap<Character, Integer> pressMap = new HashMap<>();
	static HashMap<Character, Integer> keyMap = new HashMap<>();
	static String[] map = {"_", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i=2;i<map.length;i++) {
			String s = map[i];
			for (int j=0;j<s.length();j++) {
				char c = s.charAt(j);
				pressMap.put(c,j+1);
				keyMap.put(c, i);
			}
		}
		
		
		Scanner sc = new Scanner(System.in);
		
		String message = sc.nextLine();
		while (!message.equals("halt")) {
			int time = getTime(message);
			System.out.println(time);
			message = sc.nextLine();
		}
	}

	private static int getTime(String message) {
		// TODO Auto-generated method stub
		int time = 0;
		char preChar = '\0';
		for (int i=0;i<message.length();i++) {
			char c = message.charAt(i);
			time += getCharTime(preChar, c);
			preChar = c;
		}
		return time;
	}

	private static int getCharTime(char preChar, char c) {
		// TODO Auto-generated method stub
		int keyPre;
		if (preChar == '\0') 
			keyPre = -1;
		else
			keyPre = keyMap.get(preChar);
		int key = keyMap.get(c);
		int press = pressMap.get(c);
		int time = press;
		if (keyPre == key) {
			time += 2;
		}
		return time;
	}

		
	

	
}
