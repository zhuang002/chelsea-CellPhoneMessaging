
import java.util.Scanner;

public class Main {
	
	static String[] map = {"_", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
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
		int keyPre = getKey(preChar);
		int key = getKey(c);
		int press = getPress(c, key);
		int time = press;
		if (keyPre == key) {
			time += 2;
		}
		return time;
	}

	private static int getPress(char c, int key) {
		// TODO Auto-generated method stub
		String s = map[key];
		return s.indexOf(c)+1;
	}

	private static int getKey(char c) {
		// TODO Auto-generated method stub
		for (int i=0;i<map.length;i++) {
			String s = map[i];
			if (s.indexOf(c) >=0) {
				return i;
			}
		}
		return -1;
	}
	
	

	
}
