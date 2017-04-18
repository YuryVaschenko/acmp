import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);
		StringBuilder stb = new StringBuilder();

		int number = 0;
		char operation = '+';
		int calculationResult = 0;
		int sentenceResult = 0;
		String validationString = "";

		if (sc.hasNextLine()) {
			validationString = sc.nextLine();
		} else {
			writer.print("ERROR");
			writer.flush();
			writer.close();
			System.exit(0);
		}
		Pattern p = Pattern.compile("[\\-||\\+]?\\d+[\\+|\\-|\\*|\\/][\\-||\\+]?\\d+[=][\\-||\\+]?\\d+");
		if (!p.matcher(validationString).matches()) {
			writer.print("ERROR");
			writer.flush();
			writer.close();
			System.exit(0);
		}

		char[] template = validationString.toCharArray();

		for (int i = 0; i < template.length;) {

			stb = new StringBuilder();

			if (template[i] == '-' || template[i] == '+') {
				stb.append(template[i]);
				i++;
			}

			for (int j = i; j < template.length - 1; j++) {
				stb.append(template[j]);

				if (template[j + 1] == '=') {
					calculationResult = calculationAB(number, toNumber(stb.toString(), writer), operation);
					stb = new StringBuilder();
					for (int k = j + 2; k < template.length; k++) {
						stb.append(template[k]);
						i = k + 1;
					}
					sentenceResult = toNumber(stb.toString(), writer);
					break;
				}

				if (template[j + 1] == '+' || template[j + 1] == '-' || template[j + 1] == '*'
						|| template[j + 1] == '/') {
					number = toNumber(stb.toString(), writer);
					operation = template[j + 1];
					i = j + 2;
					break;
				}
			}

		}

		if (sentenceResult == calculationResult) {
			writer.print("YES");
		} else {
			writer.print("NO");
		}
		writer.flush();
		writer.close();
		sc.close();

	}

	private static int toNumber(String str, PrintWriter writer) {
		int number = 0;

		try {
			number = Integer.parseInt(str);
		} catch (NumberFormatException e) {
			writer.print("ERROR");
			writer.flush();
			writer.close();
			System.exit(0);
		}

		return number;

	}

	private static int calculationAB(int a, int b, char sign) {

		if (sign == '+') {
			return a + b;
		}
		if (sign == '-') {
			return a - b;
		}
		if (sign == '*') {
			return a * b;
		}
		if (sign == '/') {
			if (b == 0 || a % b != 0) {
				try {
					PrintWriter writer = new PrintWriter("output.txt");
					writer.print("NO");
					writer.flush();
					writer.close();
					System.exit(0);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}

			return a / b;
		}
		return 0;
	}

}
