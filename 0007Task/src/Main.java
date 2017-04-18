
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);

		String resultString;
		String basicLine = sc.nextLine();
		String[] dividedString = basicLine.split(" ");

		resultString = compareStrings(dividedString[0], dividedString[1]);
		resultString = compareStrings(resultString, dividedString[2]);

		writer.print(resultString);
		writer.flush();
		sc.close();

	}

	private static String compareStrings(String string, String string2) {

		if (string.length() == string2.length()) {
			char[] ch1 = string.toCharArray();
			char[] ch2 = string2.toCharArray();
			for (int i = 0; i < ch1.length; i++) {
				if (Integer.valueOf(ch1[i]) > Integer.valueOf(ch2[i])) {
					return string;
				} else if (Integer.valueOf(ch1[i]) < Integer.valueOf(ch2[i])) {
					return string2;
				}
			}
			return string;
		}
		return string.length() > string2.length() ? string : string2;
	}

}
