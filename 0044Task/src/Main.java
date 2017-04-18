
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PrintWriter writer = new PrintWriter(System.out);

		char[] template = null;

		if (sc.hasNext()) {
			template = sc.nextLine().toCharArray();
		}

		int resultcount = 0;
		if (template != null && template.length > 4) {
			for (int i = 0; i < template.length - 4; i++) {

				if (template[i] == '>' && template[i + 1] == '>' && template[i + 2] == '-' && template[i + 3] == '-'
						&& template[i + 4] == '>') {
					resultcount++;
				}
				if (template[i] == '<' && template[i + 1] == '-' && template[i + 2] == '-' && template[i + 3] == '<'
						&& template[i + 4] == '<') {
					resultcount++;
				}

			}
		}

		writer.print(resultcount);
		writer.flush();
		sc.close();

	}

}
