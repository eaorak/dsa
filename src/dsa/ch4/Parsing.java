package dsa.ch4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Parsing {

	enum Brackets {

		PR('(', ')'), //
		SB('[', ']'), //
		CB('{', '}');

		private char open;
		private char close;

		private Brackets(char open, char close) {
			this.open = open;
			this.close = close;
		}

		public static boolean isOpener(char c) {
			for (Brackets b : values()) {
				if (b.open == c) {
					return true;
				}
			}
			return false;
		}

		public static boolean isCloser(char c) {
			for (Brackets b : values()) {
				if (b.close == c) {
					return true;
				}
			}
			return false;
		}

		public static boolean matches(char o, char c) {
			for (Brackets b : values()) {
				if (b.open == o && b.close == c) {
					return true;
				}
			}
			return false;
		}

	}

	private Stack<Character> stack;

	public Parsing() {
		stack = new Stack<Character>(Character.class);
	}

	public boolean isValid(String str) {
		char[] chars = str.toCharArray();
		System.out.println("Input : " + new String(chars));
		int idx = 0;
		for (char c : chars) {
			if (Brackets.isOpener(c)) {
				stack.push(c);
				System.out.println("Opener: " + c);
			}
			if (Brackets.isCloser(c)) {
				Character opener = stack.pop();
				System.out.println("Closer: " + c);
				if (opener == null || !Brackets.matches(opener, c)) {
					System.out.printf("Invalid bracket at index [%d] : %c !\n", idx, c);
					return false;
				}
			}
			idx++;
		}
		return true;
	}

	public char[] read() throws IOException {
		System.out.print("Please enter a string: ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String str = reader.readLine();
		System.out.println("String: " + str);
		return str.toCharArray();
	}

	public static void main(String[] args) throws IOException {
		Parsing parsing = new Parsing();
		System.out.println("Valid: " + parsing.isValid("a(1*(2+3)[100]{1})]"));
	}

}
