package dsa.ch4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reverser {

	private Stack<Character> chars;

	public Reverser() {
		this.chars = new Stack<Character>(Character.class);
	}

	public void reverse() throws IOException {
		char[] chrs = read();
		for (char c : chrs) {
			chars.push(c);
		}
		int idx = 0;
		while (!chars.isEmpty()) {
			chrs[idx++] = chars.pop();
		}
		System.out.println("Reverse: " + new String(chrs));
	}

	public char[] read() throws IOException {
		System.out.print("Please enter a string: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println("String: " + str);
		return str.toCharArray();
	}

	public static void main(String[] args) throws IOException {
		new Reverser().reverse();
	}

}
