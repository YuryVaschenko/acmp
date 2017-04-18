import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);

		char[] firstTemplate = sc.nextLine().toCharArray();
		char[] secondTemplate = sc.nextLine().toCharArray();
		int resultcount = compareSequences(firstTemplate, secondTemplate);
		
		writer.print(resultcount);
		writer.flush();
		writer.close();
		sc.close();
		
	}

	private static int compareSequences(char[] firstTemplate, char[] secondTemplate) {

		int resultCount = 1;
		Set<Character> firstSet;
		Set<Character> secondSet;

		for (int i = 0; i < firstTemplate.length; i++) {
			firstSet = createSet(firstTemplate[i]);
			secondSet = createSet(secondTemplate[i]);
			firstSet.retainAll(secondSet);
			resultCount *= firstSet.size();
		}

		return resultCount;
	}

	private static Set<Character> createSet(char ch) {

		Set<Character> rawSet = new HashSet<>();

		if (Character.isDigit(ch)) {
			rawSet.add(ch);
			return rawSet;
		}
		if (ch == '?') {
			for (int i = '0'; i <= '9'; i++) {
				rawSet.add((char) i);
			}
			return rawSet;
		}

		for (int i = 0; i < 7; i++) {
			if (ch == 'a' + i) {
				for (int j = '0'; j < '4'; j++) {
					rawSet.add((char) (j + i));
				}
				break;
			}
		}

		return rawSet;
	}

}
